package geeks.array;
import java.util.*;

public class manimumIndexdiff {
// RAJVEER SINGH

    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) {
        int right[] = new int[n];
        int left[] = new int[n];
        
        // Initialize left and right arrays
        left[0] = a[0];
        right[n - 1] = a[n - 1];
        
        // Fill left array
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(a[i], left[i - 1]);
        }
        
        // Fill right array
        for (int j = n - 2; j >= 0; j--) {
            right[j] = Math.max(a[j], right[j + 1]);
        }
        
        // Traverse left and right arrays to find the maximum difference
        int i = 0, j = 0, ans = -1;
        while (j < n && i < n) {
            if (left[i] <= right[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        
        return ans;
    }

    // Driver program to test the function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int a[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int maxDiff = maxIndexDiff(a, n);
        System.out.println("The maximum difference (j - i) such that a[i] <= a[j] is: " + maxDiff);

        sc.close();
    }
}
