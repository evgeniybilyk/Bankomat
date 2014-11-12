class Employer implements Runnable {

    private static int amount = 1000;
    private static int timeout = 1000;

    @Override
    public void run() {
//        System.out.println("[" + Thread.currentThread().getName() + "] Putting money to Bankomat: " + amount);
        Bankomat.addSum(amount);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

class Employee implements Runnable {

    private static int amount = 100;
    private static int timeout = 1000;

    @Override
    public void run() {
//        System.out.println("[" + Thread.currentThread().getName() + "] Taking money from Bankomat: " + amount);
        Bankomat.subSum(amount);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

class Bankomat {
    private static int balance;

    public static int getBalance() {
        return balance;
    }

    public static synchronized void addSum(int money) {
        balance = balance + money;
        System.out.println("[" + Thread.currentThread().getName() + "] Adding money " + money + " Current ballance " + balance);
    }

    public static synchronized void subSum(int money) {
        balance = balance - money;
        System.out.println("[" + Thread.currentThread().getName() + "] Taking money " + money + " Current ballance " + balance);
    }
}

public class Main {
    public static void main (String[] args) {
//        Bankomat bankomat = new Bankomat();
        Employee employee = new Employee();
        Employer employer = new Employer();

        Thread employer1 = new Thread(employer);
        employer1.start();

        Thread employee1 = new Thread(employee);
        employee1.start();

        Thread employee2 = new Thread(employee);
        employee2.start();

        Thread employee3 = new Thread(employee);
        employee3.start();

        Thread employee4 = new Thread(employee);
        employee4.start();
    }
}
