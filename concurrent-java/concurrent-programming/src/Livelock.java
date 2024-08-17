//does not simulate livelock
public class Livelock implements Runnable{
    Integer a;
    boolean incr;
    Livelock(Integer a, boolean incr) {
        this.a= a;
        this.incr= incr;
    }

    @Override
    public void run() {
        if(incr) increment();
        else decrement();
    }

    void increment() {
        do {
            synchronized (a) {
                a++;
                System.out.println("a is " + a);
            }
        } while(a < 2);
    }

    void decrement() {
        do {
            synchronized (a) {
                a--;
                System.out.println("a is " + a);
            }
        } while(a > -2);
    }

    public static void main(String[] args) {
        Integer a= 0;
        Livelock l1= new Livelock(a, true);
        Livelock l2= new Livelock(a, false);
        Thread thread1= new Thread(l1);
        Thread thread2= new Thread(l2);
        thread1.start();
        thread2.start();
    }
}
