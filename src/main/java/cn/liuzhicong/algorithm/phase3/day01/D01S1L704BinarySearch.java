package cn.liuzhicong.algorithm.phase3.day01;

/**
 * https://leetcode.cn/problems/binary-search
 *
 * @author liuzhicong
 **/
public class D01S1L704BinarySearch {

    /*左闭右闭*/
    public int search01(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 区间是[left,right]
        while (left <= right) { // left <= right 原因：当left==right 时候，符合区间定义
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                // 1,2,3,4,5,6,7,8
                //       m   t
                // 在右边区间继续查找，更新 left 值
                left = mid + 1; // left=mid+1 的原因：mid 已经查找过，如果left=mid，则下次还会查找此下标，导致错误
            } else {
                // 同理，在左边区间继续查找，更新 right 值，right=mid-1的原因与上述相同
                right = mid - 1;
            }
        }
        return -1;
    }

    /*左闭右开*/
    public int search02(int[] nums, int target) {
        // 区间是[left,right)
        int left = 0, right = nums.length;
        while (left < right) { // left < right的原因是，当left==right时,需要做到符合区间定义，那么就不能等于故只能小于
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                // 1,2,3,4,5,6,7,8
                //       m   t
                // 在右边区间继续查找，更新 left 值
                left = mid + 1; // left=mid+1 的原因：mid 已经查找过，如果left=mid，则下次还会查找此下标，导致错误。
            } else {
                // 同理，在左边区间继续查找，更新 right 值，right=mid而不是mid-1，原因是mid已经搜索到，但根据区间[)定义，下次将不会查找
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        D01S1L704BinarySearch instance = new D01S1L704BinarySearch();
        System.out.println(instance.search01(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3) + "");
        System.out.println(instance.search02(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3) + "");
    }
}
