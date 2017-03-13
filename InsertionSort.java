/**
 * Created by Muhammad Ali Qadri on 3/3/2017.
 */
public class InsertionSort {
    public void applyInsertionSort(long []arr, Analyzer test){

        long key = 0;
        int i = 0;

        for(int j = 0; j < arr.length; j++){
            key = arr[j];
            i = j - 1;
            while(i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i--;
                test.comparison++; test.exchange++;
            }
            arr[i + 1] = key;
            test.exchange++;
        }
    }
}
