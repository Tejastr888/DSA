import java.util.Arrays;

public class Data_structures_algorithms {
   /* Time Complexity O(n*log(n))*/
    static long arr[]=new long[100];

   public static void main(String[] args) {
       int []arr={24,45,2,4,56,43,2,45,23};
//       quick_sort(arr,0, arr.length-1);
       merge_Sort(arr);
       System.out.println(Arrays.toString(arr));
   }
   static long fib(int n){
       if(n<=1){
           return arr[1];
       }
       if(arr[n]!=0){
           return arr[n];
       }
       arr[n]=fib(n-1)+fib(n-2);
       return arr[n];
   }
   private static void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void quick_sort(int [] arr,int start,int end){
       if(start>=end) return;
       int pivot=arr[end];
       int i=start,j=end;
       while (i<j){
           while (i<j && arr[i]<=pivot)i++;
           while (i<j && arr[j]>=pivot)j--;
           swap(arr,i,j);
       }
       swap(arr,i,end);
       quick_sort(arr,start,i-1);
       quick_sort(arr,i+1,end);
    }
    static void merge_Sort(int []arr){
       if(arr.length<=1){
           return;
       }
       int mid=arr.length/2;
       int []left=new int[mid];
       int []right=new int[arr.length-mid];
       for(int i=0;i<left.length;i++){
           left[i]=arr[i];
       }
       for(int i=0;i<right.length;i++){
           right[i]=arr[mid+i];
       }
       merge_Sort(left);
       merge_Sort(right);
       sorting(arr,left,right);
    }
    static void sorting(int [] arr,int [] left,int [] right){
       int i=0,j=0,k=0;
       while(k<arr.length && i<left.length && k<arr.length && j<right.length){
           if(left[i]<right[j]) arr[k++]=left[i++];
           else arr[k++]=right[j++];
       }
       while (k<arr.length && i<left.length) arr[k++]=left[i++];
       while (k<arr.length && j<right.length) arr[k++]=right[j++];
    }
    public static void bubble_sort(int [] arr){
        boolean not_sorted=true;
        while(not_sorted){
            not_sorted=false;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i]>arr[i+1]){
                    not_sorted=true;
                    swap(arr,i,i+1);
                }
            }
        }
    }
    public static void cyclic_sort(int [] arr){
        int i=1;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct] && i<arr.length ){
                swap(arr,arr[i]-1,i);
            }else{
                i++;
            }
        }
    }
}
