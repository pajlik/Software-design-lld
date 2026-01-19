import java.util.HashMap;
import java.util.Map;

public class LRUCacheService {
    private Map<Integer, Node> node_map;
    private Node head;
    private Node tail;
    private int MAX_CACHE_SIZE;

    public LRUCacheService(int capacity) {
        this.MAX_CACHE_SIZE = capacity;
        this.node_map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value) {
        if (node_map.containsKey(key)) {
            Node node = node_map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addNodeFront(node);
            node_map.put(key, node);
        }else{
            if (node_map.size()==MAX_CACHE_SIZE){
                removeLastNode();
                int remove_key = this.tail.prev.key;
                node_map.remove(remove_key);
            }
            Node node = new Node(key, value);
            addNodeFront(node);
            node_map.put(key, node);
        }
    }

    public int get(int key) {
        if (node_map.containsKey(key)) {
            Node node = node_map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addNodeFront(node);
            return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        if (node_map.containsKey(key)) {
            Node node = node_map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            node_map.remove(key);
        }else{
            throw new IllegalStateException("key not found");
        }
    }

    private void addNodeFront(Node node) {
        node.next = this.head.next;
        node.next.prev = node;
        this.head.next = node;
        node.prev = this.head;
    }

    private void removeLastNode() {
        if (this.tail.prev == this.head) {
            return;
        }
        Node remove_node = this.tail.prev;
        remove_node.prev.next = remove_node.next;
        this.tail.prev = remove_node.prev;
        remove_node.next = null;
        remove_node.prev = null;
    }

    public void printCache() {
        Node tmp = this.head.next;
        while (tmp != tail) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
    }


}
