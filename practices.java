// public class practices {
//     int size=5;
//     int items[]=new int [size];
//     int front;
//     int rear;

//     practices(){
//         front=-1;
//         rear=-1;
//     }

//     boolean isFull(){
//         if (front==0 && rear==size -1){
//             return true;
//         }else{
//             return false;
//         }
//     }
//     boolean isEmpty(){
//         if (front==-1){
//             return true;
//         }else{
//             return false;
//         }
//     }


//     void enQueue(int element){
//         if (isFull()){
//             System.out.println("Queue is full");
//         }else{
//             if (front==-1){
//                 front=0;
//             }
//             rear++;
//             items[rear]=element;
//             System.out.println("Inserted" + element);
//         }
//     }
//     public static void main(String[] args){
//         practices p=new practices();
        
//         p.enQueue(12);
//         p.enQueue(13);
//         p.enQueue(14);
//         p.enQueue(15);
//         p.enQueue(16);



//     }
// }










// import java.util.ArrayList;

// public class practices {
//     private ArrayList<Integer> heap;

//     // Constructor
//     public practices() {
//         heap = new ArrayList<>();
//     }

//     // Insert a new value into the heap
//     public void insert(int value) {
//         heap.add(value); // Add the value to the end
//         heapifyUp(heap.size() - 1); // Restore the heap property
//     }

//     // Remove and return the maximum element (root)
//     public int removeMax() {
//         if (heap.isEmpty()) {
//             throw new IllegalStateException("Heap is empty");
//         }
//         int max = heap.get(0);
//         heap.set(0, heap.remove(heap.size() - 1)); // Replace root with the last element
//         heapifyDown(0); // Restore the heap property
//         return max;
//     }

//     // Get the maximum element without removing it
//     public int getMax() {
//         if (heap.isEmpty()) {
//             throw new IllegalStateException("Heap is empty");
//         }
//         return heap.get(0);
//     }

//     // Restore the heap property upwards
//     private void heapifyUp(int index) {
//         int parentIndex = (index - 1) / 2;
//         while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
//             swap(index, parentIndex);
//             index = parentIndex;
//             parentIndex = (index - 1) / 2;
//         }
//     }

//     // Restore the heap property downwards
//     private void heapifyDown(int index) {
//         int leftChild = 2 * index + 1;
//         int rightChild = 2 * index + 2;
//         int largest = index;

//         if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
//             largest = leftChild;
//         }
//         if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
//             largest = rightChild;
//         }
//         if (largest != index) {
//             swap(index, largest);
//             heapifyDown(largest);
//         }
//     }

//     // Swap two elements in the heap
//     private void swap(int i, int j) {
//         int temp = heap.get(i);
//         heap.set(i, heap.get(j));
//         heap.set(j, temp);
//     }

//     // Display the heap as a list
//     public void printHeap() {
//         System.out.println(heap);
//     }

//     // Main method for testing
//     public static void main(String[] args) {
//         practices maxHeap = new practices();

//         maxHeap.insert(10);
//         maxHeap.insert(5);
//         maxHeap.insert(20);
//         maxHeap.insert(15);
//         maxHeap.insert(30);

//         System.out.println("Heap after insertions:");
//         maxHeap.printHeap();

//         System.out.println("Maximum element: " + maxHeap.getMax());

//         System.out.println("Removing maximum element: " + maxHeap.removeMax());
//         maxHeap.printHeap();
//     }
// }





















public class practices{
    private int[] heap;
    private int size;

    // Constructor
    public practices(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert a new value into the heap
    public void insert(int value) {
        if (size == heap.length) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value; // Add the value at the end
        heapifyUp(size); // Fix the heap property
        size++;
    }

    // Remove and return the maximum element (root)
    public int removeMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1; // or any default value indicating failure
        }
        int max = heap[0];
        heap[0] = heap[size - 1]; // Replace root with the last element
        size--;
        heapifyDown(0); // Fix the heap property
        return max;
    }

    // Restore the heap property upwards
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    } 

    // Restore the heap property downwards
    private void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        practices maxHeap = new practices(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5); 
        maxHeap.insert(30);
        maxHeap.insert(15);
        System.out.println("Heap after insertions:");
        maxHeap.printHeap();

        System.out.println("Removing max: " + maxHeap.removeMax());
        maxHeap.printHeap();
    }
}
