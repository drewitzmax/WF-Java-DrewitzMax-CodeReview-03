package CityBike;
import java.util.ArrayList;
import java.util.HashMap;

public class Station {
    private int id;
    private ArrayList<Bike> bikes;
    private String location;

    private final int MAX_BIKES = 5;
    private static int stations = 0;

    public Station(String location){
        this.location = location;
        this.id = stations;
        this.bikes = new ArrayList<Bike>();

        stations++;
    }

    public void placeBikes(ArrayList<Bike> newBikes){
        bikes.addAll(newBikes);
    }

    public void placeBike(Bike singleBike){
        bikes.add(singleBike);
    }

    public static void setUp(HashMap<Integer,Station> stations, int amount){
        for(int i=0; i<amount; i++){
            Station temp = new Station(decideLocation());
            stations.put(temp.id,temp);
        }
    }

    public void setUpBikes(HashMap<Integer,Bike> bikeMap, int amount){
        if(amount >= (MAX_BIKES - bikes.size())){
            System.out.println("not enough space for this many bikes");
            return;
        }
        for(int i=0; i<amount && !bikeMap.isEmpty(); i++){
            HashMap.Entry<Integer,Bike> entry = bikeMap.entrySet().iterator().next();
            Bike setBike = entry.getValue();
            try {
                setBike.setState("CanBeRented");
            } catch (Exception e){

            }

            this.bikes.add(setBike);
            bikeMap.remove(entry.getKey());
            if(i<(amount -1) && bikeMap.isEmpty()){
                System.out.println("Not enough bikes put " + (i+1) + " instead");
            }
        }
    }

    public String toString(){
        String res = "This is Station " + id + " in " + location + " the bikes here are: \n\t";
        for (Bike b:bikes) {
            res += b.toString() +"\n\t";
        }
        return res;
    }

    private static String decideLocation(){
        int choose = (int)(Math.random()*5);
        switch (choose){
            case 0: return "Vienna";
            case 1: return "Graz";
            case 2: return "Salzburg";
            case 3: return "Innsbruck";
            case 4: return "Eisenstadt";
            default: return "Berlin";
        }
    }

    public boolean returnBike(Bike b){
        if(bikes.size() <= 5) {
            this.bikes.add(b);
            System.out.println("Bike is now at Station " + id + " in " + location);
        } else {
            System.out.println("Sry there's no place for your bike here.");
        }
        return bikes.size() <= 5;
    }

    public Bike rentBike(){
        if(!bikes.isEmpty()){
            for(Bike b: bikes){
                if(b.getState().equals("CanBeRented")){
                    Bike temp = b;
                    bikes.remove(b);
                    return temp;
                }
            }
        }
        System.out.println("no bikes available right now!");
        return null;
    }

}
