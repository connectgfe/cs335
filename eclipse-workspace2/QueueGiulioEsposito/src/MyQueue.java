import java.util.NoSuchElementException;
/*
 * An abstract data type specified as a Java interface
 * to represent a FIFO Queue.
 */
public interface MyQueue<E> {
  
  // How many elements have been added to this MyQueue object.
  public int size();

  // Return true if there are 0 elements in the queue.
  public boolean isEmpty();

  // Add element to the end of the queue.
  public void enqueue(E element);
  
  // Return the queue as a string that has all toString elements
  // separated by one space.  I am using asString because 
  // MyLinkedQueue would already have a toString from class Object.
  public String asString();

  // Return the element at the front of the queue or throw
  // an exception if empty.
  public E peek() throws NoSuchElementException;

  // Return the element at the front of the queue as it
  // is removed or throw an exception if empty.
  public E dequeue() throws NoSuchElementException;
}
