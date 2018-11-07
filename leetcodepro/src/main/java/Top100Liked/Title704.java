package Top100Liked;
/*
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1


提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
 */
public final class Title704 implements Cloneable {


    public static void main(String[] args){
        Title704 title704=new Title704();
        int[]nums={-1,0,3,5,9,12};
       System.out.println( title704.search(nums,-1));

        try {
            System.out.println(title704.toString());
            System.out.println(title704.clone()==title704);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
//二分查找
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return binsearch(0,end,nums,target);

    }
    public int binsearch(int start,int end,int[] nums,int target){
        if (start>end) return -1;
        int mid=(start+end)/2;
        if (nums[mid]==target) return mid;
        else if (nums[mid]<target) return binsearch(mid+1,end,nums,target);
        else return binsearch(start,mid-1,nums,target);
    }
}
