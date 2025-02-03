public class QuickSort{
    // Function to perform Quick Sort
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, start, end);

            // Recursively sort left and right subarrays
            quickSort(arr, start, pivotIndex - 1); // Left side of pivot
            quickSort(arr, pivotIndex + 1, end);   // Right side of pivot
        }
    }

    // Partition function based on your understanding
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start]; // First element as the pivot
        int p = start + 1;      // Left pointer
        int q = end;            // Right pointer

        while (p <= q) {
            // Move p to the right until it finds an element greater than pivot
            while (p <= q && arr[p] <= pivot) {
                p++;
            }
            // Move q to the left until it finds an element smaller than pivot
            while (p <= q && arr[q] > pivot) {
                q--;
            }

            // Swap arr[p] and arr[q] if p < q
            if (p < q) {
                swap(arr, p, q);
            }
        }

        // Swap the pivot element with arr[q] (final position of pivot)
        swap(arr, start, q);

        return q; // Return the final pivot position
    }

    // Utility function to swap two elements in an array
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the Quick Sort
    public static void main(String[] args) {
        int[] arr = {35, 50, 15, 25, 80, 20, 90, 45}; // Example array

        System.out.println("Original Array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1); // Apply Quick Sort

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
