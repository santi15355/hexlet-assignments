package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN

    public static void main(String[] args) {
        int[] numbers = {65, 6, 12, -123, 88, 266, 27, 1234, -12};
        System.out.println(getMinMax(numbers));
        LOGGER.info(App.getMinMax(numbers).toString());
    }

    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> result = new HashMap<>();
        MinThread minThread = new MinThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);
        minThread.start();
        LOGGER.info("Min number search started");
        maxThread.start();
        LOGGER.info("Max number search started");

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            LOGGER.info("Поток был прерван");
        }
        LOGGER.info("Threads are ready to show result");
        result.put("min", minThread.getMinNumber());
        result.put("max", maxThread.getMaxNumber());
        return result;
    }
    // END
}
