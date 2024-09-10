package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {
    private BlockingQueue<Integer> queue;

    public Buffer(int tamanio) {
        this.queue = new LinkedBlockingQueue<>(tamanio);
    }

    public void producir(int item) throws InterruptedException {
        queue.put(item);
        System.out.println("Producido: " + item);
    }

    public int consumidor() throws InterruptedException {
        int item = queue.take();
        System.out.println("Consumido: " + item);
        return item;
    }
}
