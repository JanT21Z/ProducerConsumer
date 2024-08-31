package ProductorConsumidor;

public class ProductorConsumidor {
    public static void main(String[] args) {
        ColaCompartida colaCompartida = new ColaCompartida(10);
        Productor productor = new Productor(colaCompartida);
        Consumidor consumidor = new Consumidor(colaCompartida);

        productor.start();
        consumidor.start();

        try {
            productor.join();
            consumidor.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
