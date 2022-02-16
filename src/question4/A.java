package question4;

public class A {

    public synchronized void test(B b){
        System.out.println(" a class ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.last();
    }

    public synchronized void last(){
        System.out.println("last B");
    }
}
class B{
    public synchronized void test(A a){
        System.out.println(" b class ");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.last();
    }

    public synchronized void last(){
        System.out.println("last A");
    }
}
