package Top100Liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Title15 {
    public static void main(String[] args) {
        Title15 title15=new Title15();
        int[] nums={-1,1};
        System.out.println(title15.threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i <nums.length-2 ; i++) {
            if (i==0||(nums[i]!=nums[i-1])){
                int lo=i+1,hi=nums.length-1,sum = 0 - nums[i];
                while (lo<hi){
                    if (nums[lo]+nums[hi]==sum){
                        res.add(Arrays.asList(nums[lo],nums[i],nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    }
                    else if (nums[lo]+nums[hi]>sum) hi--;
                    else if (nums[lo]+nums[hi]<sum) lo++;
                }

            }
        }
return res;
    }
}
/*
solution:
我们对原数组进行排序，然后开始遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了。这里我们可以先做个剪枝优化，
就是当遍历到正数的时候就break，为啥呢，因为我们的数组现在是有序的了，如果第一个要fix的数就是正数了，那么后面的数字就都是正数，就永远不会出现和为0的情况了。
然后我们还要加上重复就跳过的处理，处理方法是从第二个数开始，如果和前面的数字相等，就跳过，因为我们不想把相同的数字fix两次。对于遍历到的数，用0减去这个fix的数得到一个target，
然后只需要再之后找到两个数之和等于target即可。我们用两个指针分别指向fix数字之后开始的数组首尾两个数，如果两个数和正好为target，则将这两个数和fix的数一起存入结果中。然后就是跳过重复数字的步骤了，
两个指针都需要检测重复数字。如果两数之和小于target，则我们将左边那个指针i右移一位，使得指向的数字增大一些。同理，如果两数之和大于target，则我们将右边那个指针j左移一位，使得指向的数字减小一些
 */