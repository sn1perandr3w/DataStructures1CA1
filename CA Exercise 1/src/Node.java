
public class Node {

	private Node next = null;
	private static Node head;
	private Object contents;
	private int objectType = 0;

	//Adds node, each node knowing which one comes after it.
	//All methods regarding iteration of nodes start with the head.
	//If the head is null, it will create the first node there.
	
	public static void addNode(Object data){
		
		if(head == null)
		{
			head = new Node();
			head.setObjectType(data);
			head.setContents(data);
		}
		else
		{
		IO.putLine("Adding Object!");
		Node nn = new Node();
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		if(temp.next == null)
		{
			temp.next = nn;
			nn.setObjectType(data);
			nn.setContents(data);

		}
		}
	}
	
	//By passing a node as well as its data into this method, the new node nn will replace said node if
	//temmp.next happens to be that node. With a validation for if the head is null, it is effective for
	//updating data within nodes.
	
	public static void insertNode(Node removal, Object data)
	{
		if(head == null)
		{
			head = new Node();
			head.setObjectType(data);
			head.setContents(data);
		}
		else
		{
			IO.putLine("Updating Node!");
			Node nn = new Node();
			Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		if(temp.next == removal)
		{
			temp.next = nn;
			nn.setObjectType(data);
			nn.setContents(data);

		}
		}
	}
	
	
	//Returns head.
	
	public static Node getHead()
	{
		return head;
	}
	
	//Returns next node from node passed into it.
	
	public static Node getNext(Node node)
	{
		Node temp = node;
		temp = temp.next;
		return temp;
	}
	
	//Sets an int which is associated with each of the object types.
	//This is used so that when a Node is passed into Property, the 
	//method which is expecting this object does not say, expect a room when a bed is being sent back.
	//Effectively stops a square peg being jammed into a circle hole, for lack of a better analogy.
	
	public void setObjectType(Object data)
	{
		if(data instanceof Property)
		{
			IO.putLine("Property Set");
			this.objectType = 1;
		}
		if(data instanceof Room)
		{
			IO.putLine("Room Set");
			this.objectType = 2;
		}
		if(data instanceof Bed)
		{
			IO.putLine("Bed Set");
			this.objectType = 3;
		}
		if(data instanceof Student)
		{
			IO.putLine("Student Set");
			this.objectType = 4;
		}
	}
	
	
	//Gets data from node. The type corresponds to the int which was assigned in setObjectType.
	
	public Object getContents(int type)
	{
		if(type == objectType){
		return contents;
		}
		return null;
	}
	
	//This sets the actual contents of the node, objects in this case.
	
	public void setContents(Object data)
	{
		this.contents = data;
	}

}
