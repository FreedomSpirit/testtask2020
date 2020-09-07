package com.example.testtask;

import java.lang.reflect.Array;

public class BrokenArraySearch {

    public int findElem(int[] arr, int value) {
        return recursiveSearch(arr, value, 0, Array.getLength(arr)-1);
    }

    private int recursiveSearch(int[] arr, int key, int left, int right){
        if(arr[left]==key) return left;
        if(arr[right]==key) return right;

        if (left >= right) return -1;

        int mid = left + (right - left) / 2;
        if(arr[mid]==key) return mid;

        if(arr[mid]>arr[left]){
            //For mid point before zero point
            if(key>arr[mid] ||  (key<arr[mid] && key<arr[left])){
                //Key point at right side
                //It's possible to use interpolation search to be faster
                return recursiveSearch(arr, key, mid+1, right-1);
            } else {
                //Key point at left side
                return recursiveSearch(arr, key, left+1, mid-1);
            }
        } else {
            //Mid point after zero point
            if(key<arr[mid] ||  (key>arr[mid] && key>arr[left])){
                //Key point at left side
                //It's possible to use interpolation search to be faster
                return recursiveSearch(arr, key, left+1, mid-1);
            } else {
                //Key point at right side
                return recursiveSearch(arr, key, mid+1, right-1);
            }
        }
    }

}
