/**
 * Created by Muhammad Ali Qadri on 3/3/2017.
 */
public class MergeSort {

    private void merge(long arr[], int start, int mid, int end, Analyzer test){

        int n1 = mid - start + 1, n2 = end - mid;
        long L[] = new long[n1 + 1], R[] = new long[n2 + 1];
        int i = 0, j = 0;

        System.arraycopy(arr, start, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        test.exchange += n1 + n2;

        L[n1] = Long.MAX_VALUE;
        R[n2] = Long.MAX_VALUE;

        for(int k = start; k <= end; k++){
            if(L[i] < R[j])
                arr[k] = L[i++];
            else
                arr[k] = R[j++];
            test.comparison++; test.exchange++;
        }
    }

    public void recursiveMergeSort(long arr[], int start, int end, Analyzer test){

        if(start < end){
            int mid = (int)Math.floor((start + end) /2 );
            recursiveMergeSort(arr, start, mid, test);
            recursiveMergeSort(arr, mid + 1, end, test);
            merge(arr, start, mid, end, test);
        }
    }

    void iterativeMergeSort(long []arr, int n, Analyzer test){

        for (int blockSize = 1; blockSize <= n; blockSize *= 2){
            int start = 0;
            int end = ((2*blockSize) - 1);
            while (start < n){
                int mid = (int)((start + end) / 2);

                if (end > n) end = n;
                if (mid > n) mid = n;

                merge(arr, start, mid, end, test);
                start = end + 1;
                end += ((2 * blockSize));
            }
        }
    }
}
