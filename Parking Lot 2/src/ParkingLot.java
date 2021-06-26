import java.util.HashMap;

public class ParkingLot {
    private String name;
    private Location address;
    private ParkingRate parkingRate;
    private int handicappedSpotCount;

    private HashMap <String, EntrancePanel> entrancePanels; // Can be kept at floor -> Every floor can has it.
    private HashMap <String, ExitPanel> exitPanels;
    private HashMap <String, ParkingFloor> parkingFloors;
    private HashMap<String, Ticket> activeTickets;
    private ParkingLot(){
        /*
         * Inititialise variable from DB.
         * Initialise Parking Floors; read the parking floor map from DB.
         * Initialise parking spot counts.
         * Initialise entrance and exit panels.
         * */
    }

    public synchronized Ticket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException{
        ParkingFloor floor = getFloor(vehicle.getType());;
        if(floor == null) throw new ParkingFullException();
        Ticket ticket = new Ticket();
        ticket.getCharge(vehicle.getType(), floor); // Ticket is under admin control.
        vehicle.assignTicket(ticket);
        ticket.saveInDb();
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }


    public void getFloor(VehicleType type){
        for(String key : parkingFloors.keySet()){
            if(parkingFloors.get(key).isEmpty(type)){
                reutrn parkingFloors.get(key);
            }
        }
        return null;
    }
    public int calculateCharge(Vehicle vehicle);
    public int freeVehicle(Vehicle vehicle){
        // calls calculate charge.
    }
}
