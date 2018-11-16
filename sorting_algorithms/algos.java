package sorting_algorithms;

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
	
	public static int[] mergeSort(int[] in) {
		
		
		return in;
	}
	
	public static void main(String[] args)
	{
		int[] pizza = {2, 7, 3, 8, 891, 1, 99, -2, 4};
		
		for (int i:pizza) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		bubbleSort(pizza);
		
		for (int i:pizza) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
