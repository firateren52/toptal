package com.eren.parknav;

import java.util.Arrays;

public class ParkingCameraSolution {

    int debugLoopCount2 = 0;

    public int findMinCameras(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        int debugLoopCount = 0;
        while(i < parkingSpaces.length) {
            int totalRange = parkingSpaces[i] + range;
            int cameraSpace = i;
            for (int j = i; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                cameraSpace = j;
                debugLoopCount ++;
            }
            //System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);
            totalRange = parkingSpaces[cameraSpace] + range;
            for (int j = cameraSpace; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                i = j;
                debugLoopCount ++;
            }
            i++;
            cameraCount ++;
            //debugLoopCount ++;
        }
        System.out.println("n:" + parkingSpaces.length + ", debugLoopCount:" + debugLoopCount);
        return cameraCount;
    }

    public int findMinCamerasHeuristic(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        int debugLoopCount = 0;
        while(i < parkingSpaces.length) {
            int totalRange = parkingSpaces[i] + range;
            int cameraSpace = i;
            for (int j = i; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                cameraSpace = j;
                debugLoopCount ++;
            }
            //System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);
            totalRange = parkingSpaces[cameraSpace] + range;
            for (int j = cameraSpace; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                i = j;
                debugLoopCount ++;
            }
            i++;
            cameraCount ++;
            //debugLoopCount ++;
        }
        System.out.println("n:" + parkingSpaces.length + ", debugLoopCount:" + debugLoopCount);
        return cameraCount;
    }

    public int findMinCamerasBinarySearch(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        while(i < parkingSpaces.length) {
            int totalRange = parkingSpaces[i] + range;
            int cameraSpace = binarySearch0(parkingSpaces, i, parkingSpaces.length, totalRange);
            //System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);

            totalRange = parkingSpaces[cameraSpace] + range;
            i = binarySearch0(parkingSpaces, cameraSpace, parkingSpaces.length, totalRange);
            i++;
            cameraCount ++;
            //debugLoopCount ++;
        }
        System.out.println("n:" + parkingSpaces.length + ", debugLoopCount2:" + debugLoopCount2);
        return cameraCount;
    }

    // Like public version, but without range checks.
    private int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            debugLoopCount2 ++;
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return high;  // key not found.
    }
}
