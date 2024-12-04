package lk.ijse.greenshadowbackend.util;

import org.springframework.data.geo.Point;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class AppUtil {

    private static int vehicleCounter = 0;
    private static int equipmentCounter = 0;

    private static int cropCounter = 0;

    private static int staffCounter = 0;

    private static int fieldCounter = 0;
    private static int logCounter = 0;

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
    public static synchronized String createFieldId(){
        fieldCounter++;
        return String.format("F%04d",fieldCounter);
    }
    public static String toBase64FieldImage1(MultipartFile fieldImage1) throws IOException{
        if (fieldImage1 == null || fieldImage1.isEmpty()){
            return null;
        }
        return Base64.getEncoder().encodeToString(fieldImage1.getBytes());
    }

    public static String toBase64FieldImage2(MultipartFile fieldImage2) throws IOException {
        if (fieldImage2 == null || fieldImage2.isEmpty()) {
            return null;
        }
        return Base64.getEncoder().encodeToString(fieldImage2.getBytes());
    }
    public static Point toPoint(String pointString) {
        if (pointString == null || pointString.isEmpty())
            throw new RuntimeException("Point string cannot be null or empty");
        String[] parts = pointString.split(",");
        if (parts.length != 2)
            throw new RuntimeException("Point string must be in the format 'latitude,longitude'");
        try {
            double latitude = Double.parseDouble(parts[0].trim());
            double longitude = Double.parseDouble(parts[1].trim());
            return new Point(latitude, longitude);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid latitude or longitude value", e);
        }

    }  public static String toBase64ObservedImage(MultipartFile observedImage) {
        try {
            if (observedImage == null || observedImage.isEmpty()) {
                return "";
            }
            return Base64.getEncoder().encodeToString(observedImage.getBytes());
        } catch (IOException e) {
            return "";
        }
    }
    public static synchronized String createLogCode(){
        logCounter++;
        return String.format("L%04d", logCounter);
    }

}
