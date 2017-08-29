
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class WordCountTest {

  @Test
  public void testWordCount() {

    ArrayList<String> list = new ArrayList<String>();

    list.add("how");
    list.add("much");
    list.add("wood");
    list.add("could");
    list.add("a");
    list.add("woodchuck");
    list.add("chuck");
    list.add("if");
    list.add("a");
    list.add("woodchuck");
    list.add("could");
    list.add("chuck");
    list.add("wood"); 

    // Implement wordCount in this file to return a Map that has all of the strings 
    // in list as keys and the number of times that string occurs as the value.
    // Use one of Java's Map types: HashMap<Key, Value> or TreeMap<Key, Value>
    Map<String, Integer> wordMap = wordCount(list);
  // The assertions below must pass.
    assertEquals(1, (int)wordMap.get("how"));   
    assertEquals(1, (int)wordMap.get("much"));
    assertEquals(2, (int)wordMap.get("wood"));
    assertEquals(2, (int)wordMap.get("could"));
    assertEquals(2, (int)wordMap.get("a"));
    assertEquals(2, (int)wordMap.get("woodchuck"));
    assertEquals(2, (int)wordMap.get("chuck"));
    assertEquals(1, (int)wordMap.get("if"));
  }

  // Implement method wordCount here

 

}


