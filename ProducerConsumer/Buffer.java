package ProducerConsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> buffer;

    private int tamanio;

    public Buffer(int tamanio) {

        this.tamanio = tamanio;
        buffer = new LinkedList<>();
    }

    public synchronized void producir(int item) throws InterruptedException{
        while (buffer.size() == tamanio){
            wait();
        }
        buffer.add(item);
         System.out.println("Producido: " + item);
         notifyAll();
    }

    public synchronized int consumidor() throws InterruptedException{
        while (buffer.isEmpty()){
            wait();
        }
        int item = buffer.poll();
        System.out.println("Consumido: " + item);
        notifyAll();
        return item;
    }
}
