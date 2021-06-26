public class ParkingDisplayBoard {
    private String id;
    private HandicappedSpot handicappedFreeSpot;

    public void showEmptySpotNumber(){
        String message = "";
        if(handicappedFreeSpot.isFree()){
            message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
        }else{
            message += "Handicapped is full";
        }
        show(message);
    }
}
