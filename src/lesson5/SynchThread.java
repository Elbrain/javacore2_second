package lesson5;


import java.util.Arrays;

public class SynchThread {
    static final int ARRAY_SIZE = 10000000;
    static final int HALF_SIZE = ARRAY_SIZE / 2;

    public static void main(String[] args) throws InterruptedException {

        SynchThread syncThread = new SynchThread();
        methodOneThread();
        syncThread.methodTwoThreads();
    }

    public static float[] createArray() {
        float[] arr = new float[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = 1.0f;
        }
        return arr;
    }

    public static float[] calculateArray(float[] arr, int startPoint){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + startPoint) / 5) * Math.cos(0.2f + (i + startPoint) / 5) * Math.cos(0.4f + (i + startPoint) / 2));
        }
        return arr;
    }

    public static void methodOneThread() {
        float[] arr = createArray();
        long a = System.currentTimeMillis();
        calculateArray(arr, 0);
        System.out.println(System.currentTimeMillis() - a + "ms");
        float sum = 0;
        for (float v : arr) {
            sum = v + sum;
        }
        System.out.println("Сумма одного потока: " + sum);
    }


    public static void methodTwoThreads() throws InterruptedException {
        float[] arr = new float[ARRAY_SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        new Thread(() -> {
            float[] a1 = calculateArray(arr1, 0);
            System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        }).start();

        new Thread(() -> {
            float[] a2 = calculateArray(arr2, HALF_SIZE);
            System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);
        }).run();


        System.out.println(System.currentTimeMillis() - a + "ms");

        float sum = 0;
        for (float v : arr) {
            sum = v + sum;
        }
        System.out.println("Сумма двух потоков " + sum);
    }

}
