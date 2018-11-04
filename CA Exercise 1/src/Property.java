import java.util.ArrayList;

public class Property {

	private String propertyType;
	public static int uidCounter = 0;
	private int uid;
	private String address;
	private double distanceToWIT;
	private int parkingSpaces;
	
	////////////////////////////////////////////////////////
	//Creates a node, sending the property object back to the Node class as data.
	////////////////////////////////////////////////////////
	public static void addPropertiesLL()
	{
			Property property = new Property(IO.getLine("Enter Property Type"), IO.getLine("Enter Address"), IO.getDouble("Enter Distance From WIT Campus (In KM)"), IO.getInt("Enter amount of parking spaces at property"));
			Node.addNode(property);
	}
	
	////////////////////////////////////////////////////////
	//The method in charge of most of the property manipulation.
	//Creates node in local class, using methods to iterate through them.
	//Draws data from said nodes and uses ID's to match with objects in the node.
	////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////
	//Gets somewhat messy due to new node objects being got to iterate through the nodes as a whole.
	//Somewhat haphazardly put together due to project originally being built on ArrayLists then converted to
	//utilize custom ADT's.
	////////////////////////////////////////////////////////
	public static void listPropertiesLL()
	{
		////////////////////////////////////////////////////////
		//Used to keep menu going.
		////////////////////////////////////////////////////////
		int option = -1;
		while(option != 0){
			//Starts node at head.
		Node node = Node.getHead();
		//Used to find an end to the nodes.
		while(node != null){
			//Used to get ONLY properties which have the type of '1' in the Node class.
			if(node.getContents(1) != null){
		Property property = (Property) node.getContents(1);
		IO.putLine("/////////////////////////////////////");
		IO.putLine("Property ID :" + property.getId());
		IO.putLine("Address : " + property.getAddress());
		IO.putLine("Property type: " + property.getPropertyType());
		IO.putLine("Parking Spaces: " + property.getParkingSpaces());
		IO.putLine("/////////////////////////////////////");
			}
			//Iterates to next node..
			node = Node.getNext(node); 
		}


			boolean valid = false;
	        while (!valid)
	        {
				IO.putLine("1) Add rooms to property.");
				IO.putLine("2) Inspect rooms in property.");
				IO.putLine("0) Exit Menu.");
				IO.putLine("------------------------------------");
				
	           option = IO.getInt("Enter an option");
	           if(option > -1 && option <= 2){
	        	   IO.putLine("Option no." + option + " decided");
	        	   valid = true;
	           }
	           else{
	        	   IO.putLine("Invalid option entered: " + option);     
	           }

	        }
			
		
        if(option == 1)
        {
        	//Starts node at head.
        	Node node2;
        	node2 = Node.getHead();
        	Property property2 = (Property) node2.getContents(1);
        	//User selects property to add room to.
        	int propertyGet = IO.getInt("Enter ID of property.");
        	//Used to get ONLY properties which have the type of '1' in the Node class.
        	while(node2.getContents(1) != null){
        	property2 = (Property) node2.getContents(1);
        	//Validation to ensure room is added to correct property.
        	if(propertyGet == property2.getId())
        	{
        		//Creates room and sends it to Node to be added. 
        		IO.putLine("Adding Room.");
        		Room room = new Room(IO.getLine("Enter Room Type"), IO.getInt("Enter Floor number"), IO.getInt("Room Ensuite? 1 = True, 0 = False"), propertyGet);;
        		Node.addNode(room);
        	}
        	//Iterates to next node.
        	node2 = Node.getNext(node2);
        	}
        }
        
		
        if(option == 2)
        {
        	//User selects property to inspect room of.
        	int propertyGet = IO.getInt("Enter ID of property.");
        	IO.putLine("Inspecting Rooms");
        	Node node3;
        	//Starts node at head.
        	node3 = Node.getHead();
        	Property property2;
        	Room room2;
        	//Used to find an end to the nodes.
        	while(node3 != null){
        	//Used to get ONLY properties which have the type of '1' in the Node class.
        	if(node3.getContents(1) != null){
        	property2 = (Property) node3.getContents(1);
        	Node node4 = Node.getHead();
        	//Used to find an end to the nodes.
        	while(node4 != null){
        	//Used to get ONLY rooms, which have the type of '2' in the Node class.
        	if(node4.getContents(2) != null){
        	room2 = (Room) node4.getContents(2);
        	////////////////////////////////////////////////////////
        	//Validation to ensure rooms belong to said property.
        	////////////////////////////////////////////////////////
    		if(propertyGet == room2.getPropertyId()){
        		IO.putLine("/////////////////////////////////////");
        		IO.putLine("Property ID: " + room2.getPropertyId());
        		IO.putLine("Room ID: " + room2.getRoomId());
        		IO.putLine("Room Type: " + room2.getRoomType());
        		IO.putLine("Floor: " + room2.getFloor());
        		IO.putLine("Ensuite: " + room2.getEnSuite());
        		IO.putLine("/////////////////////////////////////");
        		} 
        }
        	//Iterates to next node.
        	node4 = Node.getNext(node4);
        	}
        	}
        	//Iterates to next node.
        	node3 = Node.getNext(node3);
	}

			int option2 = -1;
			
			boolean valid2 = false;
	        while (!valid2)
	        {
	        	IO.putLine("1) Add beds to room.");
				IO.putLine("2) Inspect beds in room.");
				IO.putLine("0) Exit Menu.");
				IO.putLine("------------------------------------");
				
	           option2 = IO.getInt("Enter an option");
	           if(option2 > -1 && option2 <= 2){
	        	   IO.putLine("Option no." + option2 + " decided");
	        	   valid2 = true;
	           }
	           else{
	        	   IO.putLine("Invalid option entered: " + option2);     
	           }

	        }
			
			
			if(option2 == 1)
			{
				int roomGet = IO.getInt("Enter ID of room.");
				Node node5;
				//Starts node at head
				node5 = Node.getHead();
				Room room3;
				//Used to find an end to the nodes.
	        	while(node5 != null){
	        	//Used to get ONLY rooms, which have the type of '2' in the Node class.
	        	if(node5.getContents(2) != null)
	        	{
	        		room3 = (Room) node5.getContents(2);
	        		if(roomGet == room3.getRoomId())
	        		{	
	        			////////////////////////////////////////////////////////
	        			//Creates bed and sends it to Node to be added.
	        			////////////////////////////////////////////////////////
	        			Bed bed = new Bed(IO.getLine("Enter Bed Type"), IO.getInt("Enter Cost per week"), roomGet);
	        			Node.addNode(bed);
	        		}
	        		}
	        	//Iterates to next node.
	        	node5 = Node.getNext(node5);
	        	}
			}
			if(option2 == 2)
			{
				////////////////////////////////////////////////////////
				//Used to select a room to put a bed in.
				////////////////////////////////////////////////////////
	        	int bedGet = IO.getInt("Enter ID of Room to search for beds in.");
	        	IO.putLine("Inspecting Beds");
	        	Node node6;
	        	//Starts node at head
	        	node6 = Node.getHead();
	        	Property property3;
	        	Room room3;
	        	Bed bed;
	        	//Used to find an end to the nodes.
	        	while(node6 != null){
	        	//Used to get ONLY properties which have the type of '1' in the Node class.
	        	if(node6.getContents(1) != null){
	        	property3 = (Property) node6.getContents(1);
	        	Node node7;
	        	//Starts node at head
	        	node7 = Node.getHead();
	        	//Used to find an end to the nodes.
	        	while(node7 != null){
	        	//Used to get ONLY rooms which have the type of '2' in the Node class.
	        	if(node7.getContents(2) != null){
	        	room3 = (Room) node7.getContents(2);
	        	Node node8; 
	        	//Starts node at head
	        	node8 = Node.getHead();
	        	//Used to find an end to the nodes.
	        	while(node8 != null){
	        	////////////////////////////////////////////////////////
	        	//Used to get ONLY beds which have the type of '3' in the Node class.
	        	//Also holds validation to ensure that the selected room corresponds to a room TO put a bed in.
	        	////////////////////////////////////////////////////////
	        	if(node8.getContents(3) != null && bedGet == room3.getRoomId()){
	        	bed = (Bed) node8.getContents(3);
	    		if(room3.getRoomId() == bed.getRoomID()){
	        		IO.putLine("/////////////////////////////////////");
	        		IO.putLine("Room ID: " + bed.getRoomID());
	        		IO.putLine("Bed ID: " + bed.getBedID());
	        		IO.putLine("Bed Type: " + bed.getBedType());
    				IO.putLine("Cost: " + bed.getCost());
    				IO.putLine("Booked : " + bed.getBooked());
    				////////////////////////////////////////////////////////
    				//Only shows student who booked bed IF bed is actually booked.
    				////////////////////////////////////////////////////////
    				if(bed.getBooked() != false)
    				{
    					IO.putLine("Booked by: " + bed.getStudentName());
    				}
	        		IO.putLine("/////////////////////////////////////");
	        	}
	        	}
	        	//Iterates to next node.
	    		node8 = Node.getNext(node8);
	        	}
	        	}
	        	//Iterates to next node.
	        	node7 = Node.getNext(node7);
	        	}
	        	}
	        	//Iterates to next node.
	        	node6 = Node.getNext(node6);
	        	}
	        	
	        	
				
				
				int option3 = -1;
				
				boolean valid3 = false;
		        while (!valid3)
		        {
		        	IO.putLine("1) Assign Student to bed.");
					IO.putLine("0) Exit Menu.");
					IO.putLine("------------------------------------");
					
		           option3 = IO.getInt("Enter an option");
		           if(option3 > -1 && option3 <= 2){
		        	   IO.putLine("Option no." + option3 + " decided");
		        	   valid3 = true;
		           }
		           else{
		        	   IO.putLine("Invalid option entered: " + option3);     
		           }

		        }
				
				
				
				if(option3 == 1)
				{
					
					int bedGet2 = IO.getInt("Enter ID of Bed you wish to assign student to.");
					////////////////////////////////////////////////////////
					//Lists students.
					////////////////////////////////////////////////////////
					Student.listStudentsLL();
					int studentGet = IO.getInt("Enter ID of student you wish to assign to bed.");
					
		        	Node node9;
		        	Node node12;
		        	//Starts node at head
		        	node9 = Node.getHead();
		        	//Starts node at head
		        	node12 = Node.getHead();
		        	Property property4;
		        	Room room4;
		        	Bed bed2;
		        	Student student;
		        	int studentID = 0;
		        	String studentName = null;
		        	//Used to find an end to the nodes.
		        	while(node12 != null)
		        	{
		        		//Used to get ONLY students which have the type of '4' in the Node class.
		        		if(node12.getContents(4) != null)
		        		{
		        			student = (Student) node12.getContents(4);
		        			if(studentGet == student.getStudentID()){
		        			IO.putLine("Student: " + student.getStudentID() + "Found!" );
		        			studentID = student.getStudentID();
		        			studentName = student.getStudentName();
		        		}
		        		}
		        		//Iterates to next node.
		        		node12 = Node.getNext(node12);
		        	}
		        		//Used to find an end to the nodes.
		        		while(node9 != null){
			        	if(node9.getContents(1) != null){
			        	//Used to get ONLY properties which have the type of '1' in the Node class.
			        	property4 = (Property) node9.getContents(1);
			        	Node node10;
			        	node10 = Node.getHead();
			        	//Used to find an end to the nodes.
			        	while(node10 != null){
			        	if(node10.getContents(2) != null){
			        	//Used to get ONLY rooms which have the type of '2' in the Node class.
			        	room4 = (Room) node10.getContents(2);
			        	Node node11; 
			        	node11 = Node.getHead();
			        	//Used to find an end to the nodes.
			        	while(node11 != null){
			        	//Used to get ONLY beds which have the type of '3' in the Node class.
			        	if(node11.getContents(3) != null){
			        	bed2 = (Bed) node11.getContents(3);
			        	if(bedGet == bed2.getBedID())
			        			{
			        		    ////////////////////////////////////////////////////////
			        			//Sets data inside of the bed object in the current class.
			        		    ////////////////////////////////////////////////////////
			        			bed2.setStudent(studentID, studentName);
			        			////////////////////////////////////////////////////////
			        			//Passes node AND object back to the Node class, overwriting the old node with the
			        			//updated node. Used for changing data rather than mere addition/removal.
			        			////////////////////////////////////////////////////////
			        			Node.insertNode(node11, bed2);
			        			}
				}
			        	//Iterates to next node.
			        	node11 = Node.getNext(node11);
	        	}
			  	}
			        	//Iterates to next node.
			        	node10 = Node.getNext(node10);
			        	}
			        	}
			        	//Iterates to next node.
			        	node9 = Node.getNext(node9);
			        	}
		        	}
				}
			}
        }
		}
		

