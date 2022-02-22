package question2;

public class CheckingAccountFixed {

    private int balance;
    
    private CheckingAccountFixed(int initialBalance){
        balance = initialBalance;
    }

    // TODO: 2/15/2022 set synchronized 
    public synchronized boolean withdraw(int amount){
        if(amount<=balance){
            try {
                Thread.sleep((int) (Math.random()*200));
            } catch (InterruptedException e) {
            }
            balance-=amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final CheckingAccountFixed ca=new CheckingAccountFixed(100);
        Runnable r= () -> {
            String name=Thread.currentThread().getName();
            for(int i=0;i<10;i++)
                System.out.println(name + " withdraw &10: "+
                        ca.withdraw(10));
        };

        Thread thread=new Thread(r);
        thread.setName("Husband");
        Thread tdWife = new Thread(r);
        tdWife.setName("Wife");
        thread.start();
        tdWife.start();
    }
}
