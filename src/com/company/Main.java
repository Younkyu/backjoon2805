package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static long max = 0;

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        long target = sc.nextInt();
        int maxHeight = 0;
        int[] trees = new int[count];
        for (int i = 0; i < count; i++) {
            trees[i] = sc.nextInt();
            if(trees[i] > maxHeight) maxHeight = trees[i];
        }
        binarySearch(0, maxHeight, trees, target);
        System.out.println(max);
    }

    public static void binarySearch(int s, int e, int[] arr, long target) {
        if(s > e) return;
        int mid = (s+e)/2;
        long result = cutTree(arr, mid);
        if (result >= target) {
            if(max < mid) max = mid;
            binarySearch(mid+1, e, arr, target);
        } else {
            binarySearch(s, mid-1, arr, target);
        }
    }

    public static long cutTree(int[] trees, int height) {
        long result = 0;
        for (int i = 0; i < trees.length; i++) {
            if (height < trees[i]) result += (trees[i] - height);
        }
        return result;
    }
}
