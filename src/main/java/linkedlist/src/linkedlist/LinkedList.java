package linkedlist;

import java.util.Scanner;

public class LinkedList {
	static LinkedList llist = new LinkedList();
	Node head;
	  class Node {
	    int data;
	    Node next;

	    Node(int d) {
	      data = d;
	      next = null;
	    }
	  }
	  public void insertAtBeginning(int newData) {
	    Node newNode = new Node(newData);
	    newNode.next = head;
	    head = newNode;
	  }
	  public void insertAfter(Node prevNode, int newData) {
	    if (prevNode == null) {
	      System.out.println("The given previous node cannot be null");
	      return;
	    }
	    Node newNode = new Node(newData);
	    newNode.next = prevNode.next;
	    prevNode.next = newNode;
	  }
	  public void insertAtEnd(int newData) {
	    Node newNode = new Node(newData);

	    if (head == null) {
	      head = new Node(newData);
	      return;
	    }
	    newNode.next = null;
	    Node last = head;
	    while (last.next != null)
	      last = last.next;

	    last.next = newNode;
	  }
	  void deleteNode(int position) {
	    if (head == null) 
	      return;
	    Node temp = head;
	    if (position == 0) {
	      head = temp.next;
	      return;
	    }
	    for (int i = 0; temp != null && i < position - 1; i++)
	      temp = temp.next;
	    if (temp == null || temp.next == null)
	      return;
	    Node next = temp.next.next;

	    temp.next = next;
	  }
	  boolean search(Node head, int key) {
	    Node current = head;
	    while (current != null) {
	      if (current.data == key)
	        return true;
	      current = current.next;
	    }
	    return false;
	  }
	  void sortLinkedList(Node head) {
	    Node current = head;
	    Node index = null;
	    int temp;

	    if (head != null) {
	      while (current != null) {
	        index = current.next;

	        while (index != null) {
	          if (current.data > index.data) {
	            temp = current.data;
	            current.data = index.data;
	            index.data = temp;
	          }
	          index = index.next;
	        }
	        current = current.next;
	      }
	    }
	  }
	  public void printList() {
	    Node tnode = head;
	    while (tnode != null) {
	      System.out.print(tnode.data + " ");
	      tnode = tnode.next;
	    }

	  }
	  public static void showInsertOption() {
		  System.out.print("\n1.INSERT AT BEGINNING\n2.INSERT AT END\n3.INSERT AFTER PARTICULAR VALUE");
		  Scanner sc= new Scanner(System.in);
		  System.out.print("\nEnter your choice: ");
		  int choice= sc.nextInt();
		  switch(choice) {
			case 1:
				System.out.println("\nEnter Number: ");
				int inputBeginValue= sc.nextInt();
				llist.insertAtBeginning(inputBeginValue);
				System.out.print("\nINSERTED SUCCESSFULLY IN BEGINNING");
				showOption();
				break;
			case 2:
				System.out.println("\nEnter Number: ");
				int inputEndValue= sc.nextInt();
				llist.insertAtBeginning(inputEndValue);
				System.out.print("\nINSERTED SUCCESSFULLY IN END");
				showOption();
				break;
			case 3:
				System.out.println("\nEnter the index of the exsiting numbers: ");
				int inputSearchValue= sc.nextInt();
				System.out.println("\nEnter Number: ");
				int inputIntValue= sc.nextInt();
				llist.insertAfter(llist.head.next, inputIntValue);
				System.out.print("\nINSERTED SUCCESSFULLY AFTER " + inputSearchValue);
				showOption();
				break;
            default:
                break;
			}
		  
		  }
	  public static void showOption() {
		  System.out.println("\n1.INSERT\n2.DELETE\n3.SEARCH\n4.SORT\n5.SHOWlIST");
			Scanner sc= new Scanner(System.in);
			System.out.println("\nEnter your choice: ");
			int choice= sc.nextInt();
			switch(choice) {
			case 1:
				showInsertOption();
				break;
			case 2:
				 System.out.println("\nBefore deleting an element: ");
				 llist.printList();
				 System.out.println("\nEnter index value of the Number: ");
				int inputDeleteValue= sc.nextInt();
				llist.deleteNode(inputDeleteValue);
				System.out.println("\nAfter deleting an element: ");
				 llist.printList();
				 System.out.print("\nDELETED SUCCESSFULLY");
				 showOption();
				break;
			case 3:
				System.out.println("\nEnter Search Number: ");
				int itemToFind =  sc.nextInt();
			    if (llist.search(llist.head, itemToFind))
			      System.out.println(itemToFind + " is found\n");
			    else
			      System.out.println(itemToFind + " is not found\n");
			    showOption();
				break;
			case 4:
				 llist.sortLinkedList(llist.head);
				    System.out.println("\nSorted List: ");
				    llist.printList();
				    showOption();
				break;
			case 5:
				llist.printList();
				showOption();
				break;
            default:
                break;
			}
			
	  }
	  public static void createList() {
		  System.out.println("\nEnter the size of linked list");
		  Scanner scn= new Scanner(System.in);
		  int sizeOfLinkedList =  scn.nextInt();
		  for(int i = 0; i < sizeOfLinkedList; i++) {
			  System.out.println("\nEnter the Value");
			  Scanner scr= new Scanner(System.in);
			  int linkedListValue =  scr.nextInt();
			  llist.insertAtEnd(linkedListValue);
		  }
		  System.out.print("\nCREATED SUCCESSFULLY");
		  showOption();

		  }

	public static void main(String[] args) {
		System.out.println("LINKED LIST");
		createList();
	  }
	}

