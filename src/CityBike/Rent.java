package CityBike;


import java.time.LocalTime;

public class Rent {
    private int bikeID;
    private LocalTime rentStart;
    private LocalTime rentEnd;

    public Rent(int bikeID){
        this.bikeID = bikeID;
        rentStart = LocalTime.now();
    }

    public void returnBike(){
        rentEnd = LocalTime.now();
    }
}
