
public class Bed {
	private int roomId;
	private  String bedType;
	private  int cost;
	private static int uidCounter = -1;
	private  int uid;
	private int studentID;
	private String studentName;
	private boolean booked = false;

	
	
	Bed(String bedType, int cost, int roomId)
	{
		this.bedType = bedType;
		this.cost = cost;
		this.uid = uidCounter+1;
		uidCounter = uidCounter+1;
		this.roomId = roomId;
	}
	

	
	
	//Gets bed type
	public String getBedType(){
		return bedType;
	}
	////////////////////////////////////////////////////////
	//Sets student information to assign them to the bed. Also marks the bed as booked.
	////////////////////////////////////////////////////////
	public void setStudent(int studentID, String studentName){
		this.studentID = studentID;
		this.studentName = studentName;
		booked = true;
		
	}
	////////////////////////////////////////////////////////
	//Removes student info from bed, marking it as unbooked.
	////////////////////////////////////////////////////////
	public void removeStudent(){
		this.studentID = -1;
		this.studentName = null;
		booked = false;
		
	}
	//Gets student ID
	public int getStudentID(){
		return studentID;
	}
	//Gets student name
	public String getStudentName(){
		return studentName;
	}
	//Gets cost for bed
	public int getCost() {
		return cost;
	}
	//Gets boolean as to whether bed is booked or not
	public boolean getBooked() {
		return booked;
	}
	//Gets bed UID
	public int getBedID()
	{
		return uid;
	}
	//Gets ID of room that bed belongs to.
	public int getRoomID()
	{
		return roomId;
	}
	
	
	
}