package com.sohan.algo;

import java.util.Arrays;
import java.util.Random;

public class QuickSort implements Cloneable {

	Random rand = new Random(47);

	int i = 10;

	public static void main(String[] args) throws CloneNotSupportedException {
		QuickSort sort = new QuickSort();
		int[] nums = { 5, 8, 3, 9, 2, 1, 4, 0, 5 };
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(sort.sort(nums)));
	}

	public int[] sort(int[] nums) {
		if (nums == null || nums.length == 1) {
			return nums;
		}

		int len = nums.length;
		sort(nums, 0, len - 1);
		return nums;
	}

	private void sort(int[] nums, int start, int end) {
		if (end - start <= 0 || start < 0 || end >= nums.length) {
			return;
		}

		int len = end - start + 1;
		int pivot = start + rand.nextInt(len);
		swap(nums, start, pivot);

		int k = start;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] < nums[start]) {
				swap(nums, ++k, i);
			}
		}
		swap(nums, start, k);
		sort(nums, start, k - 1);
		sort(nums, k + 1, end);
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

}