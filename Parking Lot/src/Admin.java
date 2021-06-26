public class Admin extends Account {
    public boolean addParkingFloor(ParkingFloor floor);
    public boolean addParkingSpot(String floorName, ParkingSpot spot);
    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
    public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);
    public boolean addEntrancePanel(EntrancePanel entrancePanel);
    public boolean addExitPanel(ExitPanel exitPanel);
}
