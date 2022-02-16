package question4;

public class DeadLock implements Runnable{

    A a=new A();
    B b=new B();
    Thread t;
    public void startDeadLock(){
        t=new Thread(this);
        t.start();
        b.test(a);

    }
    @Override
    public void run() {
       a.test(b);
    }

    public static void main(String[] args) {
        DeadLock d=new DeadLock();
        d.startDeadLock();
    }
}
