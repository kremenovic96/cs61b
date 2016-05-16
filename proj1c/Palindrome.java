public class Palindrome {
 public static Deque<Character> wordToDeque(String word) {
  Deque<Character> aa = new LinkedListDequeSolution<Character>();
   int i = 0;
   while (i != word.length()) {
   aa.addFirst(word.charAt(i));
     i += 1;

  }
 }
 public static boolean isPalindrome(String word) {
        int len = word.length();
        int i = 0;
        int b;
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
      return true;
        }

 // begginning with main (just trying)..
 public static void main(String[] args) {
    Deque<Character> bb = new LinkedListDequeSolution<Character>();
    bb = wordToDeque("hasdaelo");
    }
}