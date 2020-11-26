package com.example.springboot;

import java.util.Arrays;

public class TwoDArray {

    static int[][] arr = { {10,20,30}, {40,50,60}, {70,80,90}};

    public static void main(String[] args) {


        //binarySearch(arr, 90);
        //System.out.println ("Found Element "  + traverse(arr, 1000));

        int[][] barr = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        printArray(barr);

        boolean isFound = searchInUnEvenGrowthMatrix(barr, 1);
        System.out.println ("Is Found in barr " + isFound );
    }

    static void printArray(int[][] arr) {

        for (int i=0; i<=arr.length-1; i++) {
            for (int j=0; j<=arr[0].length-1; j++) {
                System.out.print(" [" + i + ", " + j + "] " + arr[i][j]);
                if (j <= arr[0].length-1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    /*
            [
              10    20  30
              40    50  60
              70    80  90
            ]

     */

    static boolean binarySearch(int[][] arr, int target) {

        int start = 0;
        int end=arr.length-1;

        int mid=0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            System.out.println ("Mid " + mid);
            boolean found = searchRow(arr[mid], target);
            System.out.println ("OUTER start " + start + " end " + end  + " found " + found);
            if (!found) {
                if (arr[mid][arr[0].length-1] < target) {
                    start = mid + 1;
                } else {
                    end = mid -1 ;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    static boolean searchRow(int[] row, int target) {

        System.out.println ("Searching Row " + Arrays.asList(row));
        int start = 0;
        int end = row.length-1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            System.out.println ("INNER start " + start + " end " + end  + " row[mid] " + row[mid]);
            if (target == row[mid]) {
                return true;
            }
            if (row[mid] < target) {
                start = mid + 1;
            } else {
                end = mid -1 ;
            }
        }
        return false;
    }

    public static boolean traverse(int[][] arr, int target) {

        int start = 0;
        int colIndex = arr.length-1;
        while (start <= arr.length-1) {
            if (arr[start][colIndex] == target) {
                System.out.println ("FOUND the target at " + start + " : " + colIndex + " Element:  " + arr[start][colIndex]);
                return true;
            }
            if (arr[start][colIndex] < target) {
                start++;
            } else {
                colIndex--;
            }
        }
        return false;
    }

    public static boolean searchInUnEvenGrowthMatrix(int[][] arr, int target) {

        int start = 0;
        int colIndex = arr.length-1;
        int count = 0;

        while (start <= arr.length-1 && colIndex >=0) {
            count++;
            if (arr[start][colIndex] == target) {
                System.out.println ("Count for O(n) " + count);
                System.out.println ("FOUND the target " + target + " at [" + start + "," + colIndex + "] Element : " + arr[start][colIndex]);
                return true;
            }

            if (target < arr[start][colIndex]) {
                System.out.println ("Moving Left [column] " + colIndex);
                colIndex--;
            } else {
                System.out.println ("Moving Down " + start);
                start++;
            }
        }

        return false;
    }

    public static void spiral(int[][] arr, int target, int totalElements) {

        boolean[][] isVisited = new boolean[arr.length][arr.length];

        int start = 0;

        int colIndex = 0;
        int rowIndex = 0;

        boolean leftToRight = true;
        boolean topToDown = false;
        boolean rightToLeft = false;
        boolean bottomUp = false;

        int rowEnd = arr.length-1;
        int colEnd = arr[0].length-1;
        int count = 0;

        while (count <= totalElements ) {

            if (leftToRight) {

                while (colIndex <= colEnd) {
                    System.out.print(arr[rowIndex][colIndex++]);
                    count++;
                }
                topToDown = true;
                leftToRight = false;
                rightToLeft = false;
                bottomUp = false;
            }

            if (topToDown) {

                while (rowIndex <= rowEnd ) {
                    System.out.print(arr[rowIndex++][colIndex]);
                    count++;
                }
                rightToLeft = true;
                topToDown = false;
                leftToRight = false;
                bottomUp = false;

            }

            if (rightToLeft) {
                while (colIndex >=0) {
                    System.out.print(arr[rowIndex][colIndex--]);
                    count++;
                }
                bottomUp = true;
                rightToLeft = true;
                topToDown = false;
                leftToRight = false;
            }

            if (bottomUp) {
                while (rowIndex >=0 ) {
                    System.out.print(arr[rowIndex--][colIndex]);
                    count++;
                }

                bottomUp = true;
                rightToLeft = true;
                topToDown = false;
                leftToRight = false;

            }

        }
    }

}
