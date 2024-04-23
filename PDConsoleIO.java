/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdconsoleıo;

import java.util.Scanner;

/**
 *
 * @author Gül
 */
public class PDConsoleIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     PDConsoleIO ui = new PDConsoleIO();
	  PlaceDB pd = new MyPlaceDatabase(10);
      
       MyPlaceDatabase db= new MyPlaceDatabase (10);
        Place p= new Place("00000","xxxx","xxx");
         
         ui.processCommands(pd);
           db.addPlace(p);
      
          
	  
         
    }
     /** A reference to the PlaceDB object to be processed.
      Globally available to the command-processing methods.
   */
  private PlaceDB theDatabase = null;

  /** Scanner to read from input console. */
  private Scanner scIn = null;

  // Constructor
  /** Default constructor. */
  public PDConsoleIO() {
    scIn = new Scanner(System.in);
  }

  // Methods
  /** Method to display the command choices and process user
      commands.
      @param thePlaceDatabase A reference to the PlaceDB
             to be processed
   */
  public void processCommands(PlaceDB thePlaceDatabase) {
    String[] commands = {
        "Add Place",
        "Look Up by Zipcode",
	"List All Places by Zipcode Prefix",
	"Distance Between Zipcodes",
        "Exit"};

    theDatabase = thePlaceDatabase;
    int choice;
    do {
      for (int i = 0; i < commands.length; i++) {
        System.out.println("Select " + i + ": "
                           + commands[i]);
      }
      
        choice = scIn.nextInt(); // Read the next choice.
        scIn.nextLine(); // Skip trailing newline.
        switch (choice) {
          case 0:
            doAddPlace();
            break;
          case 1:
            doLookupByZipcode();
            break;
	  case 2:
	    doListAllPlaces();
            break;
	  case 3:
	    doDistance();
          case 4:
            break;  
          default:
            System.out.println("*** Invalid choice "
                               + choice
                               + " - try again!");
        }
     
    }
    while (choice != commands.length - 1);
    System.exit(0);
  }

  /** Method to add a place.
      pre:  The database exists. 
      post: A new place is added.
   */
  private void doAddPlace() {
      System.out.println(" Enter a zipcode");
         String Zipcode=scIn.nextLine();// take a zipcode
         System.out.println(" Enter the town name");
         String townName=scIn.nextLine();// // take a townname
         System.out.println(" Enter the state abrv.");
         String State=scIn.nextLine();//take a state name

         System.out.println(" enter the latitude");
        String latitudeNone= scIn.nextLine();
        double latitude= 0.0;
      if( latitudeNone.equals("none")){
          System.out.println(latitude);// if latiude is equal none return 0.0
      }
      else if(!latitudeNone.equals("none") ){
      latitude = Double.parseDouble(latitudeNone);    // if latitude is not  equal 'none' so turn string to double   
      }
      else{
          System.exit(-1);
      }
      System.out.println(" Enter the longitude:");
String longitudeNone=scIn.nextLine();//if longtiude is equal none return 0.0
double longitude=0.0;
if(longitudeNone.equals("none")){
    System.out.println(longitude);
}
else if(!longitudeNone.equals("none")){
    longitude=Double.parseDouble(longitudeNone);
}
else{
    System.exit(-1);
}
      System.out.println(" Enter the population");
String  populationNone=scIn.nextLine();// take a population for the town
int population=-1;
if(populationNone.equals("none")){
    System.out.println(population);// if population is equal none print -1
    
}
else if(!populationNone.equals("none")){
    population=Integer.parseInt(populationNone);
    
}
else 
    System.exit(-1);


// if we have population information an have not latiude information return error
if( !populationNone.equals("none")&&(latitudeNone.equals("none")||longitudeNone.equals("none")))
          System.out.println(" Error  there are no latitude and longitude informations");
// if the database has a only place information
if(latitudeNone.equals("none")||longitudeNone.equals("none")){
     Place p=new Place(Zipcode,townName,State);
     theDatabase.addPlace(p);
         System.out.println(" Place: "+p);    // print p object 
 }
// if the database has a Located place information but does not have population info 
 if( populationNone.equals("none")&&(!latitudeNone.equals("none")||!longitudeNone.equals("none"))){
     LocatedPlace lp= new LocatedPlace(latitude,longitude,Zipcode,townName,State); 
     theDatabase.addPlace(lp);
     System.out.println("Located Place: "+lp);    // print LocatedPlace tostring
 }
 // if the database has everything 
 if(!latitudeNone.equals("none")&&(!longitudeNone.equals("none")&&!populationNone.equals("none")) ){
     PopulatedPlace pp=new PopulatedPlace(population,latitude,longitude,Zipcode,townName,State);
     theDatabase.addPlace(pp);
    
         System.out.println(" COMPLETE ! " + "\n"+pp);// print PopulatedPlace's toString
        
        
 }



         


  }

  /** Method to lookup a place by zipcode.
      pre:  The database exists.
      post: No changes made to the database.
   */
  private void doLookupByZipcode() {
    // Request the zipcode.
    System.out.println("Enter zipcode");
    String theZip = scIn.nextLine();
    if (theZip.equals("")) {
       
      return; // Dialog was cancelled.
    }
    // Look up the zipcode.
    Place p = theDatabase.lookupByZipcode(theZip);
    if (p != null) { // Zipcode was found.
    	System.out.println(p.toString());
    }
    else { // not found.
      // Display the result.
      System.out.println("No such zipcode");

    }
  }

  /** Method to list all places whose zipcodes start with entered prefix.
      pre:  The database exists.
      post: No changes made to the database.
   */
  private void doListAllPlaces() {
    System.out.println("Enter zipcode prefix");
    String prefix = scIn.nextLine();
    if (prefix.equals("")) {
          return; // Dialog was cancelled.
    }
   
    theDatabase.listAllPlaces(prefix);
    
  }

   /** Method to compute the distance between two zipcodes.
      pre:  The database exists.
      post: No changes made to the database.
   */
  private void doDistance() {
    System.out.println("Enter two zipcodes");
    String zip1 =scIn.nextLine();
    String zip2=scIn.nextLine();
    if( zip1.equals(" ")&&zip2.equals(" ")){
        return;
    }
    double distance= theDatabase.distance(zip1, zip2);
      System.out.println(" distance between "+ zip1 +" "+ zip2+ "and distance is: " + distance);
      if( distance==-1)
          System.out.println(" there is no longitude or latitude");
  
    
  }
}
