import java.util.Random;
import java.lang.Math;

public class TimSort{

	public static void TimSort(int[] a, int runSize, int arrSize){
     	//find runs and sort each run using insertion sort
     	 for (int i = 0; i < arrSize; i += runSize){
     	 	int pos = i + 24999;
     	 	insertionSort(a, i, Math.min(pos, arrSize - 1)); 
     	 }
		for(int s = runSize; s < arrSize; s = s * 2){
        	for(int l = 0; l < arrSize; l += s * 2){ 
            	int m = l + s - 1; 
            	int r = Math.min((l + s * 2 - 1), (arrSize - 1));
           	    merge(a, l, m, r); 
        	} 
    	} 
     }

     public static void insertionSort(int[] arr, int left, int right){
		for(int i = left + 1; i < right; i++){
			int temp = arr[i];
			int n = i-1;
			while(n >= left && arr[n] > temp){
				arr[n + 1] = arr[n];
				n--;
			}
			arr[n + 1] = temp;
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
	public static void sort(int[] arr){
        TimSort(arr, 75000, arr.length);
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

			System.out.println("Took " + (endTime - startTime) + " milliseconds");
    	}
	}
}