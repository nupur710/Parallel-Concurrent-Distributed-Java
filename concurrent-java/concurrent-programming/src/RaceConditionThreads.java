public class RaceConditionThreads {
    public static void main(String[] args) {
        RaceCondition raceCondition= new RaceCondition();
        Thread t1= new Thread(raceCondition);
        Thread t2= new Thread(raceCondition);
        t1.start();
        t2.start();
    }
}
