package ProductorConsumidor;

import java.util.Random;

public class Productor extends Thread {
    private ColaCompartida colaCompartida;
    private Random random = new Random();

    public Productor(ColaCompartida colaCompartida) {
        this.colaCompartida = colaCompartida;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                int value = random.nextInt(100) + 1;
                colaCompartida.producir(value);
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
