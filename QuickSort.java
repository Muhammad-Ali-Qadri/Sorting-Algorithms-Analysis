import java.util.Random;

/**
 * Created by Muhammad Ali Qadri on 3/5/2017.
 */
public class QuickSort {
    public void deterministicQuickSort(long arr[], int start, int end, Analyzer test){
        if(start < end){
           int pivot = partition(arr, start, end, test);
           deterministicQuickSort(arr, start, pivot - 1, test);
           deterministicQuickSort(arr, pivot + 1, end, test);
        }
    }

    public void randomizedQuickSort(long arr[], int start, int end, Analyzer test){
        if(start < end){
           int pivot = randomPartition(arr, start, end, test);
            randomizedQuickSort(arr, start, pivot - 1, test);
            randomizedQuickSort(arr, pivot + 1, end, test);
        }
    }

    private int randomPartition(long arr[], int start, int end, Analyzer test){

        int piv = (new Random()).nextInt(end - start + 1) + start;

        exchange(arr, piv, end);
        test.exchange++;

        return partition(arr, start, end, test);
    }

    private int partition(long arr[], int start, int end, Analyzer test){
        long x = arr[end];
        int i = start - 1;
        for(int j = start; j < end; j++){
            if(arr[j] <= x){
                i++;
                exchange(arr, j, i);
                test.exchange++; test.comparison++;
            }
        }
        exchange(arr, i + 1, end);

        test.exchange++;
        return i + 1;
    }

    public static void exchange(long arr[], int ia, int ib){
        long temp = arr[ia];
        arr[ia] = arr[ib];
        arr[ib] = temp;
    }
}
