package linkedlist;

import java.util.Scanner;

public class LinkedList {
	ListNode head;
	int length;
	
	public ListNode getHead(){
		return head;
	}
	
	public  void insertBegin(ListNode node){
		
		if(head == null){
			head = node;
		}
		else{
			node.setNext(head);
			head = node;
		}
		length++;
	}
	
	public  void insertEnd(ListNode node){
		if(head == null){
			head = node;
		}
		else{
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
			  p.setNext(node);
			  
		}
		length++;
	}
	
	public  void insertPos(ListNode node,int position){
		
		if(position < 0 ){
			position = 0;
		}
		if(position > length){
			position = length;
		}
		
		int i = 0;
		ListNode p = head;
		ListNode q = p;
		
		if(position == 0)
			insertBegin(node);
		else if(position == length)
			insertEnd(node);
		else{
		while(i < position){
			i++;
			q = p;
			p = p.getNext();
		}
		
		node.setNext(p);
		q.setNext(node);
		length++;
		}
		
	}
	
	public  void removeBegin(){
		if(head == null)
			System.out.println("No Elements to Remove");
		else{
		head = head.getNext();
		length--;
		}
	}
	
	public  void removeEnd(){
		if(head == null)
			System.out.println("No Elements to Delete");
		else{
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
			p.setNext(null);
			length--;
		}
	}
	
	public  int removeMatched(int data){

		ListNode p = head;
		if(p.getData() == data ){
			head =head.getNext();
			length--;
			return 1;
			
		}
		else{
		ListNode q = null;
		while((q = p.getNext())!=null){
			if(q.getData()== data){
				p.setNext(q.getNext());
				length--;
				return 1;
			}
			p = p.getNext();
		} 
	}
		return 0;
}
	
	public  void removePos(int position){
		
		if(position < 0){
			position = 0;
		}
		if(position > length){
			System.out.println(length);
			position = length+1;
		}
		
		if(position == 0){
			head = head.getNext();
		}
		else{
			int i = 0;
			ListNode p = head;
			ListNode q = null;
			while(i<position && p.getNext()!=null){
				q=p;
				p=p.getNext();
				i++;
			}
			q.setNext(p.getNext());
		}
		length--;
	}
	
	public void display(){
		ListNode p = head;
		if(length>0){
			System.out.println("List Elements are");
		for(int i = 0;i<length;i++){
			System.out.print(p.getData() + "-->");
			p=p.getNext();
		}
		System.out.println("NULL");

		//System.out.println();

	}
		else{
			System.out.println("Nothing to Display");
		}
	}
	
	public void clear(){
		head = null;
		length = 0;
	}
	
	public static void main(String[] args){
	
	LinkedList ll = new LinkedList();	
	System.out.println("Enter the Number of elements to add at end of a Linked List");
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
		
	System.out.println("Enter the Elemnts to add at end");
	Scanner ip = null;
	for(int i=0;i<n;i++){
		ip = new Scanner(System.in);
		int d = ip.nextInt();
		ListNode node = new ListNode(d);
		ll.insertEnd(node);
		}
	ll.display();
	
	System.out.println("\nEnter the Elemnts to add at the begining");
	
	Scanner ipb = null;
	for(int i=0;i<n;i++){
		ipb = new Scanner(System.in);
		int d = ipb.nextInt();
		ListNode node = new ListNode(d);
		ll.insertBegin(node);
		}
	ll.display();
	
	ll.removeBegin();
	System.out.println("\nAfter removing the head");
	ll.display();
	
	ll.removeEnd();
	System.out.println("\nAfter removing the Tail");
	ll.display();
	
	ListNode no = new ListNode(20);
	ll.insertPos(no,2);
	System.out.println("\nAfter Inserting at pos 2");
	ll.display();
	
	ll.removeMatched(20);
	System.out.println("\nAfter removing 20 at pos 2");
	ll.display();
	
	ll.removePos(-1);
	System.out.println("\nAfter removing element given pos -1");
	ll.display();
	
	ll.removePos(20);
	System.out.println("\nAfter removing element given pos 20");
	ll.display();
	
	ll.removePos(2);
	System.out.println("\nAfter removing element at pos 2");
	ll.display();
	
	System.out.println("Enter the Element to delete");
	Scanner ele = new Scanner(System.in);
	int element = ele.nextInt();
	
	if(ll.removeMatched(element) == 1){
	System.out.println("After removing element "+ element);
	ll.display();
	}else{
		System.out.println("Element Not Found");
	}
	
	in.close();
	ip.close();
	ipb.close();
	ele.close();
	
	}
}
