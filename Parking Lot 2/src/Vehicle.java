public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;
    private Ticket ticket;
    private int entryTime;
    private int exitTime;
    public Vehicle(VehicleType type){
        this.type = type;
    }
    public void assignTicket(ParkingTicket ticket){
        this.ticket = ticket;
    }
}
