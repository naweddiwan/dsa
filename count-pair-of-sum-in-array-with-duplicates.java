import java.util.Arrays;

public class Solution {

    public static int pairSum(int[] arr, int num) {
        // Sort the array in ascending order for the two-pointer approach
        Arrays.sort(arr);

        int ans = 0; // Variable to store the count of pairs with the target sum
        int i = 0; // Left pointer
        int j = arr.length - 1; // Right pointer

        // Two-pointer approach to find pairs efficiently
        while (i < j) {
            if (arr[i] + arr[j] > num) {
                // Sum is too large, move the right pointer to decrease the sum
                j--;
            } else if (arr[i] + arr[j] < num) {
                // Sum is too small, move the left pointer to increase the sum
                i++;
            } else {
                // Found a pair with the target sum
                if (arr[i] == arr[j]) {
                    // All elements between i and j are the same
                    int len = j - i + 1; // Number of elements
                    ans += (len * (len - 1) / 2); // Calculate pairs using combination formula
                    break; // No need to continue as all remaining pairs will be the same
                } else {
                    // Handle duplicates at i and j using additional pointers
                    int k = i + 1;
                    int l = j - 1;
                    while (k <= l && arr[k] == arr[i]) {
                        k++;
                    }
                    while (l >= k && arr[l] == arr[j]) {
                        l--;
                    }
                    int leftLength = (k - i); // Count of duplicates at i
                    int rightLength = (j - l); // Count of duplicates at j
                    ans += (leftLength * rightLength); // Calculate pairs based on duplicates
                    i = k; // Update pointers to avoid counting duplicates again
                    j = l;
                }
            }
        }

        return ans; // Return the total count of pairs with the target sum
    }
}
