package com.sohan.algo;

import java.util.Arrays;

public class HeapSort {

	private static int heapSize = 0;

	public static void main(String[] args) {
		int[] input = { 5, 6, 3, 9, 8, 5, 4, 2, 7 };
		System.out.println(Arrays.toString(input));
		heapSort(input);
		System.out.println(Arrays.toString(input));
	}

	private static void heapSort(int[] input) {
		heapSize = input.length;
		buildMaxHeap(input);
		for (int i = input.length - 1; i > 0; i--) {
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			heapSize--;
			maxHeapify(input, 0);
		}
	}

	private static void buildMaxHeap(int[] input) {
		for (int i = input.length / 2; i >= 0; i--) {
			maxHeapify(input, i);
		}
	}

	private static void maxHeapify(int[] input, int i) {
		int left = i * 2 + 1;
		int right = left + 1;
		int largest = -1;

		if (left < heapSize && input[left] > input[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < heapSize && input[right] > input[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = input[i];
			input[i] = input[largest];
			input[largest] = temp;
			maxHeapify(input, largest);
		}
	}
}
