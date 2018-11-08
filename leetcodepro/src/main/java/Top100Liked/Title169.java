package Top100Liked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class Title169 {
    public static void main(String[] args){
        Title169 title169=new Title169();
        System.out.println(title169.majorityElement2(new int[]{1}));
    }
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        int len1=1;
        int len2=1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]==nums[i-1]) {
                len2++;
                if (len2>=len1) {
                    len1=len2;
                    map.put(len1,nums[i]);
                }
            }
            else {
                len2=1;
            }
        }
        return map.isEmpty()?nums[0]:map.get(len1);
    }
    public int majorityElement(int[] nums) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        int max=0;
        for (Map.Entry<Integer,Integer> e:map.entrySet()) {
            if (max<e.getValue()) {
                max=e.getValue();
                res=e.getKey();
            }
        }
        return res;
    }
}
