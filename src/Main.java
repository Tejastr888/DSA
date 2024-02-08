import java.util.*;
class tres extends Thread{
    public void run(){
        System.out.println("run");
    }
}
public class Main {
    final int x=10;
    public static void main(String[] args) {
        int x=10;
        int y=++x *2+x--;
        System.out.println(x+""+y);
        System.out.println(125%10);
    }
    int process(int i){
        return i+5;
    }


    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;   
        }
        boolean[][] arr = new boolean[s1.length()+1][s2.length()+1];
        for (boolean[] row : arr) {
            Arrays.fill(row, false);
        }
        return dp(arr,s1,s2,s3,0,0);
    }

    static boolean dp(boolean[][] arr, String s1, String s2, String s3, int i, int j){
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (arr[i][j]) {
            return false; // subproblem already computed
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && dp(arr, s1, s2, s3, i+1, j)) {
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && dp(arr, s1, s2, s3, i, j+1)) {
            return true;
        }
        arr[i][j] = true; // store result of subproblem
        for (boolean[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        return false;
    }
    public static String convert(String s, int numRows) {
        String ans="";
        for(int i=0;i<numRows;i++){
            int inct=(numRows-1)*2;
            for(int j=i;j<s.length();j+=inct){
                ans+=s.charAt(j);
                if(i>0 && i<numRows-1 && j+inct-2*i<s.length()){
                    ans+=s.charAt(j+inct-2*i);
                }
            }
        }
        return ans;
    }
    public static boolean isPalindrome(int x) {
        int comp=0;
        while(x>0){
            int temp=x%10;
            x=x/10;
            comp=comp*10+temp;
        }
        return comp==x?true:false;
    }
/*    Explanation:
    P     I    N
    A   L S  I G
    Y A   H R
    P     I*/
    public static int myAtoi(String s) {
        int ans=0;
        String set="0123456789";
        int i=0;
        int cond=1;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(i<s.length() && s.charAt(i)=='-'){
            cond=-1;
            i++;
        }else if(i<s.length() && s.charAt(i)=='+'){
            i++;
        }
        while(i<s.length() && set.contains(String.valueOf(s.charAt(i)))){
            ans=ans*10+(s.charAt(i)-'0');
            boolean contains =i+1<s.length() && set.contains(String.valueOf(s.charAt(i + 1)));
            if(ans>Integer.MAX_VALUE/10 && contains && cond==1){
                return Integer.MAX_VALUE;
            }else if(ans>Integer.MAX_VALUE/10 && contains && cond==-1){
                return Integer.MIN_VALUE;
            }else if(ans<=Integer.MAX_VALUE/10 && contains && s.charAt(i)-'0'<8){
                return cond==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            i++;
        }
        return ans*cond;
    }
    public static int maxArea(int[] height) {
        int res=0;
        int i=0;
        int j=(height.length-1);
        while(i<j){
            int area=(j-i)*Math.min(height[i],height[j]);
            res=Math.min(res,area);
            if(height[i]>height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
    public static String minWindow(String s, String t) {
        if(t.equals("")) return "";
        String res="";
        HashMap<Character,Integer> tmap=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for(int i=0;i<t.length();i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        System.out.println(tmap);
        int have=0,need=t.length();
        int left=0,right=0,len=Integer.MAX_VALUE;
        int i=0;
        for(int r=0;r<s.length();r++){
            char temp=s.charAt(r);
            window.put(temp,window.getOrDefault(temp,0)+1);
            if(tmap.containsKey(temp) && window.get(temp)==tmap.get(temp)){
                have++;
            }
            while(have==need){
                if(r-i+1<len){
                    left=i;
                    right=r;
                    len=r-i+1;
                }
                char c=s.charAt(i);
                window.put(c,window.get(c)-1);
                if(tmap.containsKey(c) && window.get(c)<tmap.get(c)){
                    have--;
                }
                i++;
            }

        }
        return len!=Integer.MAX_VALUE?s.substring(left,right+1):"";
    }
    public static boolean Interleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean [][] dp=new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                dp[i][j] = false;
            }
        }
        dp[s1.length()][s2.length()]=true;
        for(int i=s1.length();i>=0;i--){
            for(int j=s2.length();j>=0;j--){
                if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j]){
                    dp[i][j]=true;
                }
                if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && dp[i][j+1]){
                    dp[i][j]=true;
                }
            }

        }
        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][0];
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


}
