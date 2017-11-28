import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class BagTest{
  
  @Test 
  public void testInsert(){
   Bag<String> newBag = new Bag<String>();
   newBag.insert("Cat");
   newBag.insert("Cat");
   newBag.insert("Dog");
   assertEquals(3, newBag.size());
  }
  
  @Test
  public void testRemove(){
    Bag<String> newBag = new Bag<String>();
    newBag.insert("Cat");
    newBag.insert("Cat");
    newBag.insert("Dog");
    assertEquals(3, newBag.size());
    newBag.remove("Dog");
    assertEquals(2, newBag.size());
  }
  
   @Test
  public void size(){
     Bag<String> newBag = new Bag<String>();
     newBag.insert("Cat");
     newBag.insert("Cat");
     newBag.insert("Dog");
     newBag.remove("Cat");
     newBag.remove("Cat");
     newBag.insert("Corgi");
     newBag.insert("Corgi");
     assertEquals(3, newBag.size());
  }
   
  @Test
  public void isIn(){
    Bag<String> newBag = new Bag<String>();
    newBag.insert("Cat");
    newBag.remove("Cat");
    newBag.remove("Cat");
    assertEquals("{}", newBag.toString());
  }
  
  @Test
  public void isInCat(){
    Bag<String> newBag = new Bag<String>();
    newBag.insert("Cat");
    assertEquals(1, newBag.size());
    assertEquals("{Cat=1}", newBag.toString());
  }
  
  @Test
  public void removeDoesNotExist(){
    Bag<String> newBag = new Bag<String>();
    newBag.remove("Cat");
    assertEquals("{}", newBag.toString());
  }
  
  @Test
  public void choose(){
    Bag<String> newBag = new Bag<String>();
    newBag.insert("Cat");
    assertEquals("Cat", newBag.choose());
  }
  
  @Test
  public void repOk(){
    Bag<String> newBag = new Bag<String>();
    newBag.insert("Cat");
     newBag.insert("Cat");
     newBag.insert("Dog");
     newBag.remove("Cat");
     newBag.remove("Cat");
     newBag.insert("Corgi");
     newBag.insert("Corgi");
     assertTrue("true", newBag.repOk());
  }
  
  // This is our properties rule:
  // For a bag to be a subtype of set there cannot exist duplicate keys within the map. However, we keep track of key 
  // instances by using a key/value pair. The value signifying how many of that key exist. 
  @Test
  public void diplicates(){
    Bag<String> newBag = new Bag<String>();
    newBag.insert("Cat");
    newBag.insert("Cat");
    assertEquals("{Cat=2}", newBag.toString()); 
  }
}
  