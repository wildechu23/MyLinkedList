public class MyLinkedList{
  private int size;
  private Node start,end;  
  public MyLinkedList(){/*create a constructor*/}
  public int size() {
    return size;
  }
  
  //ADD AND REMOVE HAVE 4 CASES: FRONT, BACK, 0 ELEMENTS, 1 ELEMENT

  public boolean add(String value) {
    if(size == 0) {
      Node n = new Node(value);
      start = n;
      end = n;
    } else {
      Node n = new Node(value);
      end.setNext(n);
      n.setPrev(end);
      end = n;
    }
    size++;
    return true;
  }

  public boolean add(int index, String value) {
    if(index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index not in range 0 to " + size());
    }
    if(size() == 0 || index == size()) {
      add(value);
    } else if(index == 0) {
      Node n = new Node(value);
      start.setPrev(n);
      n.setNext(start);
      start = n;
      size++;
    } else {
      Node n = new Node(value);
      Node current = getNode(index);
      Node prev = current.getPrev();
      // connect first
      n.setNext(current);
      current.setPrev(n);
      // break after
      prev.setNext(n);
      n.setPrev(prev);
      size++;
    }
    return true;
  }

  public String remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index not in range 0 to " + size());
    }

    Node current = getNode(index);
    Node prev = current.getPrev() != null ? current.getPrev() : null;
    Node next = current.getNext();

    if(size() == 0) {
      return "";
    } else if(size() == 1) {
      start = null;
      end = null;
    } else if(index == 0) {
      next.setPrev(null);
      current.setNext(null);
      start = next;
    } else if (index == size()-1) {
      prev.setNext(null);
      current.setPrev(null);
      end = prev;
    } else {
      prev.setNext(next);
      next.setPrev(prev);
      current.setNext(null);
      current.setPrev(null);
    }
    size--;
    return current.getData();
  }

  public void extend(MyLinkedList other) {
    if(other.size() == 0) {
      return;
    } else {
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
      other.start = null;
      other.end = null;
      size += other.size();
      other.size = 0;
    }
  }

  public String get(int index) {
    return getNode(index).getData();
  }

  public String set(int index, String value) {
    String prev = get(index);
    getNode(index).setData(value);
    return prev;
  }

  public String toString() {
    String hold = "";
    Node current = start;
    while (current != null) {
      hold += current.getData();
      if(current.getNext() != null) {
        hold += ", ";
      }
      current = current.getNext();
    }
    return "[" + hold + "]";
  }

  public String toStringReversed() {
    String hold = "";
    Node current = end;
    while (current != null) {
      hold += current.getData();
      if (current.getPrev() != null) {
        hold += ", ";
      }
      current = current.getPrev();
    }
    return "[" + hold + "]";
  }

 //Any helper method that returns a Node object MUST BE PRIVATE!
  private Node getNode(int index) {
    int i = 0;
    Node current = start;
    while(i < index && current != null) {
      current = current.getNext();
      i++;
    }
    return current;
  }
}