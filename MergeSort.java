import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int array[] = new int[8];
		System.out.println("8개 정수 입력: ");
		for (int i = 0; i < array.length; i++) {
			int n = scanner.nextInt();
			array[i] = n;
		}
		
		mergeSort(array, 0, array.length-1);
		
		System.out.println("정렬된 배열: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
	
	static void mergeSort(int arr[], int p, int r) {
		
		if(p < r) {
			//p가 r보다 작은 경우에만 재귀호출 (배열 크기가 1 이상일 때)
			//p=r이 될 때 (배열의 크기가 1일때) 재귀 끝남. 다음 코드로 넘어감			

			int q = (p + r) / 2;
			mergeSort(arr, p, q);	//p부터 q까지의 부분 배열 정렬
			mergeSort(arr, q+1, r);	//q+1부터 r까지의 부분 배열 정렬
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int arr[], int p, int q, int r) {
		
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int Left[] = new int[n1];
		int Right[] = new int[n2];
		
		//왼쪽, 오른쪽 배열 복사
		for (int i = 0; i < n1; i++) {
			Left[i] = arr[p + i];
		}
		for (int j = 0; j < n2; j++) {
			Right[j] = arr[q + j + 1];
		}

		
		int i = 0, j = 0;
		int k = p;
		
		while(i < n1 && j < n2) {
			if(Left[i] <= Right[j]) {
				arr[k] = Left[i];
				i++;
			}
			else {
				arr[k] = Right[j];
				j++;
			}
			k++;
		}
		
		//왼쪽 배열이 남아있는 경우 복사
		while(i<n1) {
			arr[k] = Left[i];
			i++;
			k++;
		}
		
		//오른쪽 배열이 남아있는 경우 복사
		while(j<n2) {
			arr[k] = Right[j];
			j++;
			k++;
		}
	}

}
