import java.util.*;

// See Liskov exercise 7.11
// This version is generified
public class Bag<E> {

    // rep: map each object to the count of that object in this
    // rep-inv:  range of map contains only positive integers
    // Example:  A bag of 2 cats and a dog is map = { cat=2, dog=1 }
    
    private Map<E, Integer> map;
    private int size;

    public Bag() {
        this.map = new HashMap<E, Integer>();
        this.size = 0; 
    }

    // add 1 occurrence of e to this
    public void insert(E e) {
       if (isIn(e)) {
        int val = this.map.get(e);
        val++;
        this.map.put(e, val); 
      }
      else {
       this.map.put(e, 1); 
      }
      this.size++; 
    }

    // remove 1 occurrence of e from this
    public void remove(E e) {
    if (isIn(e)) {
        int val = this.map.get(e);
        val--;
        if (val == 0) {
         this.map.remove(e); 
        }
        else{
          this.map.put(e, val); 
        }
        this.size--; 
      } 
    }

    // return true iff e is in this
    public boolean isIn(E e) {
     return this.map.containsKey(e);
    }
    
    // return cardinality of this
    public int size() {
      return this.size;
    }

    // if this is empty throw ISE
    // else return arbitrary element of this
    @SuppressWarnings("unchecked") 
    public E choose() {
      if (this.map.size() == 0){
        throw new IllegalArgumentException();
      }
      Object[] keys = this.map.keySet().toArray(); 
      return (E)keys[0];
      
    }

    // conveniently, the <E,Integer> map is exactly the abstract state
    public String toString() { return map.toString(); }

     public boolean repOk(){
      Object[] values = this.map.values().toArray();
       for(int i = 0; i < this.map.size(); i++){
          if((int)values[i] <= 0){
               return false;
            }
        }
        return true;
    }  
}
