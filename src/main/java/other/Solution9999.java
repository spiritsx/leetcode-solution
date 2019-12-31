package other;

/**
 * 交替打印字母和数字
 * created at 2019/12/31
 *
 * @author shixi
 */
public class Solution9999 {

    private static final Object lock = new Object();

    static class LetterThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 'a');
                synchronized (lock) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class DigitThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    System.out.print(i);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new LetterThread().start();
        new DigitThread().start();
    }
}
