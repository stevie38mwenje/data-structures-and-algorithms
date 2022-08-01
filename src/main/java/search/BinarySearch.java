package search;


public class BinarySearch {

        int search(int arr[], int value){
            int low = 0;
            int high= arr.length-1;

            while(low<=high){
                int mid = low + ((high - low) / 2);
                if(arr[mid]==value){
                    return mid;
                }
                if(arr[mid]>value){
                    high = mid - 1;
                }
                else
                    low = mid+1;
            }
            return -1;
        }


        int recursiveSearch(int arr[],int low,int high,int value){
            if(low<high){
            int mid = low + ((high - low) / 2);

            if(arr[mid]==value){
                return mid;
            }
            if(arr[mid]>value){
                return recursiveSearch(arr,low,mid-1,value);
            }
            else
                return recursiveSearch(arr,mid+1,high,value);
        }
            return low;
        }


        public static void main(String args[]) {
            BinarySearch binarySearch = new BinarySearch();
            int arr[] = { 2, 3, 4, 10, 40 };
            int value = 15;
            int result = binarySearch.recursiveSearch(arr,0,4,value);
            System.out.println(result);







        }
}
