public class Palindrome {
 public static Deque<Character> wordToDeque(String word) {
  Deque<Character> aa = new LinkedListDequeSolution<Character>();
   int i = 0;
   while (i != word.length()) {
   aa.addLast(word.charAt(i));
     i += 1;


  }
     return aa;
 }
 public static boolean isPalindrome(String word) {
        int len = word.length();
        int i = 0;
        int b=len-i-1;
       // boolean iss = true;
        while (i != b) {
            if (word.charAt(i) == word.charAt(len-i-1)) {
            i = i+1;
            b = len-i-1;
            }
            else {
                return false;
            }
         }
     if (word.charAt(i) == word.charAt(b))
     {return true;}
     return false; // štagod
 }

 // little tests using main..
 public static void main(String[] args) {
    Deque<Character> bb = new LinkedListDequeSolution<Character>();
    bb = wordToDeque("hasdaelo");
     bb.printDeque();
     String a = "racecar";
     boolean is = isPalindrome(a);
     if (is) {
     System.out.println("string " + a + " is palindrome!");

     }
     a = "welcome";
     is = isPalindrome(a);
      if (is) {
       System.out.println("string" + a + " is palindrome");
      }
    }
}