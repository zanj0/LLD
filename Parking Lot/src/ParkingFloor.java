import java.util.HashMap;

public class ParkingFloor {
    private String name;
    private HashMap<String, HandicappedSpot> handicappedSpots;
    /*
    compactSpots, largeSpots, motorbikeSpots, electricSpots, infoPortals;
    * */
    private ParkingDisplayBoard displayBoard;
    public ParkingFloor(String name){
        this.name = name;
    }
    public void addParkingSpot(ParkingSpot spot){
        switch (spot.getType()){
            case ParkingSpotType.HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), spot);
                break;
            default:
                System.out.println("Wrong parking spot type.");


        }
    }
    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot){
        spot.assignVehicle(vehicle);
        switch (spot.getType()){
            case ParkingSpotType.HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }
    private void updateDisplayBoardForHandicapped(ParkingSpot spot){
        if(this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()){
            for(String key: handicappedSpots.keySet()){
                if(handicappedSpots.get(key).isFree()){
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    public void freeSpot(ParkingSpot spot){
        spot.removeVehicle();
        switch (spot.getType()){
            case ParkingSpotType.HANDICAPPED:
                freeHandicappedSpotCount++;
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }
}
