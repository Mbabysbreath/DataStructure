package test;

/**
 * @author zhaomin
 * @date 2020/3/21 18:25
 */
public class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key=key;
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
