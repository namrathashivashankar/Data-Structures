package linkedlist;

public class CircularLinkedList {

	CLLNode head;
	int length;
	
	public void insertBegin(int data){
		CLLNode node =  new CLLNode(data);
		if(head == null){
			head = node;
			head.setNext(head);
		}
		else{
			CLLNode p = head;
			while(p.getNext()!=head){
				p = p.getNext();
			}
			node.setNext(head);
			p.setNext(node);
			head = node;
		}
		length++;
	}
	
	public void display(){
		CLLNode p = head.getNext();
		System.out.print(head.getData()+ "-->");
		while(p!=head){
			System.out.print(p.getData()+ "-->");
			p = p.getNext();
		}
		System.out.print(head.getData());
		System.out.println();
	}
	
	public static void main(String[] args){
		CircularLinkedList cl = new CircularLinkedList();
		cl.insertBegin(1);
		cl.insertBegin(2);
		cl.insertBegin(3);
		cl.insertBegin(4);
		cl.insertBegin(5);
		cl.display();
	}
}
