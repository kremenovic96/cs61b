package synthesizer;



public abstract class AbstractBoundedQueue implements BoundedQueue{
 protected int fillCount;
 protected int capacity;
 abstract public int capacity();
 abstract public int fillCount();


 }