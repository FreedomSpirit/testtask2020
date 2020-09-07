package com.example.testtask;

import java.lang.reflect.Array;

public class BrokenArraySearch {
    final float LOWER = 0.5f;
    final float HIGHER = 1.5f;

    public int findElem(int[] arr, int value) {
        return recursiveSearch(arr, value, 0, Array.getLength(arr)-1);
    }

    private int recursiveSearch(int[] arr, int key, int left, int right){
        return recursiveSearch(arr, key, left, right, 1);
    }

    private int recursiveSearch(int[] arr, int key, int left, int right, float shiftRatio){
        if(arr[left]==key) return left;
        if(arr[right]==key) return right;

        if (left >= right) return -1;

        int mid = (int)(left + ((right - left) / 2.0) * shiftRatio);
        if(arr[mid]==key) return mid;

        if(arr[mid]>arr[left]){
            //For mid point before zero point
            if(key>arr[mid]){
                //Key point at right side, more likely at first part
                return recursiveSearch(arr, key, mid+1, right-1, LOWER);
            } else {
                if(key<arr[mid] && key<arr[left]){
                    //Key point at right side, more likely at second part
                    return recursiveSearch(arr, key, mid+1, right-1,HIGHER);
                } else {
                    //Key point at left side
                    return recursiveSearch(arr, key, left + 1, mid - 1);
                }
            }
        } else {
            //Mid point after zero point
            if(key<arr[mid]){
                //Key point at left side, more likely at second part
                return recursiveSearch(arr, key, left+1, mid-1,HIGHER);
            } else {
                if(key>arr[mid] && key>arr[left]){
                    //Key point at left side, more likely at first part
                    return recursiveSearch(arr, key, left+1, mid-1,LOWER);
                } else {
                    //Key point at right side
                    return recursiveSearch(arr, key, mid+1, right-1);
                }
            }
        }
    }

}
