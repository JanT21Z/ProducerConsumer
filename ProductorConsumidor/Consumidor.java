package ProductorConsumidor;

public class Consumidor extends Thread {
    private ColaCompartida colaCompartida;
    private int[] count =new int[10];

    public Consumidor(ColaCompartida colaCompartida) {
        this.colaCompartida = colaCompartida;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = colaCompartida.consumir();
                categorize(value);
                if(colaCompartida.isEmpty()){
                    break;
                }
            }
            printResults();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    private void categorize(int value){
        if (value >= 1 && value <=100){
            int index = (value -1)/10;
            count[index]++;
        }
    }

    private void printResults(){
        for (int i = 0; i < count.length; i++) {
            System.out.println("Números entre " + (i * 10 + 1) + " y " + (i * 10 + 10) + " = " + count[i]);
        }
    }
}
