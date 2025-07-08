import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Supported currencies with sample conversion rates to INR
        double usdToInr = 83.10;
        double eurToInr = 90.25;
        double gbpToInr = 105.75;

        System.out.println("===== Currency Converter =====");
        System.out.println("Available currencies: ");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");

        System.out.print("Enter base currency (USD/EUR/GBP): ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        double inrAmount = 0;

        switch (baseCurrency) {
            case "USD":
                inrAmount = amount * usdToInr;
                break;
            case "EUR":
                inrAmount = amount * eurToInr;
                break;
            case "GBP":
                inrAmount = amount * gbpToInr;
                break;
            default:
                System.out.println("❌ Unsupported currency.");
                return;
        }

        System.out.printf("✅ %.2f %s = ₹%.2f INR\n", amount, baseCurrency, inrAmount);
        sc.close();
    }
}
