
public class Student {
	private String name;
	private boolean car;
	private static int uidCounter = -1;
	private  int uid;
	private int gender;
	
	
	Student(String name, int car, int gender)
	{
		this.name = name;
		this.gender = gender;
		this.uid = uidCounter+1;
		uidCounter = uidCounter+1;
		
		if(car == 1){
		this.car = true;
		}
		else
		{
			this.car = false;
		}
	}
	
	////////////////////////////////////////////////////////
	//Creates a node, sending the student object back to the Node class as data.
	////////////////////////////////////////////////////////
	
	public static void addStudentsLL()
	{
			Student student = new Student(IO.getLine("Enter Name of student"), IO.getInt("Does student have a car? (1 = yes / 2 = no)"),IO.getInt("Enter student gender (1 = male / 2 = female)"));
			Node.addNode(student);
	}
	
	////////////////////////////////////////////////////////
	//Creates node in local class, using methods to iterate through them.
	//Used purely for displaying data gotten from node, in this case, Students.
	////////////////////////////////////////////////////////
	
	public static void listStudentsLL()
	{
			Node node = Node.getHead();
			while(node != null){
				if(node.getContents(4) != null){
			Student student = (Student) node.getContents(4);
			IO.putLine("/////////////////////////////////////");
			IO.putLine("Student ID :" + student.getStudentID());
			IO.putLine("Student Name:" + student.getStudentName());
			IO.putLine("Has Car : " + student.getStudentCar());
			IO.putLine("/////////////////////////////////////");
				}
				node = Node.getNext(node);
			}
		}
	

	//Gets student name.
	
	public String getStudentName(){
		return name;
	}
	
	
	//Gets boolean as to whether student has car.
	public boolean getStudentCar(){
		return car;
	}
	
	
	//Gets student UID.
	public int getStudentID(){
		return uid;
	}
	
}

