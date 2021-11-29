/**
 * 
 */
package it.unibo.oop.lab.enum2;

import it.unibo.oop.lab.enum2.Place.*;

/**
 * Represents an enumeration for declaring sports.
 * 
 * 1) You must add a field keeping track of the number of members each team is
 * composed of (1 for individual sports)
 * 
 * 2) A second field will keep track of the name of the sport.
 * 
 * 3) A third field, of type Place, will allow to define if the sport is
 * practiced indoor or outdoor
 * 
 */
public enum Sport {
	BASKET(Place.INDOOR, 10, "Basket"),
	VOLLEY(Place.INDOOR, 6, "Volley"),
	TENNIS(Place.OUTDOOR, 1, "Tennis"),
	BIKE(Place.OUTDOOR, 1, "Bike"),
	F1(Place.OUTDOOR, 1, "Formula 1"),
	MOTOGP(Place.OUTDOOR, 1, "MotoGP"),
	SOCCER(Place.OUTDOOR, 10, "Soccer");

    /*
     * TODO
     * 
     * [FIELDS]
     * 
     * Declare required fields
     */
	private int noTeamMembers;
	private String name;
	private Place place;

    /*
     * TODO
     * 
     * [CONSTRUCTOR]
     * 
     * Define a constructor like this:
     * 
     * - Sport(final Place place, final int noTeamMembers, final String actualName)
     */
	Sport(final Place place, final int noTeamMembers, final String actualName) {
		this.place = place;
		this.noTeamMembers = noTeamMembers;
		this.name = actualName;
	}

    /*
     * TODO
     * 
     * [METHODS] To be defined
     * 
     * 
     * 1) public boolean isIndividualSport()
     * 
     * Must return true only if called on individual sports
     * 
     * 
     * 2) public boolean isIndoorSport()
     * 
     * Must return true in case the sport is practices indoor
     * 
     * 
     * 3) public Place getPlace()
     * 
     * Must return the place where this sport is practiced
     * 
     * 
     * 4) public String toString()
     * 
     * Returns the string representation of a sport
     */
	public boolean isIndividualSport() {
		return this.noTeamMembers == 1;
	}
	
	public boolean isIndoorSport() {
		return this.place == Place.INDOOR;
	}
	
	public Place getPlace() {
		return this.place;
	}
	
	public String toString() {
		return "Sport [ Name: " + this.name + "; Place: " + this.getPlace() + "; No. Team members: " + this.noTeamMembers + "]";
	}
}
