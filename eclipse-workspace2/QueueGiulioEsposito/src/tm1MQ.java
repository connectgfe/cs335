
public class tm1MQ {


  public static void main( String args[]){


  MyLinkedQueue<String> test1 = new MyLinkedQueue<String>();
    
  test1.enqueue("hello1");
  test1.enqueue("hello2");


  System.out.println(test1.asString());

  System.out.println(test1.peek());

  System.out.println(test1.asString());

  System.out.println(test1.dequeue());

  System.out.println(test1.asString());


  MyLinkedQueue<Integer> test2 = new MyLinkedQueue<Integer>();

  test2.enqueue(1);
  test2.enqueue(2);
  test2.enqueue(3);

  System.out.println(test2.asString());


  }

}
