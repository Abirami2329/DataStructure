package linkedlist;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LinkedList {
	static LinkedList llist = new LinkedList();
	static Logger logger = Logger.getLogger(LinkedList.class.getName());
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
	    	logger.info("The given previous node cannot be null");
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
	    while (last.next != null) {
            last = last.next;
        }
	    last.next = newNode;
	  }
	  void deleteNode(int position) {
	    if (head == null) {
            return;
        }
	    Node temp = head;
	    if (position == 0) {
	      head = temp.next;
	      return;
	    }
	    for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;   
        }
	    if (temp == null || temp.next == null) {
	      return;
        }
	    Node next = temp.next.next;
	    temp.next = next;
	  }
	  boolean search(Node head, int key) {
	    Node current = head;
	    while (current != null) {
	      if (current.data == key) {
	        return true;
          }
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
	    	logger.log(Level.SEVERE,tnode.data + " ");
	      tnode = tnode.next;
	    }

	  }
	  public static int getInputValue() {
		  Scanner sc= new Scanner(System.in);
		  logger.info("\nEnter Number: ");
		  return sc.nextInt();
	  }
	  public static void showInsertOption() {
		  logger.info("\n1.INSERT AT BEGINNING\n2.INSERT AT END\n3.INSERT AFTER PARTICULAR VALUE");
		  Scanner sc= new Scanner(System.in);
		  logger.info("\nEnter your choice: ");
		  int choice= sc.nextInt();
		  switch(choice) {
			case 1:
				int inputBeginValue = getInputValue();
				llist.insertAtBeginning(inputBeginValue);
				logger.info("\nINSERTED SUCCESSFULLY IN BEGINNING");
				showOption();
				break;
			case 2:
				int inputEndValue = getInputValue();
				llist.insertAtBeginning(inputEndValue);
				logger.info("\nINSERTED SUCCESSFULLY IN END");
				showOption();
				break;
			case 3:
				logger.info("\nEnter the index of the exsiting numbers: ");
				int inputSearchValue= sc.nextInt();
				int inputIntValue = getInputValue();
				llist.insertAfter(llist.head.next, inputIntValue);
				logger.info("\nINSERTED SUCCESSFULLY AFTER " + inputSearchValue);
				showOption();
				break;
            default:
                break;
			}
		  
		  }
	  public static void showOption() {
		  logger.info("\n1.INSERT\n2.DELETE\n3.SEARCH\n4.SORT\n5.SHOWlIST");
			Scanner sc= new Scanner(System.in);
			logger.info("\nEnter your choice: ");
			int choice= sc.nextInt();
			switch(choice) {
			case 1:
				showInsertOption();
				break;
			case 2:
				 logger.info("\nBefore deleting an element: ");
				 llist.printList();
				 logger.info("\nEnter index value of the Number: ");
				int inputDeleteValue= sc.nextInt();
				llist.deleteNode(inputDeleteValue);
				logger.info("\nAfter deleting an element: ");
				 llist.printList();
				 logger.info("\nDELETED SUCCESSFULLY");
				 showOption();
				break;
			case 3:
				logger.info("\nEnter Search Number: ");
				int itemToFind =  sc.nextInt();
			    if (llist.search(llist.head, itemToFind))
			      logger.log(Level.SEVERE,itemToFind + " is found\n");
			    else
			      logger.log(Level.SEVERE,itemToFind + " is not found\n");
			    showOption();
				break;
			case 4:
				 llist.sortLinkedList(llist.head);
				    logger.info("\nSorted List: ");
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
		  logger.info("\nEnter the size of linked list");
		  Scanner scn= new Scanner(System.in);
		  int sizeOfLinkedList =  scn.nextInt();
		  for(int i = 0; i < sizeOfLinkedList; i++) {
			  logger.info("\nEnter the Value");
			  Scanner scr= new Scanner(System.in);
			  int linkedListValue =  scr.nextInt();
			  llist.insertAtEnd(linkedListValue);
		  }
		  logger.info("\nCREATED SUCCESSFULLY");
		  showOption();
		  }

	public static void main(String[] args) {
		logger.info("LINKED LIST");
		createList();
	  }
	}

