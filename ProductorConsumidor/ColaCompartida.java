package ProductorConsumidor;

import java.util.LinkedList;
import java.util.Queue;

public class ColaCompartida {
    private Queue<Integer> queue = new LinkedList<>();
    private final int capacidad;

    public ColaCompartida(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void producir(int value) throws InterruptedException {
        while (queue.size() == capacidad) {
            wait();
        }
        queue.add(value);
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        notifyAll();
        return value;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
