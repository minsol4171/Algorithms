import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {3, 5, 7, 8, 9, 12, 15};
		
		int result = binarySearch(arr, 0, arr.length-1, 9);
		System.out.println(result);
		
	}
	
	public static int binarySearch(int arr[], int first, int last, int key) {
		
		if(first <= last) {
			//mid=(first + last)/2 로 쓰면 오류 발생할 수 있음
			int mid = first + (last - first)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			else if(arr[mid] > key) {
				return binarySearch(arr, first, mid-1, key);
			}
			else {
				return binarySearch(arr, mid+1, last, key);
			}
		}
		return -1;

	}

}
