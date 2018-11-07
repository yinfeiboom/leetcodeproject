package Top100Liked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 */
public class Title17 {
    public static void main(String[] args){
        Title17 title17=new Title17();
        System.out.println(title17.letterCombinations("23"));
    }
    //回溯法
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map= new HashMap<>();
        for (int i = 0; i <digits.length() ; i++) {
            char temp=digits.charAt(i);
            if (temp=='2') map.put(2,"abc");
            else if (temp=='3') map.put(3,"def");
            else if (temp=='4') map.put(4,"ghi");
            else if (temp=='5') map.put(5,"jkl");
            else if (temp=='6') map.put(6,"mno");
            else if (temp=='7') map.put(7,"pqrs");
            else if (temp=='8') map.put(8,"tuv");
            else if (temp=='9') map.put(9,"wxyz");

        }
    char[] res=new char[digits.length()];
    List<String> list=new ArrayList<String>();
    get(0,res,map,list,digits);
    return list;
    }
    public void get(int pos,char[] res,Map<Integer,String> map,List<String> list,String digits){
        if (pos==res.length) return;

        int temp=digits.charAt(pos)-'0';
        String str=map.get(temp);
        char[] charnums=str.toCharArray();
        for (int i = 0; i <charnums.length ; i++) {
            res[pos]=charnums[i];
            if (pos==res.length-1){
                list.add(String.valueOf(res));
            }
            get(pos+1,res,map,list,digits);
        }
    }
}
