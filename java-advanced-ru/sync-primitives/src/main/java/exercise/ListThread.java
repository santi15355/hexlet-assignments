package exercise;

import java.util.Random;

// BEGIN
public class ListThread extends Thread {

    private SafetyList list;
    private final Random rand;

    public ListThread(SafetyList list) {
        this.list = list;
        rand = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(rand.nextInt(5000));
        }
    }
}
// END
