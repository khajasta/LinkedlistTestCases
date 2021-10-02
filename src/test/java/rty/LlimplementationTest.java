package rty;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings({ "deprecation", "unused" })
public class LlimplementationTest {


	Llimplementation node;
	@Before
	public void intiate()
	{
		node=new Llimplementation();
	}
	@After
	public void empty()
	{
		Llimplementation.headPointer=null;
		
	}

	@Test
	public void testadd() {
		node.add(10);
		node.add(20);
		node.add(30);
		node.add(40);
		Llimplementation pointerone=Llimplementation.headPointer;
		int increment=10;
		while(pointerone!= null)
		{
			Assert.assertEquals(increment, pointerone.data);
			increment+=10;
			pointerone=pointerone.nextPointer;
		}
		
	}
	@Test
	public void TestPushData()
	{
        node.pushFront(20);
		node.pushFront(10);
		node.pushBack(30);
		node.pushBack(40);
		Llimplementation temp=Llimplementation.headPointer;
		int i=10;
		while(temp!=null)
		{
			Assert.assertEquals(i,temp.data);
			i+=10;
			temp=temp.nextPointer;
		}
	}
	@Test
	public void TopFrontBack() throws Exception
	{
		 node.pushFront(20);
	     node.pushFront(10);
	     node.pushBack(30);
	     Assert.assertEquals(10, node.topFront());
	     Assert.assertEquals(30, node.topBack());
	}
   @Test
   public void Testpop() throws Exception
   {
	   node.pushFront(10);
	     node.pushFront(20);
	     node.popFront();
	     Llimplementation temp=Llimplementation.headPointer;
	     Assert.assertEquals(10, temp.data);
	     
   }
   
   @Test 
   public void TestSize()
   {
	   node.pushFront(20);
	     node.pushFront(10);
	     node.pushBack(30);
          //number of elements in this linked list should be 3 
	     Assert.assertEquals(3, Llimplementation.numofElements);
   }
  @Test (timeout=2)
  public void assertions()
  {
	  node.pushFront(20);
	     node.pushFront(10);
	     node.pushBack(30);
	  Assert.assertNotNull(node);
  }
   @Test(expected=NullPointerException.class)
   public void exceptions()
   {
	   node.add(10);
		node.add(20);
		node.add(30);
		node.add(40);
		Llimplementation pointerone=Llimplementation.headPointer;
		int increment=10;
		while(pointerone!=Llimplementation.tailPointer)
		{
			Assert.assertEquals(increment, pointerone.data);
			increment+=10;
			pointerone=pointerone.nextPointer;
		}
	   
   }
 @Test
 public void asserting()
 {
	Assert.assertNotSame(node,Llimplementation.headPointer);
	
 }
 @Test(timeout=2) 
 public void assertingwrong()
 {
	 Assert.assertEquals(node.size(),Llimplementation.numofElements);
	 Assert.assertNull(Llimplementation.headPointer);
 }
 @Test
 public void tailpointer()
 {
	 Assert.assertSame(Llimplementation.headPointer, Llimplementation.tailPointer);
 }
 @Test
 public void assertingtrue ()
 {
	 node.pushFront(40);
     node.pushFront(50);
     node.pushBack(60);
     Assert.assertEquals(60, Llimplementation.tailPointer.data);
 }
}
