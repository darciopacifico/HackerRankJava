package lrucache;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class LRUCache {

    private Map<Integer, Node> hashMap = new HashMap<>();

    private PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
        return (int) (o1.readTime - o2.readTime);
    });
    private final int capacity;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = this.hashMap.get(key);
        if (node != null) {
            this.priorityQueue.remove(node);
            node.readTime = System.nanoTime();

            this.priorityQueue.add(node);
            System.out.println("GET Key " + key + " returns " + node.value);
            return node.value;

        } else {
            System.out.println("GET Key " + key + " returns -1 (not found)");
            return -1;
        }
    }

    public void put(int key, int value) {
        System.out.print("put key " + key);
        if (hashMap.containsKey(key)) {
            Node nodeToRefresh = hashMap.get(key);
            priorityQueue.remove(nodeToRefresh);
        } else {

            if (this.priorityQueue.size() >= capacity) {
                Node leastItem = priorityQueue.poll();
                if (leastItem != null) {
                    System.out.print(" evicts key " + leastItem.key + " ");
                    this.hashMap.remove(leastItem.key);
                }
            }
        }

        Node newNode = new Node(value, key, System.nanoTime());

        this.priorityQueue.add(newNode);
        this.hashMap.put(key, newNode);

        System.out.println();
    }

    class Node {
        int value;
        int key;
        long readTime;

        public Node(int value, int key, long reads) {
            this.value = value;
            this.key = key;
            this.readTime = reads;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
