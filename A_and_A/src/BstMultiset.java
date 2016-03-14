import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	Node head;
	
	protected class Node
	{
		Node left;
		T item;
		int count;
		Node right;
		
		public Node(T item)
		{
			left = null;
			this.item = item;
			count = 1;
			right = null;
		}
		public void add(T item)
		{
			if(this.item.equals(item))
			{
				count++;
			}else if(this.item.toString().compareTo(item.toString())>0)
			{
				if(left == null)
				{
					left = new Node(item);
				}else{
					left.add(item);
				}
			}else{
				if(right == null)
				{
					right = new Node(item);
				}else{
					right.add(item);
				}
			}
		}
		public int search(T item)
		{
			if(this.item.equals(item))
			{
				return count;
			}else if(this.item.toString().compareTo(this.toString())>0)
			{
				if(left == null)
				{
					return 0;
				}else{
					return left.search(item);
				}
			}else{
				if(right == null)
				{
					return 0;
				}else{
					return right.search(item);
				}
			}
		}
		


		public void removeOne(T item) {
			if(this.item.toString().compareTo(item.toString())>0)
			{
				if(left == null)
				{
					return;
				}
				if(left.item.equals(item))
				{
					left.count--;
					if(left.count==0
							&& !left.fill())
					{
						left = null;
					}
				}else
				{
					left.removeOne(item);
				}
			}else{
				if(right == null)
				{
					return;
				}
				if(right.item.equals(item))
				{
					right.count--;
					if(right.count==0
							&& !right.fill())
					{
						right = null;
					}
				}else
				{
					right.removeOne(item);
				}
			}
		}
		
		public boolean fill()
		{
			if(left != null)
			{
				if(left.right == null)
				{
					item = left.item;
					count = left.count;
					left = left.left;
				}else{
					Node i = this.left;
					for(;i.right.right!=null;i=i.right){}
					item = i.right.item;
					count = i.right.count;
					i.right = i.right.left;
				}
			}else if(right != null)
			{
				if(right.left == null)
				{
					item = right.item;
					count = right.count;
					right = right.right;
				}else{
					Node i = this.right;
					for(;i.left.left!=null;i=i.left){}
					item = i.left.item;
					count = i.left.count;
					i.left = i.left.right;
				}
			}else{
				return false;
			}
			return true;
		}
		
		public void removeAll(T item) {
			if(this.item.toString().compareTo(item.toString())>0)
			{
				if(left == null)
				{
					return;
				}
				if(left.item.equals(item))
				{
					if(!left.fill())
					{
						left = null;
					}
				}else
				{
					left.removeAll(item);
				}
			}else{
				if(right == null)
				{
					return;
				}
				if(right.item.equals(item))
				{
					if(!right.fill())
					{
						right = null;
					}
				}else
				{
					right.removeAll(item);
				}
			}
		}//
		
		public void print(PrintStream out)
		{
			if(left != null)
			{
				left.print(out);
			}
			System.out.println(item + printDelim + count);
			if(right != null)
			{
				right.print(out);
			}
		}
	}
	
	public BstMultiset() {
		head = null;
	} // end of BstMultiset()

	public void add(T item) {
		if(head == null)
		{
			head = new Node(item);
		}else{
			head.add(item);
		}
	} // end of add()


	public int search(T item) {
		if(head == null)
		{
			return 0;
		}
		return head.search(item);
	} // end of add()


	public void removeOne(T item) {
		if(head == null)
		{
			return;
		}
		if(head.item.equals(item))
		{
			head.count--;
			if(head.count==0
					&& !head.fill())
			{
				head = null;
			}
			return;
		}
		head.removeOne(item);
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		if(head == null)
		{
			return;
		}
		if(head.item.equals(item))
		{
			if(!head.fill())
			{
				head = null;
			}
			return;
		}
		head.removeAll(item);
	} // end of removeAll()


	public void print(PrintStream out) {
		if(head == null)
		{
			return;
		}
		head.print(out);
	} // end of print()

} // end of class BstMultiset
