public class RaceConditionThreads {
    public static void main(String[] args) {
//        RaceCondition raceCondition= new RaceCondition();
//        Thread t1= new Thread(raceCondition);
//        Thread t2= new Thread(raceCondition);
//        t1.start();
//        t2.start();

        CheckThenActRaceConditon checkThenActRaceConditon= new CheckThenActRaceConditon();
        checkThenActRaceConditon.addToMap();
        Thread t3= new Thread(checkThenActRaceConditon);
        Thread t4= new Thread(checkThenActRaceConditon);
        t3.start();
        t4.start();
    }
}
