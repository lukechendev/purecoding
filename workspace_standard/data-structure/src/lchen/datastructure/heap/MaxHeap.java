package lchen.datastructure.heap;

import java.util.Arrays;

public class MaxHeap {
    private int capacity = 10;
    private int size = 0;

    private int[] items = new int[capacity];

    private int getLeftIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightIndex(int index) {
        return index * 2 + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeft(int index) {
        return getLeftIndex(index) < size;
    }

    private boolean hasRight(int index) {
        return getRightIndex(index) < size;
    }

    private int getLeft(int index) {
        return items[getLeftIndex(index)];
    }

    private int getRight(int index) {
        return items[getRightIndex(index)];
    }

    private int getParent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int index1, int index2) {
        int tmp = items[index1];
        items[index1] = items[index2];
        items[index2] = tmp;
    }

    private void adjustCapacity() {
        if (size == capacity) {
            capacity = capacity * 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeft(index)) {
            int biggerIndex = getLeftIndex(index);
            if (hasRight(index) && (getRight(index) > getLeft(index))) {
                biggerIndex = getRightIndex(index);
            }

            if (items[index] < items[biggerIndex]) {
                swap(index, biggerIndex);
            } else {
                break;
            }

            index = biggerIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && (getParent(index) < items[index])) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    // Return the head
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    public void add(int v) {
        adjustCapacity();
        items[size] = v;
        size++;
        heapifyUp();
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void print() {
        for (int i = 0; i < items.length; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public int[] pollAll() {
        int[] ret = new int[size];

        int i = 0;
        while (size > 0) {
            ret[i++] = poll();
        }

        return ret;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.add(10);
        heap.add(15);
        heap.add(20);
        heap.add(17);

        heap.print(); // 20 17 15 10

        heap.add(9);
        heap.print(); // 20 17 15 10 9

        System.out.println("peek: " + heap.peek());
        heap.print(); // 20 17 15 10 9

        System.out.println("poll: " + heap.poll());
        heap.print(); // 17 10 15 9

        heap.add(18);
        heap.print(); // 18 17 15 9 10

        heap.add(19);
        heap.print(); // 19 17 18 9 10 15

        System.out.println("poll: " + heap.poll());
        System.out.println("poll: " + heap.poll());
        System.out.println("poll: " + heap.poll());
        System.out.println("poll: " + heap.poll());
        System.out.println("poll: " + heap.poll());
        System.out.println("poll: " + heap.poll());

        System.out.println("size: " + heap.size());
        System.out.println("capacity: " + heap.capacity());

        heap.add(10);
        heap.add(15);
        heap.add(20);
        heap.add(17);
        heap.add(100);
        heap.add(150);
        heap.add(200);
        heap.add(170);
        heap.add(30);
        heap.add(35);
        heap.add(50);
        heap.add(67);
        heap.print();

        System.out.println("size: " + heap.size());
        System.out.println("capacity: " + heap.capacity());

        int[] itemsInOrder = heap.pollAll();
        for (int i = 0; i < itemsInOrder.length; ++i) {
            System.out.print(itemsInOrder[i] + " ");
        }
        System.out.println();
    }
}
