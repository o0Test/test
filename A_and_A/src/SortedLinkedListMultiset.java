import java.io.PrintStream;
import java.util.*;


public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	Node head;
	
	protected class Node
	{
		T item;
		Node next;
		int count;
		public Node(T item)
		{
			this.item = item;
			next = null;
			count = 1;
		}
	}
	
	
	public SortedLinkedListMultiset() {
		head = null;
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		if(head == null)
		{
			head = new Node(item);
			return;
		}else if(head.item.equals(item))
		{
			head.count++;
			return;
		//}else if(head.item.toString().compareTo(item.toString())>0)
		}else if(head.item.toString().compareTo(item.toString())>0)
		{
			Node buffer = head;
			head = new Node(item);
			head.next = buffer;
			return;
		}
		Node i = head;
		for(; i.next!=null; i=i.next)
		{
			if(i.next.item.equals(item))
			{
				i.next.count++;
				return;
			}else if(i.next.item.toString().compareTo(item.toString())>0)
			{
				Node buffer = i.next;
				i.next = new Node(item);
				i.next.next = buffer;
				return;
			}
		}
		i.next = new Node(item);
	} // end of add()
	
	
	public int search(T item) {
		if(head == null)
		{
			return 0;
		}else if(head.item.equals(item))
		{
			return head.count;
		}
		Node i = head;
		for(; i.next!=null; i=i.next)
		{
			if(i.next.item.equals(item))
			{
				return i.next.count;
			}
		}
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		if(head == null)
		{
			return;
		}else if(head.item.equals(item))
		{
			if(head.count>1)
			{
				head.count--;
			}else{
				head = head.next;
			}
			return;
		}
		Node i = head;
		for(; i.next!=null; i=i.next)
		{
			if(i.next.item.equals(item))
			{
				if(i.next.count>1)
				{
					i.next.count--;
				}else{
					i.next = i.next.next;
				}
				return;
			}
		}
		return;
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		if(head == null)
		{
			return;
		}else if(head.item.equals(item))
		{
			head = head.next;
			return;
		}
		Node i = head;
		for(; i.next!=null; i=i.next)
		{
			if(i.next.item.equals(item))
			{
				i.next = i.next.next;
				return;
			}
		}
		return;
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		for(Node i=head;i!=null;i=i.next)
		{
			System.out.println(i.item + printDelim + i.count);
		}
	} // end of print()
	
} // end of class SortedLinkedListMultiset