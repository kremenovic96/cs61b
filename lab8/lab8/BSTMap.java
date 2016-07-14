package lab8;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
/**
 * Created by ranko on 13/07/16.
 */
public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {
    int size;
    private Node start;
    private Node root;             // root of BST

    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left;
        private Node right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K k, V v, int size) {
            this.key = k;
            this.val = v;
            this.size = size;
        }
    }

    public BSTMap() {
        size = 0;
    }

    @Override
    public int size() {
        return size(root);

    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else return x.size;
    }

    @Override
    public V get(K k) {
        return get(root, k);
    }

    private V get(Node x, K k) {
        if (x == null) {
            return null;
        }
        int cmp = k.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, k);
        } else if (cmp > 0) {
            return get(x.right, k);
        } else {
            return x.val;
        }


    }

    @Override
    public void put(K k, V v) {
        root = put(root, k, v);

    }

    private Node put(Node x, K k, V v) {
        if (x == null) {
            return new Node(k, v, 1);
        }
        int cmp = k.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, k, v);
        } else if (cmp > 0) {
            x.right = put(x.right, k, v);
        } else {
            x.val = v;
        }
        x.size = size(x.left)+ size(x.right) + 1;
        return x;
    }

    @Override
    public boolean containsKey(K k) {
        return get(k) != null;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}