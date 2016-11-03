package com.sohan.algo;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] nums = { 5, 8, 3, 9, 2, 1, 4, 0, 5 };
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(sort.sort(nums)));
	}

	public int[] sort(int[] nums) {
		if (nums == null || nums.length == 1) {
			return nums;
		}

		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j > 0 && nums[j] < nums[j - 1]; j--) {
				swap(nums, j, j - 1);
			}
		}
		return nums;
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

}
