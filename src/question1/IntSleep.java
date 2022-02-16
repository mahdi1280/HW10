package question1;

public class IntSleep extends Thread {

    private boolean isFinish = true;

    @Override
    public void run() {

        while (true) {
            if (isFinish) {
                System.out.println("Hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(1);
                }
            }
            else
                break;
        }
    }

    public synchronized void setFinish(boolean finish) {
        isFinish = finish;
    }
}