	public static void listBedsLL() 
	{
    	IO.putLine("Inspecting Beds");
    	Node node;
    	node = Node.getHead();
    	Property property;
    	Room room;
    	Bed bed;
    	//Used to find an end to the nodes.
    	while(node != null){
    	//Used to get ONLY properties which have the type of '1' in the Node class.
    	if(node.getContents(1) != null){
    	IO.putLine("Past node");
    	property = (Property) node.getContents(1);
    	Node node2;
    	node2 = Node.getHead();
    	//Used to find an end to the nodes.
    	while(node2 != null){
    	//Used to get ONLY rooms which have the type of '2' in the Node class.
    	if(node2.getContents(2) != null){
    	room = (Room) node2.getContents(2);
    	IO.putLine("Past node2");
    	Node node3; 
    	node3 = Node.getHead();
    	//Used to find an end to the nodes.
    	while(node3 != null){
    	//Used to get ONLY beds which have the type of '3' in the Node class.
    	if(node3.getContents(3) != null){
    		bed = (Bed) node3.getContents(3);
    		IO.putLine("Past node3");
    		IO.putLine("/////////////////////////////////////");
    		IO.putLine("Bed ID: " + bed.getBedID());
    		IO.putLine("Address: " + property.getAddress());
    		IO.putLine("Bed Type: " + bed.getBedType());
    		IO.putLine("Floor: " + room.getFloor());
    		IO.putLine("En-suite: " + room.getEnSuite());
			IO.putLine("Cost: " + bed.getCost() + " per week.");
			IO.putLine("Booked : " + bed.getBooked());
			////////////////////////////////////////////////////////
			//Only shows student who booked bed IF bed is actually booked.
			////////////////////////////////////////////////////////
			if(bed.getBooked() != false)
			{
				IO.putLine("Booked by: " + bed.getStudentName());
			}
    		IO.putLine("/////////////////////////////////////");
    		
    	}
    	//Iterates to next node.
    	node3 = Node.getNext(node3);
    	}
    		
    	}
    	//Iterates to next node.
    	node2 = Node.getNext(node2);
    	}
    	
    	}
    	//Iterates to next node.
    	node = Node.getNext(node);
    	}
    	
    }
	
