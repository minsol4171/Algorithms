import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int array[] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			int input = scanner.nextInt();
			array[i] = input;
		}
		
		InsertionSort(array);
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j] + " ");

		}
	}
		
	static void InsertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
				
		}
	}	
	

}