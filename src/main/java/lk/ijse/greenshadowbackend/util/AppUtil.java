package lk.ijse.greenshadowbackend.util;

public class AppUtil {

    private static int vehicleCounter = 0;
    private static int equipmentCounter = 0;

    public static synchronized String createVehicleCode(){
        vehicleCounter++;
        return String.format("V%04d", vehicleCounter);
    }
    public static synchronized String createEquipmentId(){
        equipmentCounter++;
        return String.format("E%04d",equipmentCounter);
    }
}
