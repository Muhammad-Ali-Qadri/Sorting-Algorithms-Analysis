/**
 * Created by Muhammad Ali Qadri on 3/5/2017.
 */
public class HeapSort {
    private void maxHeapify(long arr[], int i, int heapSize, Analyzer test){
        int left = 2*i, right = (2*i) + 1, largest = 0;

        if(left <= heapSize && arr[left] > arr[i])
            largest = left;
        else
            largest = i;

        test.comparison++;

        if(right <= heapSize && arr[right] > arr[largest]) {
            largest = right;
            test.comparison++;
        }

        if(largest != i){
            QuickSort.exchange(arr, i, largest);
            test.exchange++;
            maxHeapify(arr, largest, heapSize, test);
        }
    }

    private void buildHeap(long arr[], Analyzer test){

        for(int i = (int) Math.floor((arr.length - 1)/2); i > 0; i--){
            maxHeapify(arr, i, arr.length - 1, test);
        }
    }

    public void heapSort(long arr[], Analyzer test){
        int heapSize = arr.length - 1;
        buildHeap(arr, test);

        for(int i = arr.length - 1; i > 1; i--){
            QuickSort.exchange(arr, 1, i);
            test.exchange++;
            heapSize--;
            maxHeapify(arr, 1, heapSize, test);
        }
    }
}
