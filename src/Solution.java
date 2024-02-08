import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int []{1,2,3,4})));
    }

    static List<String>  subSeq(String s){
        List<String> ans=new ArrayList<>();
        ans.add("");
        for(int i=0;i<s.length();i++){
            int out=ans.size();
            for(int j=0;j<out;j++){
                String temp=ans.get(j);
                temp+=s.charAt(i);
                ans.add(temp);
            }
        }
        return ans;
    }
    public static int[] productExceptSelf(int[] nums) {
        int []ans=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                temp=temp*nums[j];
            }
            ans[i]=temp;
        }
        return ans;

    }
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int [] arr=mergesort(nums1,nums2);
//        double ans=arr.length%2==0?(arr[arr.length/2]+arr[(arr.length/2)-1])/2:arr[arr.length/2];
//        return ans;
//
//    }

//    static int[] mergesort(int[] one,int [] two){
//        int i=0,j=0,k=0;
//        int [] arr=new int[one.length+two.length];
//        while(j<one.length && k<two.length){
//            while(j<one.length && one[j]<=two[k]){
//                arr[i]=one[j];
//                i++;
//                j++;
//            }
//            while(k<two.length && two[k]<=one[j]){
//                arr[i++]=two[k];
//                k++;
//            }
//        }
//        while(j<one.length){
//            arr[i++]=one[j++];
//        }
//        while(k<two.length){
//            arr[i++]=two[k++];
//        }
//        return arr;
//    }
    static void quickSort(int [] arr,int s,int e){
        int i=s;
        int j=e-1;
        int pivot=arr[j];
        while(i<j){
            while(i<j && arr[i]<pivot){
                i++;
            }
            while(i<j && arr[j]>pivot){
                j--;
            }
            swap(arr,i,j);
        }
        quickSort(arr,0,i);
        quickSort(arr,i,arr.length);

    }
    static void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}