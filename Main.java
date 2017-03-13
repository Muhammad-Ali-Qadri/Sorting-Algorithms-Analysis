import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Muhammad Ali Qadri on 3/3/2017.
 */
public class Main {
    public static void main(String[] args) {

        Analyzer test = new Analyzer();

        InsertionSort is = new InsertionSort();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();

        Random rand = new Random();

        int lim = 100;
        long initTime = 0, comp = 0, swap = 0;
        double avrg = 0;

        long arr[] = null;

        for(int j = 0; j < 5; j++){
            for(int k = 0; k < 5; k++){
                arr = new long[lim];

                for(int i = 0; i < lim; i++){
                    arr[i] = ThreadLocalRandom.current().nextLong((long)(Math.pow(2, 32)) - 1L);
                }

                initTime = System.nanoTime();

                is.applyInsertionSort(arr, test);
                //ms.recursiveMergeSort(arr, 0, arr.length - 1, test);
                //ms.iterativeMergeSort(arr, arr.length - 1, test);
                //qs.deterministicQuickSort(arr, 0, arr.length - 1, test);
                //qs.randomizedQuickSort(arr, 0, arr.length - 1, test);
                //hs.heapSort(arr, test);

                avrg = avrg + (System.nanoTime() - initTime);
                comp = comp + test.comparison;
                swap = swap + test.exchange;
                test.reset();
            }

            System.out.println("Number of elements : " + lim + "\nTime taken : " + avrg/5000000d + "ms\n" +
                    "Comparisons: " + comp/5L + "\nExchange operations: " + swap/5L);

            lim = lim * 10; comp = swap = 0;
            avrg = 0;
        }
    }
}
