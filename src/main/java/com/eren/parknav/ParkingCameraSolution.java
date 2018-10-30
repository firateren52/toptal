package com.eren.parknav;

public class ParkingCameraSolution {

    public int findMinCameras(int range, int[] parkingSpaces) {
        int cameraCount = 0;
        int i = 0;
        while(i < parkingSpaces.length) {
            int totalRange = parkingSpaces[i] + range;
            int cameraSpace = i;
            for (int j = i; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                cameraSpace = j;
            }
            System.out.println("cameraSpace:" + parkingSpaces[cameraSpace]);
            totalRange = parkingSpaces[cameraSpace] + range;
            for (int j = cameraSpace; j < parkingSpaces.length && parkingSpaces[j] <= totalRange; j++) {
                i = j;
            }
            i++;
            cameraCount ++;
        }
        return cameraCount;
    }
}
