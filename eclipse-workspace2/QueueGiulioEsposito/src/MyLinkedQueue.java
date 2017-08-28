import java.util.NoSuchElementException;
import java.util.*;
import java.lang.*;

/** 
 * A MyLinkedQueue object stores a collection of elements the size of which
 * is only limited by the memory on the heap (free store).  It is generic
 * to allow any type of element. A MyLinkedQueue object represents a FIFO queue. 
 * One can be instantiated like this:
 * 
 *    MyQueue<Integer> q = new MyLinkedQueue<>();
 *    
 * @param <E>  The type of elements stored in the queue
 * 
*/
public class MyLinkedQueue<E> implements MyQueue<E> {


        private ArrayList<E> input;


        public MyLinkedQueue(){

        input = new ArrayList<E>();

        }
 

	@Override
	public int size() {
 
        return input.size();

	}

	@Override
	public boolean isEmpty() {

        return input.isEmpty();

	}

	@Override
	public void enqueue(E element) {

        input.add(element);	
	
	}

	@Override
	public String asString() {

        StringBuilder str = new StringBuilder();
 
          for( E s : input){ 

            str.append(s);
            str.append(" ");

          } 
        
         str.setLength(str.length()-1);

        return str.toString();

 	}

	@Override
	public E peek() throws NoSuchElementException {

        if(input.size() == 0){ 
          throw new NoSuchElementException();
        }
	
        return input.get(0);

        }

	@Override
	public E dequeue() throws NoSuchElementException {

	    if(input.size() == 0){ 
	        throw new NoSuchElementException();
	    }	
		
        return input.remove(0);

	}

}
