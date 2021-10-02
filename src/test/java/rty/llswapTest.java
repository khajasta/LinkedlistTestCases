package rty;

import static org.junit.Assert.*;

import java.net.BindException;

import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings({ "deprecation", "unused" })
public class llswapTest {
	
	@After
	public void EmptyList()
	{
		  llswap.head=null;
		  llswap.size=0;
	}

	@Test
	public void PushData()
	{
		llswap.pushBack(0);
		llswap.pushBack(10);
		llswap.pushBack(15);
		   llswap.Node temporary=llswap.head;
		for(int i=0;i<llswap.size;i++)
		{
		
			System.out.print(temporary.key);
			temporary=temporary.next;
		}
	}
	@Test
	public void TestPushData() {
	    llswap.pushFront(20);
	    llswap.pushFront(10);
	    llswap.pushBack(30);
	    llswap.pushBack(40);
	    llswap.Node temp=llswap.head;
		int i=10;
		while(temp!=null)
		{
			Assert.assertEquals(i,temp.key);
			i+=10;
			temp=temp.next;
		}
	}
	
   @Test
   public void TestSwap()
   {
	 
	    llswap.pushFront(10);
	    llswap.pushBack(30);
	    llswap.pushBack(20); 
	    llswap.pushBack(40);
	    llswap.swap();
	    llswap.Node temp=llswap.head;
		int i=40;
		while(temp!=null)
		{
			Assert.assertEquals(i,temp.key);
			i-=10;
			temp=temp.next;
		}
   }
   @Test(expected=NullPointerException.class)
   public void exceptions()
   {
	   llswap.Node pointerone=llswap.head;
		int increment=10;
		while(pointerone.next!=null)
		{
		
			increment=increment+10;
			pointerone=pointerone.next;
		}
	   
   }

   @Test
   public void checksize()
   {
	    llswap.pushFront(10);
	    llswap.pushBack(30);
	    llswap.pushBack(20); 
	    llswap.pushBack(40);
	    Assert.assertEquals(4,llswap.size);
   }
   @Test(timeout=1)
   public void nullpointer()
   {
	   Assert.assertNull(llswap.head);
   }
   @Test
   public void emptylist() throws IllegalArgumentException
   {
	   llswap.swap();	
   }
   @Test
   public void assertions()
   {
  	 Assert.assertNull(llswap.head);
  	 Assert.assertTrue(llswap.head==null);
   }
}
