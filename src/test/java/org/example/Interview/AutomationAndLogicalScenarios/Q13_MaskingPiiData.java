package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.regex.Pattern;

/**
 * Masking PII Data in Test Execution Reports: Replace emails and 16-digit credit card
 * numbers with asterisks before writing to HTML reports.
 * SDET: Keep automation logs compliant with GDPR/HIPAA/PCI-DSS.
 */
public class Q13_MaskingPiiData {
    private static final Pattern EMAIL = Pattern.compile(
            "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    private static final Pattern CREDIT_CARD = Pattern.compile(
            "\\b(?:\\d[ -]*?){13,16}\\b");

    public static void main(String[] args) {
        String report = "User test.user@domain.com paid with 4111 1111 1111 1111; backup card 5500-0000-0000-0004";
        System.out.println("Masked (best): " + maskPii(report));
        System.out.println("Email only: " + maskEmails(report));
        System.out.println("Cards only: " + maskCreditCards(report));
    }

    // Best: combined replace for report sanitization
    public static String maskPii(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String masked = maskEmails(text);
        return maskCreditCards(masked);
    }

    public static String maskEmails(String text) {
        if (text == null) {
            return null;
        }
        return EMAIL.matcher(text).replaceAll("****");
    }

    public static String maskCreditCards(String text) {
        if (text == null) {
            return null;
        }
        return CREDIT_CARD.matcher(text).replaceAll("****");
    }

    // Partial mask: keep last 4 digits for cards (optional reporting style)
    public static String maskCreditCardsKeepLast4(String text) {
        if (text == null) {
            return null;
        }
        return CREDIT_CARD.matcher(text).replaceAll(match -> {
            String digits = match.group().replaceAll("\\D", "");
            if (digits.length() < 4) {
                return "****";
            }
            return "****" + digits.substring(digits.length() - 4);
        });
    }
}
