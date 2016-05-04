public class LinkedListDeque<Blorp> {
 public class Node{
  public Blorp head;
  public Node next;
  public Node prev;
   public Node(Node p, Blorp h, Node n) {
prev = p;
head = h;
next = n;
}
}
 private Node sentinel;
 private int size;
 public LinkedListDeque() {
 size = 0;
 sentinel = new Node(null,null,null);
 sentinel.prev = sentinel;
 sentinel.next = sentinel;
}
 public Blorp getRecursive(int index) {
  return null;
}
 public void addFirst(Blorp i) {
 
 //Node oldFirst = sentinel.next;
 /*cant create (maybe) first node when there is no nodes (cant retain first node)*/
 Node firstNode = new Node(sentinel,i,sentinel.next);
 sentinel.next = firstNode;
 //sentinel.prev = firstNode;
 if (size>1) {
sentinel.next.next.prev = firstNode;
}
 size += 1;
}
// maybe the bad guy is this
 public void addLast (Blorp i) {


 sentinel.prev.next = new Node(sentinel.prev,i,sentinel);
 sentinel.prev = sentinel.prev.next;
 size += 1;
}
 public boolean isEmpty() {
 if (size == 0) {
 return true;
}
return false;
}
 public int size() {
 return size;
}
 public void printDeque() {
 Node beginning = sentinel.next;
 while (beginning != sentinel) {
  System.out.print(beginning.head + " ");
   beginning = beginning.next;
}

}
//}
 public Blorp removeFirst() {
 if (sentinel.next == sentinel) {
 return null;

}
 
 Node first = sentinel.next;
 first.next.prev = sentinel;
 sentinel.next = first.next;//.next;
 size -= 1;

 return first.head;
}
 public Blorp removeLast() {
 Node last = sentinel.prev;
 last.prev.next = sentinel;
 sentinel.prev = last.prev;
 size -= 1;
 return last.head;
}
public Blorp get(int index) {
 if (index == 0) {
  return sentinel.next.head;
}
 Node beginning=sentinel.next;
 while (index != 0) {
  beginning = beginning.next;
index -= 1;
}
return beginning.head;

}

}

