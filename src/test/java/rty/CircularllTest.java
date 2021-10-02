package rty;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CircularllTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	    Circularll.head=null;
	    
	}

	@Test
	public void TestDisplay()
	{
	    Circularll.pushFront(10);
		Circularll.Node temp=Circularll.head;
		while(temp.next!=Circularll.head)
		{
		System.out.print(temp.key + " ");
		 assertEquals(temp.key+" ", outContent.toString());
		 System.out.println(temp.key);
		 assertEquals(temp.key, outContent.toString());
	
		}
	}

	@Test
	public void TestPushData()
	{
		 Circularll.pushFront(20);
		 Circularll.pushFront(10);
		 Circularll.pushBack(30);
		 Circularll.pushBack(40);
		 Circularll.Node temp=Circularll.head;
			int i=10;
			while(temp.next!=Circularll.head)
			{
				Assert.assertEquals(i,temp.key);
				i+=10;
				temp=temp.next;
			}
	}
	
	@Test
	public void TestPopData()
	{
		Circularll.pushFront(20);
		 Circularll.pushFront(10);
		 Circularll.pushBack(30);
		 Circularll.pushBack(40);
		 Circularll.popFront();
		 Assert.assertEquals(20,Circularll.head.key);
		 Circularll.popBack();
		 Circularll.Node temp=Circularll.head;
		 while(temp.next!=Circularll.head)
			 temp=temp.next;
		 Assert.assertEquals(30,temp.key);
	}
	@Test (timeout=2)
	public void emptyexception() throws  IllegalArgumentException
	{
		Circularll.popFront();
		Circularll.popBack();
		 
	}
	@Test (expected=NullPointerException.class)
	public void nullexception()
	{
		Circularll.Node temp=Circularll.head;
		 while(temp.next!=null)
			 temp=temp.next;
	}
	@Test
	public void assertingtrue()
	{
		Assert.assertNull(Circularll.head);
	}
   @Test
   public void assertingfalse()
   {
	   Circularll node =new Circularll();
	   Circularll.Node nodeone=new Circularll.Node(10);
	   Assert.assertNotSame(node, nodeone);
   }
   @Test
   public void checkhead()
   {
	   Circularll.pushFront(20);
		 Circularll.pushFront(10);
		 Circularll.pushBack(30);
		 Circularll.pushBack(40);
		 Assert.assertEquals(10, Circularll.head.key);
   }
}
