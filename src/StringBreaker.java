import java.util.*;

public class StringBreaker {

    public static void main(String[] args) {
        int [][] arr=new int[5][5];
        int num=0;
        for(int i=0;i<arr.length;i++){
            for (int a = 0; a < arr.length; a++) {
                arr[i][a]=num;
                num++;
            }
        }
        for(int i=0;i<arr.length;i++){
            for (int a = 0; a < arr.length; a++) {
                System.out.print(arr[i][a]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            for (int a = 0; a < arr.length; a++) {
                System.out.print(arr[a][i]+" ");
            }
            System.out.println();
        }



    }

    public static String breakString(String input, int maxLength) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < input.length()) {
            if (index + maxLength >= input.length()) {
                // if the remaining string is shorter than maxLength, append it and break
                result.append(input.substring(index));
                break;
            } else {
                // find the nearest space character within the maxLength
                int spaceIndex = input.lastIndexOf(" ", index + maxLength);
                if (spaceIndex == -1) {
                    // if no space character is found, break at the maxLength
                    spaceIndex = index + maxLength;
                }
                // append the substring up to the space character
                result.append(input.substring(index, spaceIndex)).append("\n");
                index = spaceIndex + 1;
            }
        }
        return result.toString();
    }
    public static void rotate(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        HashSet<Integer> res=new HashSet<>();
        for(int i=0;i<a.size();i++){
            HashSet<Integer> temp=new HashSet<>();
            for(int j=1;j<b.get(0);j++){
                if(a.get(i)*j>b.get(0)) break;
                temp.add(a.get(i)*j);
            }
            if(res.isEmpty()){
                res = (HashSet)temp.clone();
            }
            res.retainAll(temp);
        }
        System.out.println(res);
        for(int i=0;i<b.size();i++){
            HashSet<Integer> temp=new HashSet<>();
            for(int j=1;j<=b.get(i);j++){
                if(b.get(i)%j==0){
                    temp.add(j);
                }
            }
            res.retainAll(temp);
        }
        System.out.println(res);
        System.out.println(res.size());
        return res.size();

    }
//    example 2,6
    static int getHCF(int n1,int n2){
        if(n2==0 || n1==0){
            return n1==0?n2:n1;
        }
        if(n1>n2){
            return getHCF(n2,n1%n2);
        }else{
            return getHCF(n1,n2%n1);
        }
    }
    static int getLCM(int n1,int n2){
        if(n2==0 || n1==0){
            return 0;
        }
        int hcf=getHCF(n1,n2);
        return ((n1*n2)/hcf);
    }
//    aaabccddd
    public static String superReducedString(String s) {

        for(int i=0;i<s.length()-1;i++){
            String a=s.substring(i,i+1);
            String b=s.substring(i+1,i+2);
            if(a.equals(b)){
                s=s.substring(0,i)+s.substring(i+2,s.length());
                s=superReducedString(s);
                break;
            }
        }
        return s;

    }
    public static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        int count=0;
        for(int i=0;i<arr.size();i++){
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
        }
        System.out.println(map);
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            Integer key=i.getKey();
            Integer val=i.getValue();
            if(val>count){
                count=val;
                res=key;
            }else if(val==count){
                if(res>key){
                    res=key;
                }
            }
        }
        System.out.println(res);

        return res;


    }



}