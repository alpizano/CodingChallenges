package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Davy has buried pieces of his ancient artifacts underground. The artifacts are hidden in an area split into an
 * NxN grid of square cells. The rows are numbered from 1 to N. The columns are labeled with consecutive English upper-case letters (A,B,C etc..).
 * Each cell is identified by a string composed of its row number followed by its column number ;
 */
public class Solution
{
    public static int[] getArtifacts(int N, String artifacts, String searched) {

        // Split the Artifacts String into an String[] on comma
        String[] strArray = artifacts.split(",");

        System.out.println(Arrays.toString(strArray));
        System.out.println(strArray[0]);

        Map<Integer, String> map = new HashMap<>();

        int artifactKey = 1;
        for(String val: strArray) {
            map.put(artifactKey, val);
            artifactKey++;
        }

        System.out.println(map.get(2));


        for(int row=0; row<N; row++) {
            for(int col=0; col<N; col++) {
                System.out.print("|_");
            }
            System.out.println();
        }

        // Initialize underground map to NxN matrix
        int[][] underground = new int[N][N];

        return null;
    }

    public static void main( String[] args )
    {
        String artifacts = "1B 2C,2D 4D";

        Solution.getArtifacts(5, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");

    }
}
