package com.sohan.algo;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
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
		int len = end - start + 1;

		if (len == 1) {
			return;
		}

		if (len == 2) {
			if (nums[end] < nums[start]) {
				swap(nums, start, end);
			}
			return;
		}

		int mid = start + len / 2;
		sort(nums, start, mid);
		sort(nums, mid + 1, end);

		int[] b = Arrays.copyOfRange(nums, start, mid + 1);

		int i = 0, j = mid + 1, k = start;
		while (i <= len / 2 && j <= end) {
			nums[k++] = nums[j] < b[i] ? nums[j++] : b[i++];
		}

		while (i <= len / 2) {
			nums[k++] = b[i++];
		}

	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

}
