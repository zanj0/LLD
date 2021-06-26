public class Ticket {
    private String name;
    private String location;
    private String block;
    private ParkingSpot spot;
    private ParkingFloor floor;
    private int cost; // Timestamp
    // Entry and exit time should be here.
    int getCharge(VehicleType type, ParkingFloor floor);

}
