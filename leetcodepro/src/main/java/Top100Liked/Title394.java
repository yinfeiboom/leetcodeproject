package Top100Liked;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Title394 {
    public static void main(String[] args){
        Title394 title394=new Title394();
        System.out.println(title394.decodeString("3[a2[c]]"));


    }
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit_begin = i;
                while (s.charAt(i) != '[') i++;
                int num = Integer.valueOf(s.substring(digit_begin, i));
                int count = 1;
                int str_begin = i+1;
                i ++;
                while (count != 0) {
                    if (s.charAt(i) == '[') count ++;
                    else if (s.charAt(i) == ']') count --;
                    i ++;
                }
                i--;
                String str = decodeString(s.substring(str_begin, i));
                for (int j = 0; j < num; j ++) {
                    sb.append(str);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
