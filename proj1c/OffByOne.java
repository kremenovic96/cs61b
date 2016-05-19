/**
 * Created by ranko on 19-05-16.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
      if ((x-y == 1) || (y - x == 1)){
          return true;
      }
        return false;
    }
}
