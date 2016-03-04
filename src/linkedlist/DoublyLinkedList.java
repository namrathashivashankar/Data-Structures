package linkedlist;

import java.util.Scanner;

public class DoublyLinkedList {
	 DLLNode head;
	 int length;
	
	public  void insertEnd(int data){
		DLLNode node = new DLLNode(data);
		
		if(head ==null){
			head = node; 
		}else{
			DLLNode p = head;
			while(p.getNext()!=null){
				p=p.getNext();
			}
			p.setNext(node);
			node.setPrev(p);
		}
		length++;
		
	}
	
	public  void insertBegin(int data){
		DLLNode node = new DLLNode(data);
		
		if(head == null){
			head = node;
		}else{
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
		length++;
	}
	
	public  void insertPos(int pos,int data){
		if(pos < 0){
			pos = 0;
		}if(pos > length){
			pos = length;
		}
		if(pos == 0){
			insertBegin(data);
		}else if(pos==length){
			insertEnd(data);
		}else{
			int i = 0;
			DLLNode node = new DLLNode(data); 
			DLLNode p = head; 
			while(i!=pos-1){
				p = p.getNext();
				i++;
			}
			node.setPrev(p);
			node.setNext(p.getNext());
			(p.getNext()).setPrev(node);
			 p.setNext(node);
			 length++;
		}
		
		
	}
	
	public  void removeBegin(){
		if(length == 1){
			System.out.println("Deleted " + head.getData() + ",No elements to delete");
			head= null;
			length--;
		}else if (length < 1){
			System.out.println("No more Elements to Delete");
		}else{
			head = head.getNext();
			length--;
		}
	}
	
	public  void removeEnd(){
		if(length == 1){
			System.out.println("Deleted " + head.getData() + " ,No more elements to delete");
			head = null;
			length--;
		}else if(length < 1){
			System.out.println("No more elements to delete");
		}else{
			DLLNode p = head;
			DLLNode q;
			while((q = p.getNext())!=null){
				p = p.getNext();
			}
			p.getPrev().setNext(null);
		length--;
	}
}	
	public  void removePos(int pos){
		if(pos<=0){
			removeBegin();
		}else if(pos>=length){
			removeEnd();
		}else{
			DLLNode p= head;
			DLLNode q;
			int i=0;
			while(i<pos-1){
				p=p.getNext();
				i++;
			}
			p.getNext().getNext().setPrev(p);
			p.setNext(p.getNext().getNext());
			length--;
		}
	}
	
	public  int removeMatched(int data){
		DLLNode p = head;
		while(p!=null){
			if(p.getData()== data && p.getNext()!=null){
				p.getPrev().setNext(p.getNext());
				p.getNext().setPrev(p.getPrev());
				length--;
				return 1;
			}
			p=p.getNext();
		}
		return 0;
	}
	
	public void display(){
		
		DLLNode p = head;
		if(head == null){
			System.out.println("No Elements in the List");
		}
		
		while(p!=null){
			System.out.print(p.getData() + "<-->");
			p = p.getNext();
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args){
		DoublyLinkedList dl = new DoublyLinkedList();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		
		System.out.println("Enter the elements to add at the End");
		Scanner inE = null;
		for(int i=0;i<n;i++){
			inE= new Scanner(System.in);
			int ele = inE.nextInt();
			dl.insertEnd(ele);
		}
		dl.display();
		
		System.out.println("Enter the elements to add at the Begining");
		Scanner inB = null;
		for(int i=0;i<n;i++){
			inB= new Scanner(System.in);
			int ele = inB.nextInt();
			dl.insertBegin(ele);
		}
		dl.display();
		
		System.out.println("\nEnter the position and data to insert");
		Scanner ini = new Scanner(System.in);
		int ipos = ini.nextInt();
		Scanner ie = new Scanner(System.in);
		int data = ie.nextInt();
		dl.insertPos(ipos,data);
		System.out.println("\nAfter inserting " + data + "at position" + ipos);
		dl.display();
		
		System.out.println("\nAfter Deleting the last Element from the list");
		dl.removeEnd();
		dl.display();
		
		System.out.println("\nAfter Deleting the first element from the list");
		dl.removeBegin();
		dl.display();
		
		System.out.println("\nEnter the position of the element to delete");
		Scanner inr = new Scanner(System.in);
		int pos = inr.nextInt();
		dl.removePos(pos);
		dl.display();
		
		System.out.println("\nEnter the Element to Delete");
		Scanner er = new Scanner(System.in);
		int eler = er.nextInt();
		dl.removeMatched(eler);
		System.out.println("\nAfter deleting " + eler + " from the list");
		dl.display();
		
		in.close();
		inB.close();
		inE.close();
		ini.close();
		ie.close();
		inr.close();
		er.close();
	}
	
}
