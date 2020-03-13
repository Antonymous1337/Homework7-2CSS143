public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // homework
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        if (size == data.length) return false;

        data[size] = item;
        int index = size;
        size++;

        while (index != 0 && data[index] > data[(index-1/2)]) {
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
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        // homework

        Integer toReturn = data[0];

        size--;
        data[0] = data[size];
        int index = 0;

        while ((index*2)+2 < size && (data[index] < data[(index*2)+1] || data[index] < data[(index*2)+2])) {
            if (data[(index*2)+1] > data[(index*2)+2]) {
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

        if ((index*2)+1 < size) {
            Integer temp = data[index];
            data[index] = data[(index*2)+2];
            data[(index*2)+2] = temp;
            index = (index*2)+2;
        }

        //                0
        //               5 4
        //             3 2 1

        /**
        while ((data[index] < data[(index*2)] || data[index] < data[(index*2)+1]) && index*2 < size) {

            if (index*2 >= size) {
                break;
            }

            if ((index*2)+1 >= size && dat) {

            }

            if (data[index*2] < data[(index*2)+1]) {
                Integer temp = data[index];
                data[index] = data[(index*2)+1];
                data[(index*2)+1] = temp;
                index = (index*2)+1;
            } else {
                Integer temp = data[index];
                data[index] = data[index*2];
                data[index*2] = temp;
                index = index*2;
            }
        }
         */


        return toReturn;
    }
}
