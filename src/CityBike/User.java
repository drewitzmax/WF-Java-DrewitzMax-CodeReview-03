package CityBike;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private Bike currentlyRentedBike;
    private ArrayList<Rent> rentals;
    private final int ID;

    private static int users = 0;

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.ID = users;
        this.rentals = new ArrayList<Rent>();

        users++;
    }

    public void returnBike(Station s){
        if(currentlyRentedBike != null) {
            if(s.returnBike(currentlyRentedBike))
            {
                currentlyRentedBike = null;
                rentals.get(rentals.size()-1).returnBike();
                System.out.println(name + "has returned his bike");
            } else {
                System.out.println("Theres no space for your bike");
            }
        } else {
            System.out.println("You have no bike to return");
        }
    }

    public void rentBike(Station s){
        if(currentlyRentedBike == null) {
            currentlyRentedBike = s.rentBike();
            rentals.add(new Rent(currentlyRentedBike.getBikeID()));
        } else {
            System.out.println("You already have a bike");
        }
    }
}
