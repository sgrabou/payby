package ma.payby.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum MerchantStatus {
    ACTIVE("01","Active"),
    DESACTIVE("02","Desactive");

    private final String code;
    private final String label;
    private static Map<String, String> mMap;

    private MerchantStatus(String code, String label) {
        this.code = code;
        this.label = label;
    }


    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static String getStatutLabel(String labelCode) {
        if (mMap == null) {
            initializeMapping();
        }
        if (mMap.containsKey(labelCode)) {
            return mMap.get(labelCode);
        }
        return null;
    }

    private static void initializeMapping() {
        mMap = new HashMap<>();
        for (MerchantStatus s : MerchantStatus.values()) {
            mMap.put(s.code, s.label);
        }
    }
}
