import java.util.HashMap;

public class ParkingLot {
    private String name;
    private Location address;
    private ParkingRate parkingRate;
    private int handicappedSpotCount;

    private HashMap <String, EntrancePanel> entrancePanels;
    private HashMap <String, ExitPanel> exitPanels;
    private HashMap <String, ParkingFloor> parkingFloors;

    private HashMap<String, ParkingTicket> activeTickets;
    private static ParkingLot parkingLot = null; // SingleTon

    private ParkingLot(){
        /*
        * Inititialise variable from DB.
        * Initialise Parking Floors; read the parking floor map from DB.
        * Initialise parking spot counts.
        * Initialise entrance and exit panels.
        * */
    }
    public static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException{
        if(this.isFull(vehicle.getType)){
            throw new ParkingFullException();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
        ticket.saveInDb();
        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }
    public boolean isFull(VehicleType type){
        if(type == VehicleType.CAR) {
            return largeSpotCount >= maxLargeCount;
        }
    }
    public boolean incrementSpotCount(VehcileType type){
        if(type == VehicleType.CAR){
            largeSpotCount++;
        }
    }
    public boolean isFull(){
        for(String key : parkingFloors.keySet()){
            if(!parkingFloors.get(key).isFull()){
                return false;
            }
        }
        return true;
    }
    public void addParkingFloor(ParkingFloor florr){
        // stores in DB.
    }
    public void addEntrancePanel(EntrancePanel entrancePanel){
        // stores in DB.
    }
    public void addExitPanel(ExitPanel exitPanel){
        // stores in DB.
    }
}
