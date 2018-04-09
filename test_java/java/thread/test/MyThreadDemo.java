package thread.test;

public class MyThreadDemo {

    public static void main(String[] args) {
        int n = 100;

        Inc inc = new Inc();
        Dec dec = new Dec();
        new Thread(inc).start();
        new Thread(dec).start();
    }
}

class Inc extends Thread {

    @Override
    public void run() {

    }

}

class Dec extends Thread {

    @Override
    public void run() {

    }
}