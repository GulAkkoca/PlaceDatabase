/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdconsoleıo;

/**
 *
 * @author Gül
 */
public class PopulatedPlace extends LocatedPlace {
    private int population;

    /**
     *
     * @param population
     * @param latitude
     * @param longitude
     * @param zipcode
     * @param town
     * @param state
     */
    // Constructor
    public PopulatedPlace(int population,double latitude, double longitude,String zipcode, String town, String state) { 
       super(latitude,longitude,zipcode,town,state);
        this.population = population;
    }

    /**
     *
     * @return
     */
    //getter and setter methods
    public int getPopulation() {
        return population;
    }

    /**
     *
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     *
     * @return
     */
    // toString method to print to output
    @Override
    public String toString() {
        return "{" + "Population= " + population +" " + super.toString()+ '}';
    }
    
}
