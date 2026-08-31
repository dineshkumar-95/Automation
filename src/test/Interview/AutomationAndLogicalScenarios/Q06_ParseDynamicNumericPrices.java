package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract and Parse Dynamic Numeric Prices: Accept UI price strings like "$1,240.99 USD"
 * or "€45,50", strip currency/spaces/commas, convert to double.
 * SDET: Validate cart totals, tax, and price sorting across locales.
 */
public class Q06_ParseDynamicNumericPrices {
    public static void main(String[] args) {
        System.out.println("$1,240.99 USD -> " + parsePrice("$1,240.99 USD"));
        System.out.println("€45,50 -> " + parsePrice("€45,50"));
        System.out.println("₹ 1.234,56 -> " + parsePrice("₹ 1.234,56"));
        System.out.println("Loop cleanup: " + parsePriceManual("£99.00"));
    }

    // Best: normalize locale separators then parse
    public static double parsePrice(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("price empty");
        }
        // Keep digits, separators, and minus
        String cleaned = raw.replaceAll("[^0-9,\\.\\-]", "").trim();
        if (cleaned.isEmpty()) {
            throw new IllegalArgumentException("no numeric content in: " + raw);
        }

        int lastComma = cleaned.lastIndexOf(',');
        int lastDot = cleaned.lastIndexOf('.');
        if (lastComma > lastDot) {
            // European style: 1.234,56 or 45,50
            cleaned = cleaned.replace(".", "").replace(",", ".");
        } else {
            // US style: 1,240.99
            cleaned = cleaned.replace(",", "");
        }
        return Double.parseDouble(cleaned);
    }

    // Regex extract number token then normalize
    public static double parsePriceUsingRegex(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("price null");
        }
        Matcher matcher = Pattern.compile("[-+]?[0-9][0-9.,]*").matcher(raw);
        if (!matcher.find()) {
            throw new IllegalArgumentException("no price in: " + raw);
        }
        return parsePrice(matcher.group());
    }

    public static double parsePriceManual(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("price null");
        }
        StringBuilder sb = new StringBuilder();
        for (char c : raw.toCharArray()) {
            if ((c >= '0' && c <= '9') || c == '.' || c == ',' || c == '-') {
                sb.append(c);
            }
        }
        return parsePrice(sb.toString());
    }

    public static String formatUsd(double value) {
        return String.format(Locale.US, "$%.2f", value);
    }
}
