package com.bt.string.mix;

import java.util.Arrays;
import java.util.Scanner;

/*
 
*Algorithm!
*
*COUNTING-SORT(A, B, k)
1 for i �? 0 to k
2 do C[i ] �? 0
3 for j �? 1 to length[A]
4 do C[A[ j ]] �? C[A[ j ]] + 1
5 ✄ C[i ] now contains the number of elements equal to i .
6 for i �? 1 to k
7 do C[i ] �? C[i ] + C[i − 1]
8 ✄ C[i ] now contains the number of elements less than or equal to i .
9 for j �? length[A] downto 1
10 do B[C[A[ j ]]] �? A[ j ]
11 C[A[ j ]] �? C[A[ j ]] − 1
*/
public class CountSort {

	private static final int MAX_RANGE = 1000000;
    /** Counting Sort function **/
    public static void sort( int[] arr )
    {
        int N = arr.length;
        if (N == 0)
            return;
        /** find max and min values **/
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
 
        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }
 
        int[] count = new int[range];
        /** make count/frequency array for each element **/
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        System.out.println("Range:"+range+"::"+Arrays.toString(count));
        /** modify count so that positions in final array is obtained **/
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        System.out.println("Range:"+range+"::"+Arrays.toString(count));
        /** modify original array **/
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }    
    void sort(char arr[])
    {
        int n = arr.length;
 
        // The output character array that will have sorted arr
        char output[] = new char[n];
 
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];
 
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }
    

    static void countSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        System.out.println(Arrays.toString(count));
 
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        System.out.println(Arrays.toString(count));
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.out.println(Arrays.toString(output));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    /** Main method **/
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Counting Sort Test\n");
        int n, i;
        /** Accept number of elements **/
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /** Create integer array on n elements **/
        int arr[] = new int[ n ];
        /** Accept elements **/
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        /** Call method sort **/
        countSort(arr);
        /** Print sorted Array **/
        System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
        System.out.println();                     
    }    
}
