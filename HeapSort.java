
public class HeapSort {

	public static void main(String[] args) {
		
		int arr[] = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		
		int n = arr.length-1;
		buildHeap(arr, n);
		
		for(int i = n; i >= 0; i--) {
			int temp = arr[0];	//루트노드와 가장 마지막 노드를 바꾸고, 바뀐 마지막 노드를 제외한 나머지 원소들끼리 최대힙을 만든다. 
			arr[0] = arr[i];
			arr[i] = temp;
			n--;
			heapify(arr, 0, n);	//heapify함수로 전체 트리의 루트 노드(arr[0])에 가장 큰 원소가 오도록 만든다.
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void heapify(int arr[], int i, int n) {	//최대힙의 속성을 유지시키는 함수
		//i는 현재 노드, n은 전체 노드의 개수(마지막 노드)
		int largest = i;
		
		while(true) {	//힙 속성을 만족할 때까지 반복
			int left = 2*i + 1;		//왼쪽 자식노드
			int right = 2*i + 2;	//오른쪽 자식노드
			
			if(left <= n && arr[left] > arr[largest]) {	//왼쪽 자식노드가 있고 현재 노드보다 클 때 largest는 왼쪽 자식노드
				largest = left;
			}
			
			if(right <= n && arr[right] > arr[largest]) {	//오른쪽 자식노드가 있고 largest 노드보다 클 때 largest 업데이트
				largest = right;
			}
			
			if(largest != i) {	//largest가 i(현재 노드)가 아니면 현재노드와 largest노드 교체 -> largest를 현재노드로 업데이트(내려감)
				int temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;
				i = largest;
			}
			else break;
		}
	}
	
	public static void buildHeap(int arr[], int n) {
		for (int i = n/2; i >= 0; i--) {	//2/n에서 0으로 역진행하며 최대힙 생성
			heapify(arr, i, n);
		}
	}

}
