package ProducerConsumer;

public class Productor implements Runnable {

    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                buffer.producir(i);
                Thread.sleep(3000);
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

    }
}
