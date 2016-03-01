package linkedlist;

import java.util.Scanner;

public class LinkedList {
	static ListNode head;
	static int length;
	
	public ListNode getHead(){
		return head;
	}
	
	public static void insertBegin(ListNode node){
		
		if(head == null){
			head = node;
		}
		else{
			node.setNext(head);
			head = node;
		}
		length++;
	}
	
	public static void insertEnd(ListNode node){
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
	
	public static void insertPos(ListNode node,int position){
		
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
	
	public static void removeBegin(){
		if(head == null)
			System.out.println("No Elements to Remove");
		else{
		head = head.getNext();
		length--;
		}
	}
	
	public static void removeEnd(){
		if(head == null)
			System.out.println("No Elements to Delete");
		else{
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
			p.setNext(null);
			length--;
		}
	}
	
	public static int removeMatched(int data){
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
	
	public static void removePos(int position){
		
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
	
	public static void display(){
		ListNode p = head;
		if(length>0){
			System.out.println("List Elements are");
		for(int i = 0;i<length;i++){
			System.out.print(p.getData() + "-->");
			p=p.getNext();
		}
		System.out.println("NULL");
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
		
	System.out.println("Enter the Number of elements to add at end of a Linked List");
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
		
	System.out.println("Enter the Elemnts to add at end");
	Scanner ip = null;
	for(int i=0;i<n;i++){
		ip = new Scanner(System.in);
		int d = ip.nextInt();
		ListNode node = new ListNode(d);
		insertEnd(node);
		}
	display();
	
	System.out.println("\nEnter the Elemnts to add at the begining");
	
	Scanner ipb = null;
	for(int i=0;i<n;i++){
		ipb = new Scanner(System.in);
		int d = ipb.nextInt();
		ListNode node = new ListNode(d);
		insertBegin(node);
		}
	display();
	
	removeBegin();
	System.out.println("\nAfter removing the head");
	display();
	
	removeEnd();
	System.out.println("\nAfter removing the Tail");
	display();
	
	ListNode no = new ListNode(20);
	insertPos(no,2);
	System.out.println("\nAfter Inserting at pos 2");
	display();
	
	removeMatched(20);
	System.out.println("\nAfter removing 20 at pos 2");
	display();
	
	removePos(-1);
	System.out.println("\nAfter removing element given pos -1");
	display();
	
	removePos(20);
	System.out.println("\nAfter removing element given pos 20");
	display();
	
	removePos(2);
	System.out.println("\nAfter removing element at pos 2");
	display();
	
	System.out.println("Enter the Element to delete");
	Scanner ele = new Scanner(System.in);
	int element = ele.nextInt();
	
	if(removeMatched(element) == 1){
	System.out.println("After removing element "+ element);
	display();
	}else{
		System.out.println("Element Not Found");
	}
	
	in.close();
	ip.close();
	ipb.close();
	ele.close();
	
	}
}