	////////////////////////////////////////////////////////
	//Same as listBedsLL except validation is in place to prevent occupied beds being listed.
	////////////////////////////////////////////////////////
	public static void listFreeBedsLL() 
	{
    	
    	Node node;
    	node = Node.getHead();
    	Property property;
    	Room room;
    	Bed bed;
    	
    	while(node != null){
    	if(node.getContents(1) != null){
    	IO.putLine("Searching for Properties");
    	property = (Property) node.getContents(1);
    	Node node2;
    	node2 = Node.getHead();
    	while(node2 != null){
    	if(node2.getContents(2) != null){
    	room = (Room) node2.getContents(2);
    	IO.putLine("Searching for rooms with free beds");
    	Node node3; 
    	node3 = Node.getHead();
    	while(node3 != null){
    	if(node3.getContents(3) != null){
    		bed = (Bed) node3.getContents(3);
    		////////////////////////////////////////////////////////
    		//Validation to prevent booked beds from being displayed.
    		////////////////////////////////////////////////////////
    		if(bed.getBooked() == false){
    		IO.putLine("/////////////////////////////////////");
    		IO.putLine("Bed ID: " + bed.getBedID());
    		IO.putLine("Address: " + property.getAddress());
    		IO.putLine("Bed Type: " + bed.getBedType());
    		IO.putLine("Floor: " + room.getFloor());
    		IO.putLine("En-suite: " + room.getEnSuite());
			IO.putLine("Cost: " + bed.getCost() + " per week.");
			IO.putLine("Booked : " + bed.getBooked());
    		IO.putLine("/////////////////////////////////////");
    		}
    	}
    	node3 = Node.getNext(node3);
    	}
    		
    	}
    	node2 = Node.getNext(node2);
    	}
    	
    	}
    	node = Node.getNext(node);
    	}
    	
    }
	
	Property(String propertyType, String address, double distanceToWIT, int parkingSpaces)
	{
		this.propertyType = propertyType;
		this.address = address;
		this.distanceToWIT = distanceToWIT;
		this.parkingSpaces = parkingSpaces;
		this.uid = uidCounter;
		uidCounter = uidCounter+1;
	}
	
	
	
	//Gets property type
	public String getPropertyType(){
		return propertyType;
	}
	
	//Gets uid for property
	public int getId(){
		return uid;
	}
	
	
	//Gets parking spaces
	public int getParkingSpaces(){
		return parkingSpaces;
	}
	
	
	//Gets address
	public String getAddress(){
		return address;
	}
	
	//Gets distance to WIT
	public double getDistanceToWIT(){
		return distanceToWIT;
	}


	
	
	
}
