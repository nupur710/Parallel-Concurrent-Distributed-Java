public class Deadlock implements Runnable {
    Integer a;
    Integer b;
    Deadlock(Integer a, Integer b) {
        this.a= a;
        this.b= b;
    }

    @Override
    public void run() {
        synchronized (a) {
            System.out.println(a + " a is locked by: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (b) {
                System.out.println(b + " b is locked by: " + Thread.currentThread().getName());
                b++;
            }
        }
    }

    public static void main(String[] args) {
        Integer a= 1;
        Integer b= 2;
        //Thread 1 will lock a & then try to lock b
        Deadlock t1= new Deadlock(a, b);
        //Thread 2 will lock b & then try to lock a
        Deadlock t2= new Deadlock(b, a);
        Thread thread1= new Thread(t1);
        Thread thread2= new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
