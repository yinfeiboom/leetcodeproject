package Top100Liked;
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class Title5 {

    public static void main(String[] args){
        Title5 t5=new Title5();
        t5.longestPalindrome("s");
    }
    //是否回文
    public int palindrme(char[] temp){
        int res=temp.length;
        for (int i = 0; i <temp.length ; i++) {
            if (temp[i]!=temp[temp.length-1-i]) res=-1;
        }
        return res;
    }
    public String longestPalindrome(String s) {
        int max=Integer.MIN_VALUE;
        int start=0,end=0;
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j <=s.length() ; j++) {
               char[]temp= s.substring(i,j).toCharArray();
               int res=palindrme(temp);

               if (res>max){
                   max=res;
                   start=i;
                   end=j;
               }
                if (res!=-1)break;
            }
        }
        String newstr=s.substring(start,end);
        return newstr;
    }
}
