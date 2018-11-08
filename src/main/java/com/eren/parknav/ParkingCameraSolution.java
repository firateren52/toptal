package com.eren.parknav;

public class ParkingCameraSolution {

    int debugLoopCount2 = 0;

    public int findMinimumNumberOfCamerasLinearSearch(int range, int[] parkingSpaces) {
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
            if(cameraCount < 10)
                System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);
            totalRange = parkingSpaces[cameraSpace] + range;
            for (int j = cameraSpace; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                i = j;
                debugLoopCount ++;
            }
            i++;
            cameraCount ++;
            //debugLoopCount ++;
        }
        System.out.println("findMinimumNumberOfCamerasLinearSearch cameraCount:" + cameraCount + ", n:" + parkingSpaces.length + ", debugLoopCount:" + debugLoopCount);
        return cameraCount;
    }

    public int findMinimumNumberOfCamerasBinarySearch(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        debugLoopCount2 = 0;
        while(i < parkingSpaces.length) {
            int totalRange = parkingSpaces[i] + range;
            int cameraSpace = binarySearch0(parkingSpaces, i, parkingSpaces.length, totalRange);
            if(cameraCount < 10)
                System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);

            totalRange = parkingSpaces[cameraSpace] + range;
            i = binarySearch0(parkingSpaces, cameraSpace, parkingSpaces.length, totalRange);
            i++;
            cameraCount ++;
            //debugLoopCount ++;
        }
        System.out.println("findMinimumNumberOfCamerasBinarySearch cameraCount:" + cameraCount + ", n:" + parkingSpaces.length + ", debugLoopCount2:" + debugLoopCount2);
        return cameraCount;
    }

    public int findMinimumNumberOfCamerasExponentialSearch(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        debugLoopCount2 = 0;
        while(i < parkingSpaces.length) {
            int totalRange = parkingSpaces[i] + range;
            int cameraSpace = exponentialSearch(parkingSpaces, i, totalRange);
            if(cameraCount < 10)
                System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);

            totalRange = parkingSpaces[cameraSpace] + range;
            i = exponentialSearch(parkingSpaces, cameraSpace, totalRange);
            i++;
            cameraCount ++;
            //debugLoopCount ++;
        }
        System.out.println("findMinimumNumberOfCamerasExponentialSearch cameraCount:" + cameraCount + ", n:" + parkingSpaces.length + ", debugLoopCount2:" + debugLoopCount2);
        return cameraCount;
    }

    private int exponentialSearch(int a[], int fromIndex, int key)
    {
        // If x is present at firt location itself
        if (a[0] == key)
            return 0;

        // Find range for binary search by
        // repeated doubling
        int i = fromIndex;
        while (i < a.length && a[i] <= key)
            i = i*2 + 1;

        // Call exponential search for the found range.
        return binarySearch0(a, i/2,
                Math.min(i, a.length), key);
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
