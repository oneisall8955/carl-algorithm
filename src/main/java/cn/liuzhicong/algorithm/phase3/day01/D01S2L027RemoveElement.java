package cn.liuzhicong.algorithm.phase3.day01;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/remove-element/
 *
 * @author liuzhicong
 **/
public class D01S2L027RemoveElement {

    public int removeElement01(int[] nums, int val) {
        // 过滤器
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index;
    }

    public int removeElement02(int[] nums, int val) {
        // 快慢指针
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        D01S2L027RemoveElement instance = new D01S2L027RemoveElement();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        //        int res = instance.removeElement01(nums, 3);
        int res = instance.removeElement02(nums, 3);
        System.out.println(res);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < res; i++) {
            integers.add(nums[i]);
        }
        System.out.println(integers);
    }
}
