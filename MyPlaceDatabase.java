
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdconsoleıo;

/**
 *
 * @author Gül
 */
public class MyPlaceDatabase implements PlaceDB {
private Place []place;// create place array
private int numberOfPlace;
private int size=10;// array size

    /**
     *
     * @param size
     */
//constructor
    public MyPlaceDatabase( int size) {
       
       this.size=size;
        place = new Place[size];
        
        this.numberOfPlace=0;
    }

    /**
     *
     * @param zipcode
     * @return
     */
    //   Search the database for the given zipcode and returns the associated place
    // if place [i]'s zipcode nor equal zipcode return null
    @Override
    public Place lookupByZipcode(String zipcode) {
        for(int i=0; i<numberOfPlace;i++){// for döngüsü kullanıyoruz çünkü bu da bir find search methodu ilk önce dizeyi kontrol ediyoruz
            if(place[i].getZipcode().equals(zipcode)){// aradiğımız target ile eşleşme olunca satırı
     //bunun için==>  if(array[for'un i'si].getAraranşey.equals( parametre);
                return  place[i];
            }
            
        }
        return null;
           }
    
    /**
     *
     * @param p
     */
    @Override
    //add a new place to the database
    //if the given zipcode exist in the database print message and dont insert the new place
    public void addPlace(Place p) {
       if (lookupByZipcode(  p.getZipcode()) != null) {// şimdi database veri yükleyeceğiz  yapamamız greken şey şu
           // lookupByZipcode( p.getZipcode())!=null ise sistemde  varmıştı yükleme yapma
            System.out.println("Zipcode already exists in the database.");
            return;
        }

        if (numberOfPlace < size) {
            place[numberOfPlace] =   p;// Array[güncelindex]= p objesi;
            numberOfPlace++;
                    
            System.out.println("Place added successfully.");
        } else {
            System.out.println("Database is full. Cannot add new place.");
        }
    
     
      
      
            
        
    }
  
    /**
     *
     * @param prefix
     */
    //list all places whose zipcode start with the given with prefix
    @Override
    public void listAllPlaces(String prefix) {
        for( int i=0; i<numberOfPlace;i++){// search on the place array
            if(place[i].getZipcode().startsWith(prefix)){// if find prefix on the list
                System.out.println(place[i]);// print 
            }
        }
         }

    /**
     *
     * @param zip1
     * @param zip2
     * @return
     */
    //Return the distance between zipcode1 and zipcode2. 
// calculated distance between zip1 and zip2
// If any of the zipcodes do not have location information your 
//method should return -1. 
    @Override
    
    public double distance(String zip1, String zip2) {
        // Take  the Place objects associated with the given zipcodes
    Place place1 = lookupByZipcode(zip1);
       Place place2 = lookupByZipcode(zip2);
       // Make sure the places are of type LocatedPlace before casting
    if( place1 instanceof LocatedPlace &&place2 instanceof LocatedPlace){
         // Cast the places to LocatedPlace type
          LocatedPlace locatedPlace2=( LocatedPlace)place2;
        LocatedPlace locatedPlace1=( LocatedPlace)place1; 
    

      
         
        // calculate distance
             double distance = Math.sqrt(Math.pow(locatedPlace1.getLatitude()- locatedPlace2.getLatitude(), 2) + Math.pow(locatedPlace1.getLongitude() - locatedPlace2.getLongitude(), 2));
     
             return distance;
        }
    else {
        System.out.println(" Error: ");
        
    } return -1;}
        
       
          
   
    
    }
    
    


