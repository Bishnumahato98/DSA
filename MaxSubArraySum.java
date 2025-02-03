public class MaxSubArraySum {
    public static int maxSubarraySum(int[] arr) {
        int currentSum = 0;    // To track the current subarray sum
        int maxSum = Integer.MIN_VALUE; // To store the maximum sum

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i]; // Add the current element to currentSum

            // Update maxSum if currentSum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // Reset currentSum to 0 if it becomes negative
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum; // Return the maximum subarray sum
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        // Find the maximum subarray sum
        int result = maxSubarraySum(arr);
        
        // Print the result
        System.out.println("Maximum Subarray Sum is: " + result);
    }
}
