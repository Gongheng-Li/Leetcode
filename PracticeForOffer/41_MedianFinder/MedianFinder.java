import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> largerHeap, smallerHeap;

    public MedianFinder() {
        largerHeap = new PriorityQueue<>();
//        smallerHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        smallerHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (largerHeap.size() == smallerHeap.size()) {
            if (largerHeap.size() > 0 && num > largerHeap.peek()) {
                largerHeap.add(num);
            } else {
                smallerHeap.add(num);
            }
        } else if (largerHeap.size() > smallerHeap.size()) {
            if (num > largerHeap.peek()) {
                smallerHeap.add(largerHeap.poll());
                largerHeap.add(num);
            } else {
                smallerHeap.add(num);
            }
        } else{
            if (num < smallerHeap.peek()) {
                largerHeap.add(smallerHeap.poll());
                smallerHeap.add(num);
            } else {
                largerHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (largerHeap.size() == smallerHeap.size()) {
            return (largerHeap.peek() + smallerHeap.peek()) / 2.0;
        } else if (largerHeap.size() > smallerHeap.size()) {
            return largerHeap.peek();
        } else {
            return smallerHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder testClass = new MedianFinder();
        testClass.addNum(12);
        System.out.println(testClass.findMedian());
        testClass.addNum(10);
        System.out.println(testClass.findMedian());
        testClass.addNum(13);
        System.out.println(testClass.findMedian());
    }
}


/**
 * A naive, no, a stupid implementation, the author didn't even think of using binary search to search in a sorted array,
 * what the hell was he thinking about.
 * @author Li Gongheng
 */
/*
class MedianFinder {

    int size;
    int[] data;

    public MedianFinder() {
        size = 0;
        data = new int[8];
    }

    public void addNum(int num) {
        int i = 0;
        while (i < size && num >= data[i]) {
            i += 1;
        }
        System.arraycopy(data, i, data, i + 1, size - i);
        data[i] = num;
        size += 1;
        if (size >= data.length) {
            resize(data.length * 2);
        }
    }

    private void resize(int capacity) {
        int[] newDataArray = new int[capacity];
        System.arraycopy(data, 0, newDataArray, 0, data.length);
        data = newDataArray;
    }

    public double findMedian() {
        if (size == 0) {
            throw new IllegalArgumentException("你一个元素都没插入你找你ma的中位数呢？");
        }
        if (size % 2 == 0) {
            return (data[size / 2] + data[size / 2 - 1]) / 2.0;
        } else {
            return data[size / 2];
        }
    }
}
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */