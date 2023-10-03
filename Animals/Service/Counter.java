package Service;

public class Counter {
  static int index;

  public Counter() {
    index = 0;
  }

  public static int getIndex() {
    return index;
  }

  public static void setIndex() {
    index++;
  }

  
}
