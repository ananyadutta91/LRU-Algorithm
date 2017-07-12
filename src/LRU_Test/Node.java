package LRU_Test;

public class Node {
	
	private int page_number;
	private Node prev;
	private Node next;
	
	public Node(int page_number ){
		
		this.page_number= page_number;
		
	}
	
	public int getPage_number() {
		return page_number;
	}
	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
   public String toString(){
	   return page_number + "";
   }
	

}
