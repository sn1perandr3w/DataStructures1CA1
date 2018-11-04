
public class Room {
	public static int uidCounter = 0;
	private int uid;
	private int propertyID;
	private  String roomType;
	private  int floor;
	private  boolean enSuite;
	
	
	Room(String roomType, int floor, int enSuite, int propertyID)
	{
		
		this.roomType = roomType;
		this.floor = floor;
		////////////////////////////////////////////////////////
		//Transfers int input to boolean input.
		////////////////////////////////////////////////////////
		if(enSuite == 1){
		this.enSuite = true;
		}
		else
		{
			this.enSuite = false;
		}
		this.propertyID = propertyID;
		this.uid = uidCounter;
		uidCounter = uidCounter+1;
	}

	
	//Gets room type
	public String getRoomType(){
		return roomType;
	}
	//Gets room UID
	public int getRoomId()
	{
		return uid;
	}
	//Gets boolean as to whether room is enSuite or not.
	public boolean getEnSuite() {
		return enSuite;
	}
	//Gets floor of room.
	public int getFloor() {
		return floor;
	}
	//Gets property ID that room belongs to.
	public int getPropertyId() {
		return propertyID;
	}
	
	
}
