import java.util.ArrayList;

public class AllSorting {
      public static void main(String[] args) {
            int arr[] = {3, 4, 5, 1, 2};
            System.out.println("Befor sorting ");
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i]+ " ");
            }
            int n = arr.length;
            //qs(arr, 0, n - 1);
            //mergeSort(arr, 0, n-1);
            //insertionSort(arr);
            //selectionSort(arr);
            bubbleSort(arr);
            System.out.println("\nSorted array:");
            for (int i = 0; i < n; i++) {
                  System.out.print(arr[i]+" ");
            }
      }
//<------------------------------Quick Sort------------------------------------>

      static void qs(int arr[], int low, int high) {
            if (low < high) {
                  int pi = partition(arr, low, high);
                  qs(arr, low, pi - 1);
                  qs(arr, pi + 1, high);
            }
      }

      static int partition(int arr[], int low, int high) {
            int pivot = arr[low];
            int i = low;
            int j = high;

            while (i < j) {
                  while (arr[i] <= pivot && i <= high - 1) {
                        i++;
                  }
                  while (arr[j] > pivot && j >= low + 1) {
                        j--;
                  }
                  if (i < j) {
                        swap(arr, i, j);
                  }
            }
            swap(arr, low, j);
            return j;
      }

      static void swap(int arr[], int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
      }


//<---------------------------------------Merge Sort----------------------------------->

      static void mergeSort(int arr[], int low, int high){
            if(low>=high){
                  return;
            }
            int mid = (low+high)/2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
      }

      static void merge(int arr[], int low, int mid, int high){
            ArrayList<Integer> temp = new ArrayList<>();
            int left = low;
            int right = mid+1;

            while(left<=mid && right<=high){
                  if(arr[left]<=arr[right]){
                        temp.add(arr[left]);
                        left++;
                  }
                  else{
                        temp.add(arr[right]);
                        right++;
                  }
            }
            while(left <= mid){
                  temp.add(arr[left]);
                  left++;
            }
            while (right<=high) {
                  temp.add(arr[right]);
                  right++;
            }
            int n = temp.size();

            for(int i=0; i<n; i++){
                  arr[low+i] = temp.get(i);
            }
      }
//<------------------------------Insertion Sort------------------------>
      static void insertionSort(int arr[]){
            int n = arr.length;
            for(int i=0; i<n-1; i++){
                  for(int j=i+1; j>0; j--){
                        if(arr[j]<arr[j-1]){
                              swap(arr, j, j-1);
                        }
                  }
            }
      }
//<--------------------------Selection Sort-------------------------->
      static void selectionSort(int arr[]){
            int n = arr.length;

            for(int i=0; i<n-1; i++){
                  int min = i;
                  for(int j=i+1; j<n; j++){
                        if(arr[j]<arr[min]){
                              min = j;
                        }
                  }
                  swap(arr,i,min);
            }
      }
// <----------------------------Bubble Sort ------------------------------------>
      static void bubbleSort(int arr[]){
            int n = arr.length;
            for(int i=0; i<n; i++){
                  boolean swap = false;
                  for(int j=1; j<n-i; j++){
                        if(arr[j]<arr[j-1]){
                              swap(arr, j, j-1);
                              swap = true;
                        }
                  }
                  if(!swap){
                        break;
                  }
            }

      }
}
