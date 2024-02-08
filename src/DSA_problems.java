import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DSA_problems {
    public static void main(String[] args) {
        /*Since it is a 6 digits long code
        * this code works generic inputs of length n as long as
        * the code is not scattered inside the String*/
        String input = "Basavanagudi560004Begur560068bengaluru560085bengaluru560081";
        String output = segAreasWithPinCodes(input);
        System.out.println(output);
    }
    public static String segAreasWithPinCodes(String input) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < input.length()) {
            // find the index of the first digit
            int digitIndex = -1;
            for (int i = index; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    digitIndex = i;
                    break;
                }
            }
            if (digitIndex == -1) {
                // if no digit is found, append the remaining string and break
                res.append(input.substring(index));
                break;
            } else {
                // append the area and pin code separately
                res.append(input.substring(index, digitIndex)).append(" ");
                res.append(input.substring(digitIndex, digitIndex + 6)).append("\n"); // separate lines
                // update the index to the position after the pin code
                index = digitIndex + 6;
            }
        }
        return res.toString().trim();
    }
    static int bitonic_Array(int [] arr,int start,int end){
        int i=0;
        int j=end-1;
        while (i <  j) {
            int mid = i + ((j - i) / 2);
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] >= arr[mid - 1]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
    /*abcabcdc*/ /*o/p:abcd*/
    static String longestUniqueSubString(String s) {
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            String key = String.valueOf(s.charAt(right));
            if(map.containsKey(key) && map.get(key)>left){
                left = map.get(key) + 1;
                map.put(key, left);
            }
            map.put(key,right);
            if(ans.length()<(right-left+1)){
                ans=s.substring(left+1,right+1);
            }
        }
        return ans;
    }
    static String unique(String s){
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            if(ans.contains(String.valueOf(s.charAt(i)))){
                continue;
            }
            ans+=String.valueOf(s.charAt(i));

        }
        return ans;
    }
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] jumps = new int[n];

        if (n == 0 || arr[0] == 0) {
            return -1;
        }

        jumps[0] = 0;

        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }

        return jumps[n-1] != Integer.MAX_VALUE ? jumps[n-1] : -1;
    }
    static String recRev(String string){
        if(string.length()<=1){
            return string;
        }
        String first=string.substring(0,1);
        String second=string.substring(1);
        return recRev(second)+first;
    }
    static String decimalToBinary(int dec){
        String ans="";
        while(dec>=1){
            int x=dec%2;
            dec=dec/2;
            ans=x+ans;
        }
        return ans;
    }
    static int binarytoDec(String bin){
        int ans=0;
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1'){
                ans+=Math.pow(2,bin.length()-i-1);
            }
        }
        return ans;
    }
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

}
