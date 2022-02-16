package question5;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestThread thread=new TestThread();
        thread.start();
        thread.join();
        System.out.println("finish");
    }
}
