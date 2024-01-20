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

                // Example Scenario:
                // Array is : 1269
                // Target is: 8
                // when  i is at 1 and j is at 9, we need to decrease the j pointer, so that the resulting sum is less and closer to target
                j--;
            } else if (arr[i] + arr[j] < num) {
                // Sum is too small, move the left pointer to increase the sum
              
                // Example Scenario:
                // Array is :  1356
                // Target is: 8
                // when  i is at 1 and j is at 6, we need to increase the i pointer, so that the resulting sum is more and closer to target
                i++;
            } else {
                // Found a pair with the target sum
                if (arr[i] == arr[j]) {
                    // Example Scenario:
                    // Array is : 2244444666
                    // Target is: 8
                    // when  i is at first 4 and j is at last 4.

                    // All elements between i and j are the same
                    int len = j - i + 1; // Number of elements
                    ans += (len * (len - 1) / 2); // Calculate pairs using combination formula
                    break; // No need to continue as all remaining pairs will be the same
                } else {
                    // Handle duplicates at left and right side:

                    // Example 1:
                    // Array is:  222226
                    // Target is : 8
                    // We need to calculate for all the 2s on the left

                    // Example 2:
                    // Array is:  266666
                    // Target is : 8
                    // We need to calculate for all the 6s on the right

                    
                    // Handle duplicates at i and j using additional pointers
                    int k = i + 1;
                    int l = j - 1;
                    while (k <= l && arr[k] == arr[k-1]) {
                        k++;
                    }
                    while (l >= k && arr[l] == arr[l+1]) {
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
