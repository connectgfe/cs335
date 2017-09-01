
/*
 * A unit test for MyArrayList
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class MyLinkedQueueTest {

  @Test
  public void testNewListIsEmpty() {
    MyLinkedQueue<Integer> q = new MyLinkedQueue<>();
    assertEquals(0, q.size());
    assertTrue(q.isEmpty());
  }

  @Test(expected = NoSuchElementException.class)
  public void testMakeSureAnExceptionIsThrownWithPeekOnAnEmptyQ() {
    MyLinkedQueue<String> q = new MyLinkedQueue<>();
    q.peek();
  }

  @Test(expected = NoSuchElementException.class)
  public void testMakeSureAnExceptionIsThrownWithDequeueOnAnEmptyQ() {
    MyLinkedQueue<String> q = new MyLinkedQueue<>();
    q.dequeue();
  }
  
  
  
  //Add more @Test methods to get 100% code coverage

  @Test
  public void testEnqueueDequeue() {
	  
    MyLinkedQueue<String> q = new MyLinkedQueue<>();
    q.enqueue("last");
    assertEquals("last",q.peek());
    String val= q.dequeue();
    assertEquals("last",val);
    
	 	  
  }
  
  @Test
  public void testAsString() {
	  
    MyLinkedQueue<Integer> q = new MyLinkedQueue<>();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    String val = "1 2 3";
    assertEquals(val,q.asString());
    
    
	 	  
  }
	  
	  
}
  
  
  