package synthesizer;

public abstract class AbstractBoundedQueue implements BoundedQueue<T>{
 protected int fillCount;
 protected int capacity;
 public int capacity();
 public int fillCount();


 }