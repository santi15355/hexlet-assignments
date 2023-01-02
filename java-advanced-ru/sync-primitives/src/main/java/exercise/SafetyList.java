package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int[] arr;
    private int size;

    public SafetyList() {
        this.arr = new int[20];
        size = 0;
    }

    public synchronized void add(int value) {
        if (arr.length - size == 1) {
            arr = Arrays.copyOf(arr, size + 20);
        }
        arr[size] = value;
        size = size + 1;
    }

    public int get(int idx) {
        return this.arr[idx];
    }

    public int getSize() {
        return this.size;
    }
    // END
}
