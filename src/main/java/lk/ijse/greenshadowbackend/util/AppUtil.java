package lk.ijse.greenshadowbackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class AppUtil {

    private static int vehicleCounter = 0;
    private static int equipmentCounter = 0;

    private static int cropCounter = 0;

    private static int staffCounter = 0;

    public static synchronized String createVehicleCode(){
        vehicleCounter++;
        return String.format("V%04d", vehicleCounter);
    }
    public static synchronized String createEquipmentId(){
        equipmentCounter++;
        return String.format("E%04d",equipmentCounter);
    }
    public static synchronized String  createCropId(){
        cropCounter++;
        return String.format("C%04d",cropCounter);
    }
    public static String toBase64CropImage(MultipartFile cropImage) throws IOException {
        if (cropImage == null || cropImage.isEmpty()) {
            return null;
        }
        return Base64.getEncoder().encodeToString(cropImage.getBytes());
    }
    public static synchronized String createStaffId(){
        staffCounter++;
        return String.format("S%04d", staffCounter);
    }

}
