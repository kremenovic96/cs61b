package lab8;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ranko on 13/07/16.
 */
public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {
    private Node start;
    private Node root;             // root of BST

    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K k, V v, int size) {
            this.key = k;
            this.val = v;
            this.size = size;
        }
    }
    @Override
   public int size(){
        return root.size;
    }
    @Override
  public  V get(K k){
        return get(root, k);
    }
     V get(Node x, K k){
        if (x == null){
            return null;
        }
       int cmp = k.compareTo(x.key);
        if (cmp < 0){
           return get(x.left,k);
        }
        else if (cmp > 0){
           return get(x.right,k);
        }
        else return x.val;


    }
    @Override
   public void put(K k, V v){
        root = put(root, k, v);
    }
    Node put(Node x, K k, V v){
        if (x == null){
            return new Node(k, v, 1);
        }
        int cmp = k.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, k, v);
        else if (cmp > 0) x.right = put(x.right, k, v);
        else x.val = v;
        x.size = x.left.size + x.right.size + 1;
        return x;
    }
    @Override
   public boolean containsKey(K k){
        return get(k) != null;
    }
    @Override
   public void clear(){
        root.right = null;
        root.left = null;
        root.size = 0;
    }
    @Override
   public V remove(K key){
        return null;
    }
    @Override
   public Set<K> keySet(){
        return null;
    }
    @Override
   public V remove(K key, V value){
        return null;
    }
    @Override
    public Iterator<K> iterator() {
        return new BSTiterator();
    }
   /* public Node findStart(Node x){
        if (x.left == null){
            return x;
        }
        return findStart(x.left);
    } */
        private class BSTiterator implements Iterator<K>{

    @Override
            public boolean hasNext(){
        return root.right != null;
    }
    @Override
       public K next(){
        return null;
    }
    }

}
