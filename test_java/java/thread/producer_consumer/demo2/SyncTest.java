package thread.producer_consumer.demo2;

/*	范例名称：生产者--消费者问题
 * 	源文件名称：SyncTest.java
 *	要  点：
 *		1. 共享数据的不一致性/临界资源的保护
 *		2. Java对象锁的概念
 *		3. synchronized关键字/wait()及notify()方法
 */

public class SyncTest {
    public static void main(String args[]) {
        SyncStack stack = new SyncStack();
        Runnable p = new Producer(stack);
        Runnable c = new Consumer(stack);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

/**
 * 支持多线程同步操作的堆栈的实现
 */
class SyncStack {
    private int index = 0;
    private char[] data = new char[6];

    public synchronized void push(char c) {
        while (index == data.length) {
            try {
                // 放弃对象锁，进入等待此对象的等待池
                // 只有其他线程调用Stack对象的notify()或notifyAll()方法才唤醒该线程
                wait();
            } catch (InterruptedException e) {
            }
        }
        notify();
        data[index] = c;
        index++;

        System.out.println("生产：" + c + " Stack:" + toString());
    }

    public synchronized char pop() {
        while (index == 0) {
            try {
                // 放弃对象锁，进入等待此对象的等待池
                // 只有其他线程调用Stack对象的notify()或notifyAll()方法才唤醒该线程
                wait();
            } catch (InterruptedException e) {
            }
        }

        // synchronized(){}语句块执行结束，自动释放对象锁
        notify();
        int last = --index;
        char top = data[last];
        data[last] = '\u0000';

        System.out.println("消费：" + top + " Stack:" + toString());

        return top;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                sb.append("[" + data[i] + ",");
            } else if (i == data.length - 1) {
                sb.append(data[i] + "]");
            } else {
                sb.append((data[i] == '\u0000' ? "-" : data[i]) + ",");
            }
        }

        return sb.toString();
    }
}

class Producer implements Runnable {
    SyncStack stack;

    public Producer(SyncStack s) {
        stack = s;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            char c = (char) (Math.random() * 26 + 'A');
            stack.push(c);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}

class Consumer implements Runnable {
    SyncStack stack;

    public Consumer(SyncStack s) {
        stack = s;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            stack.pop();
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
