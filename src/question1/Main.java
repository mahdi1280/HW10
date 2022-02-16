package question1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        IntSleep intSleep=new IntSleep();
        intSleep.start();
        Thread.sleep(2000);
        intSleep.setFinish(false);
    }
}
