package sorting_algorithms;
//some simple sorting algorithms implemented in java

public class algos {
	public static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public static void bubbleSort(int[] in) {
		int size = in.length;
		for (int i=0; i<(size-1); i++) {
			for (int j=i+1; j<size; j++) {
				if(in[i] > in[j]) {
					swap(in, i, j);
				}
			}
		}
	}
	
	public static void selectionSort(int[] in) {
		int size = in.length;
		for (int i=0; i<size - 1; i++) {
			int min = i;
			for (int j=i+1; j<size; j++) {
				if(in[min] > in[j]) {
					min = j;
				}
			}
			swap(in, i, min);
		}
	}
	
	public static void mergeSort(int[] in, int begin, int end) {
		int size = in.length;
		int[] temp = new int[size];
		if (begin > end) {
			return;
		}
		else if (end-begin > 1) {
			int middle = (begin + end)/2;
			mergeSort(in, begin, middle);
			mergeSort(in, middle+1, end);
			mergeHalves(in, temp, begin, middle, end);
		}
		
		
	}
	
	public static void mergeHalves(int[] array, int[] temp, int start, int middle, int end) {
		for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = temp[i];
            k++;
            i++;
        }
	}
	
	public static void main(String[] args)
	{
		int[] pizza = {2, 7, 3, 8, 891, 1, 99, -2, 4};
		
		for (int i:pizza) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		mergeSort(pizza, 0, pizza.length-1);
		
		for (int i:pizza) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
