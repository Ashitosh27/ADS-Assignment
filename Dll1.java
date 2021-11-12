class Dll1
{
    Node head;
   static class Node
   {
      int data;
	  Node prev;
	  Node next;
	  
	  Node(int d)
	  {
	    data=d;
		prev=null;
		next=null;
	  }
   }
   public void display()
   {
      Node n=head;
	  Node p=null;
	  System.out.println("Forward Direction");
	  if(n==null)
	  {
	      System.out.println("List is Empty.");
	      return;
	  }
	  while(n!=null)
	  {
	      System.out.print(n.data+"-->");
		  p=n;
		  n=n.next;
	  }
	  System.out.println();
	  System.out.println("Backward Direction");
	  if(p==null)
	  {
		  System.out.println("List is Empty");
		  return;
	  }
	  while(p!=null)
	  {
		  System.out.print(p.data+"-->");
		  p=p.prev;
	  }
   }
   
   public void insert(int new_data)
   {
	   Node new_node=new Node(new_data);
	   new_node.next=head;
	   new_node.prev=null;
	   
	   if(head!=null)
		   head.prev=new_node;
	   
	   head=new_node;
   }
   
   public void insertLast(int new_data)
   {
	   Node new_node= new Node(new_data);
	   Node n=head;
	  
	   if(head==null)
	   {
		   new_node.next=null;
		   new_node.prev=null;
		   head=new_node;
		   return;
	   }
	   while(n.next!=null)
		   n=n.next;
	   
	   
	   n.next=new_node;
	   new_node.prev=n;
   }
   
   public void insertBetween(Node n,int new_data)
   {
	   n=head;
	   int a=22;
	   Node new_node= new Node(new_data);
	   
	   if(head==null)
		   return;
	   
	   while(n.data != a)
	   {
		   n=n.next;
	   }
	   new_node.next=n.next;
	   n.next=new_node;
	   new_node.prev=n;
	   if(new_node.next!=null)
		   new_node.next.prev=new_node;
   }
   
   /*void append(int new_data)
     {
    Node new_node= new Node(new_data);
	Node n= head;
	//Node prev=null;
	

	if(head==null)
	{
	   new_node.next=null;
	   new_node.prev=null;
	   head=new_node;
	   return;
	}
	
	while(n.next!=null)
	   n=n.next;
	   
	   n.next=new_node;
	   new_node.prev=n;
      }*/
	  
	  public void delete(int key)
	  {
		  Node n= head;
		  Node p=null;
		  
		  if(n!=null && n.data==key)
		  {
			  n=n.next;
			  return;
		  }
		   while(n!=null && n.data!=key)
			 {
			   p= n;
			   n=n.next;
			 }
		 if(n==null)
		  return;
		  p.next= n.next;
		  n.next.prev=p;
			  
	  }
   
   public static void main(String args[])
   {
     Dll1 d1= new Dll1();
	 d1.head=new Node(11);
	 Node Second = new Node(22);
	 Node Third= new Node(33);
	 
	 
	 d1.head.prev=null;
	 d1.head.next=Second;
	 Second.prev=d1.head;
	 Second.next= Third;
	 Third.prev=Second;
	 Third.next= null;
	 
	 //d1.insert(1000);
	 d1.insert(50);
	 d1.insertLast(99);
	 d1.insertBetween(d1.head,90);
	 d1.delete(90);
	 
	 d1.display();
   }

}