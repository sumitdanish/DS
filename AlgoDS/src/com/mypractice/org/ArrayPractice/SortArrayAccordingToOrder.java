package com.mypractice.org.ArrayPractice;

/*
 * 
 * 
 * @04-Sep-14 SU915198 11:15:01 PM
 * 
 * Sort an array according to the order defined by another array
 * 
 * 
 * */
public class SortArrayAccordingToOrder {

	public int[] sortArrayAccordingToOrder(int[] array1, int[] array2) {
		try {
			boolean[] visited = new boolean[array1.length];
			array1 = this.quickSort(array1, 0, array1.length - 1);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int[] quickSort(int[] array, int leftIndex, int rightIndex) {
		try {
			int pivot = (leftIndex + rightIndex) / 2;
			int i = leftIndex;
			int j = rightIndex;
			while (i <= j) {
				while (pivot >= array[i])
					i++;
				while (pivot <= array[j])
					j--;
				if (i <= j) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					j--;
					i++;
				}
				if (leftIndex < j) {
					return quickSort(array, leftIndex, j);
				} else {
					return quickSort(array, i, rightIndex);
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int binarySearchUsingLoop(int[] array, int min, int max, int key) {
		try {
			int mid = (min + max) / 2;
			if (array[mid] == key) {
				return mid;
			}
			if (array[mid] <= key) {
				return binarySearchUsingLoop(array, mid + 1, max, key);
			}
			if (array[mid] >= key) {
				return binarySearchUsingLoop(array, min, mid - 1, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
