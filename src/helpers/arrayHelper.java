package helpers;

import java.util.Arrays;

public class arrayHelper {

        // Print array of Numbers as is
        public static int listNumbers(int[] A) {
            int i;
            int[] num = A;
            System.out.print("Values before sorting: \n");
            for(i = 0; i < num.length; i++)
                System.out.println( num[i]+"  ");
            return i;
        }

        // Print array of numbers Sorted
        public static void sort(int[] nos, int n) {
            for (int i = 1; i < n; i++){
                int j = i;
                int B = nos[i];
                while ((j > 0) && (nos[j-1] > B)){
                    nos[j] = nos[j-1];
                    j--;
                }
                nos[j] = B;
            }
        }

        public static int sortNumbers(int[] A) {
            int i;
            int[] num = A;
            System.out.print("Values after sorting: \n");
            sort(num, num.length);
            for(i = 0; i < num.length; i++)
                System.out.println( num[i]+"  ");
            return i;
        }

        // Print array of numbers with duplicates removed
        public static int removeDuplicates(int[] A) {
            int i;
            int[] num = A;
            System.out.print("Unique values after sorting: \n");
            num = remove(A);
            for(i = 0; i < num.length; i++)
                System.out.println( num[i]+"  ");
            return i;
        }

        public static int[] remove(int[] A) {
            if (A.length < 2)
                return A;
            int j = 0;
            int i = 1;

            while (i < A.length){
                if(A[i] == A[j]) {
                    i++;
                }else {
                    j++;
                    A[j] = A[i];
                    i++;
                }
            }
            int[] B = Arrays.copyOf(A, j + 1);
            return B;
        }
}
