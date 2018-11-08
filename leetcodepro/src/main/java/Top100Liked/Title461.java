package Top100Liked;
/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
 */
public class Title461 {
    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(5));
        Title461 title461=new Title461();
        System.out.println(title461.hammingDistance(1,4));
    }
    public int hammingDistance(int x, int y) {
        int res=0;
        String str_x=Integer.toBinaryString(x);
        String str_y=Integer.toBinaryString(y);
        int add=str_x.length()-str_y.length();
        if (add>0){
            for (int i = 0; i <add ; i++) {
                str_y="0"+str_y;
            }
        }else {
            for (int i = 0; i <-add ; i++) {
                str_x="0"+str_x;
            }
        }
        for (int i = 0; i <str_x.length() ; i++) {
            if (str_x.charAt(i)!=str_y.charAt(i)) res++;
        }
        return res;
    }
}
