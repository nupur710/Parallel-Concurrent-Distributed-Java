public class RaceCondition implements Runnable {
    Thread thread;
    /**
     * https://jenkov.com/tutorials/java-concurrency/race-conditions-and-critical-sections.html
     * There are 2 types of race condition- Read-Modify-Write & Check-Then-Write
     * Race condition occurs within a critical section where code is executed
     * by multiple threads & the sequence of execution alters the result
     *
     * Read-modify-write: two or more threads 1st read a variable, then modify its value
     * & write it back to the variable
     *
     * Check-then-write: two or more threads check a given condition then go on to act based on
     * this info. Problem: two or more threads check condition at the same time
     */

    protected static long no= 0;

    @Override
    public void run() {
        for(int i= 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            no += 5;
        }
        System.out.println(Thread.currentThread().getName() + " updates value to " + this.no);
    }
}
