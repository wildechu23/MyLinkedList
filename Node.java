public class Node{
  public Node(String value){ 
    this.data = value;
  }
  private String data;
  private Node next,prev;
  //write get/set methods for all three instance variables.

  public void setData(String s) {
    data = s;
  }

  public void setNext(Node n) {
    next = n;
  }
  
  public void setPrev(Node n) {
    prev = n;
  }

  public String getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }
  
  public Node getPrev() {
    return prev;
  }
}