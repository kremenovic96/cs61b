public class ArrayDeque<item> {
 
 item[] items;
 int size;
 int startingFirst = (items.length / 2);
 int startingLast = (items.length /2) +1;
 int nextFirst = startingFirst;
 int nextLast = startingLast;
 public ArrayDeque() {
  size = 0;
  items = (item[]) new Object[8];
}
 public void resize () {
 item[] b = (item[]) new Object[items.length * 2];
 System.arraycopy(items,0,b,0,size);
 items = b;
}
 public float usageRatio() {
  return size/items.length;
}
public void addFirst(item i) {
 if ( usageRatio()  > 0.25 ) {
 resize();
}
 items[nextFirst] = i;
 nextFirst -= 1;
 nextLast = nextLast % items.length;
}
public void addLast (item i) {
 if (usageRatio()>0.25) {
 resize();
}
 items[nextLast] = i;
 nextLast += 1;
 nextLast = nextLast % items.length;
}
public boolean isEmpty() {
 if (size == 0) {
  return true;
}  
 return false;	

}
public int size(){
 return size;
}
public void printDeque() {
 for (int i = 0; i<items.length; i++) {
System.out.printn(items[i] + " ");
}
}
public item removeFirst() {
item tmp = items[0];
 items[0] = null;

return tmp;}
public item removeLast() {
 item tmp = items[size-1];
  items[size-1] = null;
return tmp;}
public item get(int index) {
 return items[index];

}
 


}
