/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdconsoleıo;

/**
 *
 * @author Gül
 */
public class LocatedPlace extends Place {
    private double latitude;//latidute information 
    private double longitude;

    /**
     *
     * @param latitude
     * @param longitude
     * @param zipcode
     * @param town
     * @param state
     */
    //constructor
    public LocatedPlace(double latitude, double longitude, String zipcode, String town, String state) {
        super(zipcode, town, state);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */
    // getter and setter methods
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */
    // toString method
    @Override
    public String toString() {
        return "{" + " Latitude= " + latitude + ", Longitude= " + longitude + " "+ super.toString()+'}';
    }
    
}
