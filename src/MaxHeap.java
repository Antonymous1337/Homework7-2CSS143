public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] otherData) {
        // homework
        data = new Integer[otherData.length];
        size = 0;
        for (int i = 0; i < data.length; i++) {
            add(otherData[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    // Got help from GeeksforGeeks for only this
    public void MaxHeapN(Integer arr[])
    {

        data = new Integer[arr.length];
        size = data.length;


        // Index of last non-leaf node
        int startIdx = (data.length / 2) - 1;


        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }



        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(data, i);
        }
    }

    public void heapify(Integer arr[], int i) {

        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < arr.length && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < arr.length && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, largest);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if (size == data.length) return false;

        data[size] = item;
        int index = size;
        size++;

        while (index != 0 && data[index] > data[(index-1)/2]) {
            Integer temp = data[index];
            data[index] = data[(index-1)/2];
            data[(index-1)/2] = temp;
            index = (index-1)/2;
        }

        return true;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        if (size == 0) return null;
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        // homework

        if (size == 0) return null;

        Integer toReturn = data[0];

        size--;
        data[0] = data[size];
        int index = 0;

        while ((index*2)+2 < size && (data[index] < data[(index*2)+1] || data[index] < data[(index*2)+2])) {
            if (data[(index*2)+1] < data[(index*2)+2]) {
                Integer temp = data[index];
                data[index] = data[(index*2)+2];
                data[(index*2)+2] = temp;
                index = (index*2)+2;
            } else {
                Integer temp = data[index];
                data[index] = data[(index*2)+1];
                data[(index*2)+1] = temp;
                index = (index*2)+1;
            }
        }

        if ((index*2)+1 < size && data[index] < data[(index*2)+1]) {
            Integer temp = data[index];
            data[index] = data[(index*2)+2];
            data[(index*2)+2] = temp;
            index = (index*2)+2;
        }

        return toReturn;
    }

    public boolean isEqualToArray(Integer arr[]) {
        if (size != arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (data[i] != arr[i]) return false;
        }
        return true;
    }
}
