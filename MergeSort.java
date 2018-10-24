import java.util.Random;
import java.lang.Math;

public class MergeSort{

	public static void sort(int[] arr){
        sort(arr, 0, arr.length);
    }

    public static void sort(int arr[], int left, int right) { 
        if (left < right){ 
            int mid = (left+right)/2; 
            sort(arr, left, mid); 
            sort(arr , mid+1, right); 
            merge(arr, left, mid, right); 
        }
    }

    public static void merge(int targArr[], int l, int m, int r){
        int sizeL = m - l + 1;
        int sizeR = r - m;
        int arrL[] = new int [sizeL];
        int arrR[] = new int [sizeR];
        for (int i=0; i<sizeL; i++){
            arrL[i] = targArr[l + i]; 
        }
        for (int i=0; i<sizeR; i++){
            arrR[i] = targArr[m+1+i]; 
        }
        int left = 0;
        int right = 0;
        int target = l;
        while(left < sizeL && right < sizeR){
            if(arrL[left] <= arrR[right]){
                targArr[target++] = arrL[left++];
            }else{
                targArr[target++] = arrR[right++];  
            }
        }
        while(left < sizeL){
            targArr[target++] = arrL[left++];   
        }
        while(right < sizeR){
            targArr[target++] = arrR[right++];
        }
    }

    public static void main(String[] args){
        int[] tests = new int[]{15000,30000,50000,100000};
        for(int t = 0; t < tests.length; t++){
            int[] arr = new int[tests[t]];
            int count = 0;
            Random rand = new Random();

            for(int i = 0; i < arr.length - 1; i++){
                int r = rand.nextInt();
                arr[count++] = r;
            }

            long startTime = System.currentTimeMillis();
            sort(arr);
            long endTime = System.currentTimeMillis();

            System.out.println("That took " + (endTime - startTime) + " milliseconds");
        }
    }
}