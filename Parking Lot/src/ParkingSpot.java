public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;
    public boolean isFree();
    public ParkingSpot(ParkingSpotType type){
        this.type = type;
    }
    public boolean assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        free = false;
    }
    public boolean removeVehicle(){
        this.vehicle = null;
        free = true;
    }
}
