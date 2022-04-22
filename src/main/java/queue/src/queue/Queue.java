package queue;

import java.util.Scanner;

public class Queue {
	private static int front = 0;
	private static int rear = 0;
	private static int capacity; 
    private static int[] queueList;
	static int queueSize = 0;
	static Queue q = new Queue(100);
   
    Queue(int size) {  
	front = rear = 0;
        capacity = size; 
        queueList = new int[capacity]; 
    } 
    void queueEnqueue(int item)  { 
        if (capacity == rear) {
            System.Out.println("\nQueue is full\n"); 
        } 
        else {
        	queueList[rear] = item; 
            rear++; 
        } 
        return;
    } 
    void queueDequeue()  { 
        if (front == rear) { 
            System.Out.println("\nQueue is empty\n"); 
        } 
        else { 
            for (int i = 0; i < rear - 1; i++) { 
            	queueList[i] = queueList[i + 1]; 
            } 
            if (rear < capacity) 
            	queueList[rear] = 0; 
            rear--; 
        }
	return;
    } 
    void queueDisplay() 
    { 
        int i; 
        if (front == rear) { 
            System.Out.println("Queue is Empty\n"); 
            return; 
        } 
        for (i = front; i < rear; i++) { 
            System.Out.println(" %d <= ", queueList[i]); 
        } 
    } 
   
    void queueFront() 
    { 
        if (front == rear) { 
            System.Out.println("Queue is Empty\n"); 
            return; 
        } 
        System.Out.println("\nFront Element of the queue: %d", queueList[front]); 
    } 
    public static void showOption() {
		  System.Out.println("\n1.ENQUEUE\n2.DEQUEUE\n3.FRONT ELEMENT OF QUEUE\n4.SHOW QUEUE LIST");
			Scanner sc= new Scanner(System.in);
			System.Out.println("\nEnter your choice: ");
			int choice= sc.nextInt();
			switch(choice) {
			case 1:
				System.Out.println("\nEnter Number: ");
				int enqueueElement =  sc.nextInt();
				q.queueEnqueue(enqueueElement);
				showOption();
				break;
			case 2:
				q.queueDequeue();
				showOption();
				break;
			case 3:
				q.queueFront();
			    showOption();
				break;
			case 4:
			      System.Out.print("Elements present in Queue :");
			        q.queueDisplay();
				  showOption();
				break;
			default:
				break;
			}
    }
    public static void createQueue() {
    	System.Out.println("\nEnter the size of queue");
		  Scanner scn= new Scanner(System.in);
		  queueSize = scn.nextInt();
		  for(int i = 0; i < queueSize; i++) {
			  System.Out.println("\nEnter the Value : ");
			  int queueValue =  scn.nextInt();
			  q.queueEnqueue(queueValue); 
			  
		  }
		  System.Out.print("\nCREATED SUCCESSFULLY");
		  showOption();
    }
	
	public static void main(String[] args) { 
		System.Out.println("QUEUE");
		 createQueue();
    } 

}
