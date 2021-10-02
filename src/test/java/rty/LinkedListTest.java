package rty;
import static org.junit.Assert.*;

import java.rmi.AccessException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import rty.LinkedList.Node;

@SuppressWarnings({ "unused", "deprecation" })
public class LinkedListTest {

	private LinkedList ll;
	@Before
	public void setUp() throws Exception {
		ll=new LinkedList(); 
	}
   @After 
   public void setUP() throws Exception
   {
	   LinkedList.head=null;
   }
	@Test
	public void pushdata() {
	
		LinkedList.pushFront(20);
		LinkedList.pushFront(10);
		LinkedList.pushBack(30);
		LinkedList.pushBack(40);
		LinkedList.Node temp=LinkedList.head;
		int i=10;
		while(temp!=null)
		{
			Assert.assertEquals(i,temp.key);
			i+=10;
			temp=temp.next;
		}
		
			
	}
	
	@Test
	public void popfrontdata()
	{
		LinkedList.pushFront(80);
		LinkedList.pushFront(90);
		LinkedList.popFront();
		LinkedList.Node node1=new LinkedList.Node(80);
		LinkedList.Node node2=LinkedList.head;
		Assert.assertEquals(node1.key,node2.key);
	}

	@Test
	public void popbackdata() {
		LinkedList.pushBack(30);
		LinkedList.pushBack(40);
		LinkedList.popBack();
		LinkedList.Node creatingnode1=new LinkedList.Node(30);
		LinkedList.Node creatingnode2=new LinkedList.Node(LinkedList.head.key);
		Assert.assertEquals(creatingnode1.key,creatingnode2.key);
	}
	
   @Test (expected=NullPointerException.class)
   public void popnull()
   {
	   //It should throw null pointer exception
	   LinkedList.popFront();
	   
   }
   @Test (timeout=3)
   public void checkinsertiontime()
   {
	   LinkedList.pushFront(10);
	   LinkedList.pushFront(20);
	   LinkedList.pushFront(30);
   }
   @Test
   public void PopPosTest()
   {
	   LinkedList.pushFront(10);
	   LinkedList.pushFront(20);
	   LinkedList.pushFront(30);
	   LinkedList.pushFront(40);
	   LinkedList.pushFront(50);
	   LinkedList.pushFront(60);
	   LinkedList.pop(0);
	   LinkedList.Node temp=LinkedList.head;
		int j=50;
		
		while(temp!=null)
		{
		//	System.out.println(LinkedList.temp.key);
			Assert.assertEquals(j,temp.key);
		j-=10;
			temp=temp.next;
		
		}
			   
   }
   @Test 
   public void Popmiddle()
   {
	   LinkedList.pushBack(0);

	   LinkedList.pushBack(20);

	   LinkedList.pushBack(30);

	   LinkedList.pushBack(40);
	   LinkedList.pop(2);
	   int [] array= {0,20,40};
	   LinkedList.Node temp=LinkedList.head;
	   int i=0;
	   while(temp!=null)
		{
		
			Assert.assertEquals(array[i],temp.key);
		i+=1;
			temp=temp.next;
		
		}
	   }
     @Test
     public void assertions()
     {
    	 Assert.assertNull(LinkedList.head);
    	 Assert.assertFalse(LinkedList.head!=null);
     }
     @Test
     public void sameassert()
     {
    	 LinkedList.Node node=new LinkedList.Node(0);
    	 Assert.assertNotSame(node, ll);
     }
}
