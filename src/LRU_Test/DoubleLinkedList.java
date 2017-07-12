package LRU_Test;

import LRU.Node;

public class DoubleLinkedList {
     
	private final int size;
	private int current_size;
	private Node head;
	private Node tail;
	
	public DoubleLinkedList(int size){
		
		this.size=size;
		setCurrent_size(0);
	}
	
	
	public Node getTail(){
		return tail;
		
		}
	
	public int getSize(){
		return size;
	}

	public int getCurrent_size() {
		return current_size;
	}

	public void setCurrent_size(int current_size) {
		this.current_size = current_size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void printList(){
		
		//if head null(no element in linked list)
		if(head==null){
			return;
		}
		// if head is not null(there are elements in linked list)
		 Node temp=head;
		
		if(temp!=null){
			
			System.out.println(temp);
			temp=temp.getNext();
		}
		
		
	}
	
	public void move_PageToHead(Node pageNode){
		
		// if page node is null or head i.e one element only 
		if(pageNode==null||pageNode==head){
			return ;
		}
		
		//before moving the tail element, make previous tail element into tail and next to tail into null
		if(pageNode==tail){
			
			tail=tail.getPrev();
			tail.setNext(null);
		}
		
		//find the prev and next element of pageNode and connect between them
		Node prev=pageNode.getPrev();
		Node next=pageNode.getNext();
		prev.setNext(next);
		
		if(next!= null){
			
			next.setPrev(prev);
		}
		
		//add the page element in the begin of the page list
		pageNode.setPrev(null);
		pageNode.setNext(head);
		head.setPrev(pageNode);
		head=pageNode;
		
		
	}
	
	public Node addPageToList(int page_number){
		
		Node pageNode = new Node(page_number);
		
		//if head is null (no elements in the page list)
		if(head==null)
		{
			head=pageNode;
			tail=pageNode;
			current_size=1;
			return pageNode;
		}
		//increment current size if it is smaller than total size
		else if (current_size<size){
			current_size ++;
		}
		
		else{
			
			tail=tail.getPrev();
			tail.setNext(null);
		}
		//if head is not null (there is element in the page)
		
		pageNode.setNext(head);
		head.setPrev(pageNode);
		head=pageNode;
		return pageNode;
		
	}
	
}
