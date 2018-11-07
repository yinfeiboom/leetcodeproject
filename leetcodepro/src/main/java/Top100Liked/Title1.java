package Top100Liked;

import java.util.HashMap;
import java.util.Map;

/*
题目：
给定一个整数数列，找出其中和为特定值的那两个数。

你可以假设每个输入都只会有一种答案，同样的元素不能被重用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
分析：
可以直接遍历两遍数组，第一遍用target-nums[i]，第二遍找nums数组中是否存在target-nums[i]这个数字，找到就返回两个数字组成的数组，这个方法时间复杂度比较大为O(n²)

还有可以用哈希表先把数组中的数字和对应的下标存储一遍，即数字作为键，下标作为值，存储，当遍历数组的时候用target-nums[i]，得到差k，然后在map中找是否存在 k，找到即返回k所对应的value,也就是所对应的数组下标。这样时间复杂度就为O(n+l)，快了好多。


 */
public class Title1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        int[] res=new int[2];

        for (int i = 0; i <nums.length ; i++) {

            map.put(nums[i],i);
        }
        for (int i = 0; i <nums.length ; i++) {
            int k=target-nums[i];
            if (map.containsKey(k)){
                res[0]=map.get(k);
                res[1]=i;
            }
        }

        return res;
    }
}
