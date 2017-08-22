
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



  }

}
