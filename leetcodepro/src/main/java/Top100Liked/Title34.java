package Top100Liked;

import java.util.*;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class Title34 {
    private List<Integer> list=new ArrayList<Integer>();
    public static void main(String[] args){
        Title34 title34=new Title34();
        int[] temp=new int[]{0};
       title34.searchRange(temp,0);
       System.out.println(title34.list);
    }
    public int[] searchRange2(int[] nums, int target) {
        int start=-1,end=-1;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==target){

                if (start==-1)start=i;
                else end=i;
            }
        }
        return new int[]{start,end};
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
       binsearch(0,nums.length-1,nums,target);
        if (list.isEmpty()) return new int[]{-1,-1};
        Collections.sort(list);
        result[0]=list.get(0);
        result[1]=list.get(list.size()-1);
      return result;
    }
    //二分查找
    public void binsearch(int start,int end,int[] nums,int target){
        if (start>end) return ;
        int mid=(start+end)/2;
        if (nums[mid]==target) list.add(mid);
        binsearch(mid+1,end,nums,target);//右边
        binsearch(start,mid-1,nums,target);//左边
    }
}
