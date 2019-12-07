package CityBike;

import java.util.HashMap;

public class Bike {
    private final int bikeID;
    private String color;
    private String state;
    private static int bikes = 0;

    public Bike(String color){
        bikeID = bikes ;
        this.color = color;
        state = "InService";

        bikes++;
    }

    public static void main(String[] args){
        HashMap<Integer,Bike> vehicles = new HashMap<Integer,Bike>();
        buyBikes(vehicles,8);
        HashMap<Integer,Station> stations = new HashMap<Integer,Station>();
        Station.setUp(stations,3);
        User max = new User("Max","Drewitz");
        User roman = new User("Roman","Blub");
        User alex = new User("Alex", "Blab");
        User jessica = new User("Jessica","Blob");
        stations.get(1).setUpBikes(vehicles,3);
        stations.get(2).setUpBikes(vehicles,4);
        max.rentBike(stations.get(2));
        max.returnBike(stations.get(1));
        System.out.println(stations.get(0).toString());
        System.out.println(stations.get(1).toString());
        System.out.println(stations.get(2).toString());
    }

    public static String getColor(){
        int choose = (int)(Math.random()*5);
        switch (choose){
            case 0: return "red";
            case 1: return "blue";
            case 2: return "yellow";
            case 3: return "white";
            case 4: return "black";
            default: return "purple";
        }
    }

    public static void buyBikes(HashMap<Integer,Bike> buyvehicles, int amount){
        for(int i=0; i<amount; i++){
            Bike temp = new Bike(getColor());
            buyvehicles.put(temp.bikeID,temp);
        }
    }

    public void setState(String state) throws Exception {
        if(state == "InService" || state == "CanBeRented" || state == "CanNotBeRented" || "Discarded" == state) {
            this.state = state;
        } else {
            throw new IllegalArgumentException("Invalid State");
        }
    }

    public String getState() {
        return state;
    }

    public int getBikeID() {
        return bikeID;
    }

    public String toString(){
        return bikeID + " " + color;
    }
}
