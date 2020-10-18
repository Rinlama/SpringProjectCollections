package com.main.ds;

public class LinearDS {
	
	public static class Node{
		int data;
		Node next;
	}
	public static class LinkedList{
		
		public Node head;
		
		public void insert(int data){
			Node n=new Node();
			n.data=data;
			
			if(head==null){
				head=n;
			}else{
				Node current= head;
				while(current.next!=null){
					current=current.next;
				}
				current.next=n;
			}
			
		}
		public void show(){
			Node current=head;
			while(current.next!=null){
				System.out.println(current.data);
				current=current.next;
			}
			System.out.println(current.data);
			
		}
		
		public void addToStart(int data){
			Node n=new Node();
			n.data=data;
			
			n.next=head;
			head=n;
			
		}
		public void addAfter(int insertAfter, int newdata){
			
			Node current=head;
			while(current.next!=null){
				if(current.data==insertAfter){
					//do here
					Node n=new Node();
					n.data=newdata;
					//insert
					n.next=current.next;
					current.next=n;
					break;
				}
				current=current.next;
			}
			
		}
	
		public void deletelast(){
			
			Node curr=head;
			Node secondlast=null;
			while(curr.next!=null){
				secondlast=curr;
				curr=curr.next;
			}
			secondlast.next=null;
			System.out.println(curr.data);
		}
		
		public void deleteStart(){
			head=head.next;
		}
		public void deleteAfterNode(int deleteAfter){
			
	
			Node delete=null;
			
			Node curr=head;
			while(curr!=null){
				
				if(curr.data==deleteAfter && curr.next!=null){
					delete=curr.next;
					curr.next=delete.next;
					break;
				}
				
				curr=curr.next;
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l=new LinkedList();
		l.insert(1);
		l.insert(7);
		l.insert(12);
		//l.addToStart(12);
	  //	l.addAfter(12,0);
		//l.deletelast();
		//l.deleteStart();
		l.deleteAfterNode(1);
		System.out.println("*************");
		l.show();
	}

}
