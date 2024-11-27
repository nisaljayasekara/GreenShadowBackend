package lk.ijse.greenshadowbackend.util;

public class AppUtil {

    private static int vehicleCounter = 0;

    public static synchronized String createVehicleCode(){
        vehicleCounter++;
        return String.format("V%04d", vehicleCounter);
    }
}
