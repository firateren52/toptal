package com.eren.parknav;

public class Solution {
    private static int debugLoopCount = 0;

    public static int findMinimumNumberOfCameras(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        while(i < parkingSpaces.length) {
            // find next parking space for camera
            int cameraSpace = calculateRange(i, range, parkingSpaces);
            // find next out of range parking space
            i = calculateRange(cameraSpace, range, parkingSpaces);

            i++;
            cameraCount ++;
        }
        System.out.println("findMinimumNumberOfCamerasLinearSearch cameraCount:" + cameraCount + ", n:" + parkingSpaces.length + ", debugLoopCount:" + debugLoopCount);
        return cameraCount;
    }

    private static int calculateRange(int i, int range, int[] parkingSpaces) {
        int totalRange = parkingSpaces[i] + range;
        float averageRange = (float) (parkingSpaces[parkingSpaces.length-1] - parkingSpaces[i]) / (float)(parkingSpaces.length- 1 - i);
        int cameraSpace = Math.min(parkingSpaces.length - 1, Math.round(range / averageRange) + i);
        if(parkingSpaces[cameraSpace] <= totalRange) {
            for (int j = cameraSpace; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                cameraSpace = j;
                debugLoopCount ++;
            }
        } else {
            for (int j = cameraSpace; j >= i && parkingSpaces[j] > totalRange; j--) {
                cameraSpace = j;
                debugLoopCount ++;
            }
            cameraSpace --;
        }
        return cameraSpace;
    }

}
