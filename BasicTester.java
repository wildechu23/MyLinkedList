public class BasicTester {
  public static void main(String[] args) {
    MyLinkedList words = new MyLinkedList();

    // add 0-9 in order
    for (int i = 0; i < 10; i++) {
      words.add(i + "");
    }
    System.out.println(words);
    System.out.println(words.size());
    // insert 0x - 9x before each value 0-9
    for (int i = 0; i < 10; i++) {
      words.add(2 * i, i + "x");
    }
    // check the head/tail add
    words.add(0, "head");
    words.add(words.size(), "tail");

    try {
      words.add(-1, "");
      System.out.println("ERROR! Added to negative index");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      words.add(words.size() + 1, "");
      System.out.println("ERROR! Added to (size + 1) index");
    } catch (IndexOutOfBoundsException e) {

    }

    System.out.println("Your result:\n" + words + " " + words.size());
    System.out
        .println("expected:\n[head, 0x, 0, 1x, 1, 2x, 2, 3x, 3, 4x, 4, 5x, 5, 6x, 6, 7x, 7, 8x, 8, 9x, 9, tail] 22");
    System.out.println("\nYour result:\n" + words.toStringReversed() + " " + words.size());
    System.out
        .println("expected:\n[tail, 9, 9x, 8, 8x, 7, 7x, 6, 6x, 5, 5x, 4, 4x, 3, 3x, 2, 2x, 1, 1x, 0, 0x, head] 22");

    MyLinkedList a = new MyLinkedList();
    MyLinkedList b = new MyLinkedList();
    for (int i = 0; i < 10; i++) {
      if (i < 5) {
        a.add(i + "");
      } else {
        b.add(i + "");
      }
    }
    System.out.println();
    System.out.println("A:" + a + a.size());
    System.out.println("B:" + b + b.size());

    a.extend(b);
    System.out.println("A:" + a + a.size());
    System.out.println("B:" + b + b.size());
    System.out.println("A reversed:" + a.toStringReversed() + a.size());
    System.out.println("B reversed:" + b.toStringReversed() + b.size());
    System.out.println("" + a + a.size());
    a.remove(0);
    System.out.println("" + a + a.size());
    a.remove(a.size()-1);
    System.out.println("" + a + a.size());
    a.remove(3);
    System.out.println("" + a + a.size());
  }
}