package Hard;

import java.util.PriorityQueue;
import java.util.Queue;

// Time Complexity: O(log n) for addNum function & O(1) for findMedian function
// Space Complexity: O(n)
class MedianFinder {
    // Two heaps maxHeap and minHeap
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        // Initialize both PriorityQueues
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // insert num in maxHeap
        maxHeap.add(num);
        // Move top of maxHeap to minHeap to maintain order
        int temp = maxHeap.poll();
        minHeap.add(temp);

        // Balance heaps
        if (minHeap.size() > maxHeap.size()) {
            temp = minHeap.poll();
            maxHeap.add(temp);
        }
    }

    public double findMedian() {
        double median;
        // if size of both heaps are not same then
        // median is equal to top element of maxHeap
        if (maxHeap.size() != minHeap.size()) {
            median = maxHeap.peek();
        }
        // otherwise median is addition of top elements of both heaps divide by 2.0
        else {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */