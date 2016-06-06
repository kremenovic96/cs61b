// TODO: Make sure to make this class a part of the synthesizer package
 package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first = 0;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last = first;
    /* Array for storing the buffer data. */
    private T[] rb;
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */


    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.rb = (T[])new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;


    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (last == capacity) {

            last = 0;
            //throw new RuntimeException("Ring Buffer Overflow");
        }
        if (fillCount >= capacity){
            //hmmm ..
            throw new RuntimeException("Ring Buffer Overflow ");
        }
        rb[last] = x;
        last += 1;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update

        if (this.fillCount == 0){
            throw new RuntimeException("Ring Buffer Underflow");
        }
        if (first == this.capacity) {
            first = 0;
        }
        T current = rb[first];
        first += 1;
        fillCount -= 1;
        return current;

    }
        /**
         * Return oldest item, but don't remove it.
         */
        @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (first == this.capacity){
            first = 0;
        }
            return rb[first];
    }
    public class wizard implements Iterator<T>{
        private int currentindex;
        public wizard(){
            currentindex = 0;
        }
        public boolean hasNext() {
            return (currentindex<capacity);
        }
        public T next () {
            T currentThing =  rb[currentindex];
            currentindex += 1;
            return currentThing;
        }
    }
        // TODO: When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator () {
        return new wizard();
    }
    }

