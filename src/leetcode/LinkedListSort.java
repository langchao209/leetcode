package leetcode;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListSort {
	
	public static void print(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
			
		Node left = head;
		Node right = partition(head);
		
		Node left1 = mergeSort(left);
		Node right1 = mergeSort(right);
		
		Node newHead;
		if (left1.value <= right1.value) {
			newHead = left1;
			left1 = left1.next;
		} else {
			newHead = right1;
			right1 = right1.next;
		}
		
		Node current = newHead;
		current.next = null;
		while(left1 != null && right1 != null) {
			if (left1.value <= right1.value) {
				current.next = left1;
				left1 = left1.next;
			} else {
				current.next = right1;
				right1 = right1.next;
			}
			current = current.next;
			current.next = null;
		}
		if (left1 != null) {
			current.next = left1;
		}
		if (right1 != null) {
			current.next = right1;
		}
		
		return newHead;
		
	}
	
	public static Node partition(Node head) {
		
		if (head == null || head.next == null) {
			throw new IllegalArgumentException("The input list should have at least 2 nodes");
		}
		
		Node fast = head;
		Node slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}	
		Node temp = slow.next;
		slow.next = null;
		slow = temp;

		return slow;
	}
	
	public static Node test(int[] a) {
		Node head = new Node(a[0], null);
		Node temp = head;
		for (int i = 1; i < a.length; i++) {
			temp.next = new Node(a[i], null);
			temp = temp.next;
		}
		return head;
	}
	
	public static Node init(int n) {
		int randomNum = ThreadLocalRandom.current().nextInt(100);
		Node head = new Node(randomNum, null);
		
		Node temp = head;
		for (int i = 1; i < n; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(100);
			temp.next = new Node(randomNum, null);
			temp = temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		
//		Node head = init(10);
		Node head = test(new int[]{57, 41, 67, 68, 2, 2, 2, 2});
		print(head);
		System.out.println("Start sorting...");
		Node newHead = mergeSort(head);
		System.out.println("After sorting...");
		print(newHead);
		
	}

}

class Node {
	public int value;
	public Node next;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
}


