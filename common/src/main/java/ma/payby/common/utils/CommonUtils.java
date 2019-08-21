package ma.payby.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommonUtils {

    public static Map<String, String> ERROR_BUSINESS;
    static {
        ERROR_BUSINESS = new HashMap<>();
        ERROR_BUSINESS.put("M00001","Merchand not found!");
        ERROR_BUSINESS.put("M00002","Order not found!");
        ERROR_BUSINESS.put("M00003","Order already payed!");
        ERROR_BUSINESS.put("M00004","Order expired");
        ERROR_BUSINESS.put("M00005","Order not created !");
        ERROR_BUSINESS.put("M00006","Signature invalide !");

        ERROR_BUSINESS.put("W00001","Données invalids");

        ERROR_BUSINESS.put("A00001","User not found!");

        ERROR_BUSINESS.put("T00001","Error while generating Signature!");


    }

    public static String generateReference() {
        return UUID.randomUUID().toString();
    }
}
