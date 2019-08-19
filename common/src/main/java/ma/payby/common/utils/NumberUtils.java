package ma.payby.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public class NumberUtils {
   private static final String LOCAL_LNG = "fr";
   private static final String LOCAL_ZONE = "FR";
   private static final String NUMBER_PATTERN = "#,##0.00";
   private static final int GROUPING_SIZE = 3;
   private static final char DECIMAL_SEPARATOR = ',';
   private static final char GROUPING_SEPARATOR = ' ';
   private static final int FRACTION_DIGITS = 2;
   public NumberUtils() {
       super();
   }
   public static String formatNumber(BigDecimal number) {
       Locale locale = new Locale(LOCAL_LNG, LOCAL_ZONE);
       DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
       symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
       symbols.setGroupingSeparator(GROUPING_SEPARATOR);
       DecimalFormat decimalFormat =new DecimalFormat(NUMBER_PATTERN,symbols);
       decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
       decimalFormat.applyPattern(NUMBER_PATTERN);
       decimalFormat.setGroupingSize(GROUPING_SIZE);
       decimalFormat.setMinimumFractionDigits(FRACTION_DIGITS);
       return decimalFormat.format(number).replace("    ", " ");
   }
}