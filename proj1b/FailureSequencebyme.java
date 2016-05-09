 //print arraydeque bug in a nicer way 
public class FailureSequencebyme {
 public static void main(String[] args) {
  FailureSequence aa = new FailureSequence();
   DequeOperation one = new DequeOperation("addFirst",1);
      DequeOperation two = new DequeOperation("removeLast");
   DequeOperation three = new DequeOperation("size");
   aa.addOperation(one);
   aa.addOperation(two);
   aa.addOperation(three);
  System.out.println(aa.toString());
 }
}