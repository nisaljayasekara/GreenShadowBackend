package lk.ijse.greenshadowbackend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String createCropId() {
        return "CROPS : " + UUID.randomUUID();
    }
}
