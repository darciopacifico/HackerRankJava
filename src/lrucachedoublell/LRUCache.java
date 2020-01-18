package lrucachedoublell;


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private int count = 0;
    private final Map<Integer, Node> hashMap = new HashMap<>();

    final Node topo = new Node(-1, -1, null, null);
    final Node base = new Node(-1, -1, null, null);

    public static void main(final String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1); //  put key 2             put key 2
        cache.put(1, 1); //  put key 1             put key 1
        cache.put(2, 3); //  put key 2             put key 2
        cache.put(4, 1); //  put key 4 evicting 2  put key 4 evicts key 1
        cache.get(1);    //  GET 1 value 1         GET Key 1 returns -1 (no
        cache.get(2);    //  GET 2 value -1        GET Key 2 returns 3
    }

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.topo.base = this.base;
        this.base.topo = this.topo;
    }

    public int get(final int key) {
        Node node = this.hashMap.get(key);
        if (node == null) {
            return -1;
        }

        collapseLinks(node);
        acomodateNodeBetween(node, topo.base, topo);

        return node.value;
    }

    private void acomodateNodeBetween(final Node node, final Node base, final Node topo) {
        node.topo = topo;
        topo.base = node;

        node.base = base;
        base.topo = node;
    }

    private void collapseLinks(final Node node) {
        if (node.topo != null)
            node.topo.base = node.base;

        if (node.base != null)
            node.base.topo = node.topo;

    }

    public void put(final int key, final int value) {
        if (this.capacity == 0) return;

        Node node = this.hashMap.get(key);

        if (node != null) {
            node.value = value;
            collapseLinks(node);
        } else {
            node = new Node(key, value, null, null);
            this.hashMap.put(key, node);
            this.count++;
        }

        acomodateNodeBetween(node, topo.base, topo);

        if (this.count > this.capacity) {
            this.hashMap.remove(this.base.topo.key);
            collapseLinks(this.base.topo);
            this.count--;
        }
    }

    static class Node {
        final int key;
        int value;

        Node topo;
        Node base;

        public Node(final int key, final int value, final Node topo, final Node base) {
            this.key = key;
            this.value = value;
            this.topo = topo;
            this.base = base;
        }
    }
}
