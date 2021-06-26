public class Shipment {
    private String shipementNumber;
    private Date shipementDate;
    private Date estimatedArrival;
    private String shipmentMethod;
    private List<ShipmentLog> shipmentLogs;
    public boolean addShipmentLog(ShipmentLog log);
}
