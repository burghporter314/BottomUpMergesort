/*PROPERTY OF DYLAN PORTER*/
/*FOR EDUCATIONAL PURPOSES ONLY*/

import java.util.*;

class Main {

    public static void printArray(int[] a) {
        for(Integer s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void merge(int[] left, int[] right, int[] arr, int startIndex) {

        int leftPointer = 0, rightPointer = 0, index = startIndex;

        while(leftPointer < left.length && rightPointer < right.length) {
            if(left[leftPointer] < right[rightPointer]) {
                arr[index] = left[leftPointer];
                index++;
                leftPointer++;
            } else if(right[rightPointer] < left[leftPointer]) {
                arr[index] = right[rightPointer];
                index++;
                rightPointer++;
            } else {
                arr[index] = left[leftPointer];
                arr[index+1] = right[rightPointer];
                leftPointer++;
                rightPointer++;
                index += 2;
            }
        }

        while(leftPointer < left.length) {
            arr[index] = left[leftPointer];
            index++;
            leftPointer++;
        }

        while(rightPointer < right.length) {
            arr[index] = right[rightPointer];
            index++;
            rightPointer++;
        }

    }

    public static void sort(int[] a) {

        int step = 0;
        while(Math.pow(2, step) < a.length) {

            int stepSize = (int)Math.pow(2, step);

            for(int i = 0; i <= a.length - 2; i += (stepSize * 2)) {

                int[] left = Arrays.copyOfRange(a, i, i + stepSize);
                int[] right = Arrays.copyOfRange(a, i + stepSize, 
                                                    ((i + 2*stepSize) > a.length 
                                                        ? a.length : i + 2*stepSize));

                merge(left, right, a, i);
        
            }

            step++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; //Even
        int[] arr2 = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; //Odd

        sort(arr);
        sort(arr2);

        for(Integer a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        for(Integer b : arr2) {
            System.out.print(b + " ");
        }
        System.out.println();

    }

}
