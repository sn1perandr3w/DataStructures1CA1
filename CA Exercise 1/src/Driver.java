//Name: Andrew Bates
//Student Number: 20075908


public class Driver {

	static Boolean running = true;
	
	public static void main(String[] args) {
		
	Driver driver = new Driver();	
	IO.putLine("Welcome to the CA1 accommodation system.");
	IO.putLine("Andrew Bates // 20075908");
	
	while(driver.running == true)
    {
    	runDriverMenu();
    }
	
	}
	
	////////////////////////////////////////////////////////
	//Controller for main menu. Not all methods complete due to time constraints.
	////////////////////////////////////////////////////////
    private static void runDriverMenu()
    {
        int option = 0;
        boolean valid = false;
        ////////////////////////////////////////////////////////
        //Validation to ensure option is within bounds.
        ////////////////////////////////////////////////////////
        while (!valid)
        {
           option = driverMenu();
           if(option > -1 && option <= 8){
        	   IO.putLine("Option no." + option + " decided");
        	   valid = true;
           }
           else{
        	   IO.putLine("Invalid option entered: " + option);     
           }
           IO.prompt("Press any key to continue...");
        }
        if(option == 1)
        {
        	Property.addPropertiesLL();
        }
        if(option == 2)
        {
        	Student.addStudentsLL();
        }
        if(option == 3)
        {
        //	Student.removeStudentLL();
        	IO.putLine("A method which is unfortunately unfinished.");
        }
        if(option == 4)
        {
        	Property.listPropertiesLL();
        }
        if(option == 5)
        {
        	Property.listBedsLL();
        }
        if(option == 6)
        {
        	Property.listFreeBedsLL();
        }
        if(option == 7)
        {
        	//Property.listFreeBedsByCriteriaLL();
        	IO.putLine("A method which is unfortunately unfinished.");
        }
        if(option == 8)
        {
        	Student.listStudentsLL();
        }
        if(option == 0)
        {
        	running = false;
        }
    }
    ////////////////////////////////////////////////////////
    //Used to both display menu options as well as return option int for manipulation of main menu.
    ////////////////////////////////////////////////////////
	public static int driverMenu()
	{
		 IO.putLine("1) Add Property");
		 IO.putLine("2) Add Student");
		 IO.putLine("3) Remove Student");
		 IO.putLine("4) List Properties (And also edit their contents");
		 IO.putLine("5) List ALL Beds");
		 IO.putLine("6) List Free Beds");
		 IO.putLine("7) List Free Beds by criteria (NOT WORKING)");
		 IO.putLine("8) List Students");
		 IO.putLine("0) Exit System");
		 int option=IO.getInt("Please select an option.");
	     return option;
	}

}
