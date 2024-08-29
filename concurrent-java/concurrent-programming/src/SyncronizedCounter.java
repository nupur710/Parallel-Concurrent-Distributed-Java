public class SyncronizedCounter implements Runnable {
    private int c;
    private boolean operation;
    SyncronizedCounter(int c, boolean operation) {
        this.c= c;
        this.operation= operation;
    }
    public synchronized void increment() {
        this.c++;
    }
    public synchronized void decrement() {
        this.c--;
    }
    public synchronized int value() {
        return this.c;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            if (this.operation) {
                increment();
            } else {
                this.decrement();
            }
            System.out.println(Thread.currentThread().getName() + " updates int to " + value());
        }
    }

    public static void main(String[] args) {
        SyncronizedCounter cx= new SyncronizedCounter(5, true);
        Thread t1= new Thread(cx, "thread-1");
        Thread t2= new Thread(cx, "thread-2");
        Thread t3= new Thread(cx, "thread-3");
        Thread t4= new Thread(cx, "thread-4");
        Thread t5= new Thread(cx, "thread-5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
