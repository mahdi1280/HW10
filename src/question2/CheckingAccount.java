package question2;

public class CheckingAccount {

    private int balance;
    private CheckingAccount(int initialBalance){
        balance = initialBalance;
    }

    public boolean withdraw(int amount){
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
        final CheckingAccount ca=new CheckingAccount(100);

        Runnable r=new Runnable() {
            @Override
            public void run() {
                String name=Thread.currentThread().getName();
                for(int i=0;i<10;i++)
                    System.out.println(name + " withdraw &10: "+
                    ca.withdraw(10));
            }
        };

        Thread thread=new Thread(r);
        thread.setName("Husband");
        Thread tdWife = new Thread(r);
        tdWife.setName("Wife");
        thread.start();
        tdWife.start();
    }
}
