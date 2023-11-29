import java.util.Scanner;
import java.util.HashMap;

enum CurrencyCode {
    USD,
    BDT,
    EUR,
    GBP,
    AUD,
    CAD,
    CHF,
    NZD,
    CNY,
    INR
}

class Currency {
    private CurrencyCode code;
    private double exchangeRate;

    public Currency(CurrencyCode code, double exchangeRate) {
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public CurrencyCode getCode() {
        return code;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double convert(double amount, Currency toCurrency) {
        return amount * toCurrency.exchangeRate;
    }
}

class CurrencyConverter {
    private final HashMap<CurrencyCode, Currency> currencies;

    public CurrencyConverter() {
        this.currencies = new HashMap<>();
        initializeCurrencies();
    }

    private void initializeCurrencies() {
        currencies.put(CurrencyCode.USD, new Currency(CurrencyCode.USD, 1.0));
        currencies.put(CurrencyCode.BDT, new Currency(CurrencyCode.BDT, 110.17));
        currencies.put(CurrencyCode.EUR, new Currency(CurrencyCode.EUR, 0.93));
        currencies.put(CurrencyCode.GBP, new Currency(CurrencyCode.GBP, 0.75));
        currencies.put(CurrencyCode.AUD, new Currency(CurrencyCode.AUD, 1.48));
        currencies.put(CurrencyCode.CAD, new Currency(CurrencyCode.CAD, 1.27));
        currencies.put(CurrencyCode.CHF, new Currency(CurrencyCode.CHF, 0.92));
        currencies.put(CurrencyCode.NZD, new Currency(CurrencyCode.NZD, 1.59));
        currencies.put(CurrencyCode.CNY, new Currency(CurrencyCode.CNY, 6.72));
        currencies.put(CurrencyCode.INR, new Currency(CurrencyCode.INR, 80.67));
    }

    public double convert(double amount, CurrencyCode fromCurrency, CurrencyCode toCurrency) {
        Currency from = currencies.get(fromCurrency);
        Currency to = currencies.get(toCurrency);
        return from.convert(amount, to);
    }

    public void showExchangeRates() {
        for (Currency currency : currencies.values()) {
            System.out.printf("%s: %.2f\n", currency.getCode(), currency.getExchangeRate());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        System.out.println("Do you want to see the exchange rates or convert currency? (1 for exchange rates, 2 for convert)");
        int choice = scanner.nextInt();

        CurrencyConverter converter = new CurrencyConverter();

        if (choice == 1) {
            converter.showExchangeRates();
            System.out.println("Thank you for using the currency converter!");
            System.exit(0);
        } else if (choice == 2) {
  CurrencyConverter converter2 = new CurrencyConverter();
  System.out.print("Enter the amount to convert: ");
  double amount = scanner.nextDouble();

  System.out.print("Choose the currency to convert from:\n" +
          "1. USD (US Dollar)\n" +
          "2. BDT (Bangladeshi Taka)\n" +
          "3. EUR(Euro)\n" +
          "4. GBP (British Pound)\n" +
          "5. AUD (Australian Dollar)\n" +
          "6. CAD (Canadian Dollar)\n" +
          "7. CHF (Swiss Franc)\n" +
          "8. NZD (New Zealand Dollar)\n" +
          "9. CNY (Chinese Yuan)\n" +
          "10. INR (Indian Rupee)\n" +
          "Enter your choice: ");

  int choiceFrom = scanner.nextInt();
  CurrencyCode fromCurrencyCode = CurrencyCode.values()[choiceFrom - 1];

  System.out.print("Choose the currency to convert to:\n" +
          "1. USD (US Dollar)\n" +
          "2. BDT (Bangladeshi Taka)\n" +
          "3. EUR(Euro)\n" +
          "4. GBP (British Pound)\n" +
          "5. AUD (Australian Dollar)\n" +
          "6. CAD (Canadian Dollar)\n" +
          "7. CHF (Swiss Franc)\n" +
          "8. NZD (New Zealand Dollar)\n" +
          "9. CNY (Chinese Yuan)\n" +
          "10. INR (Indian Rupee)\n" +
          "Enter your choice: ");

  int choiceTo = scanner.nextInt();
  CurrencyCode toCurrencyCode = CurrencyCode.values()[choiceTo - 1];

  if (fromCurrencyCode == toCurrencyCode) {
    System.out.println("You entered the same currency for both convert from and convert to. ");
    System.out.println("Please enter different currencies for a valid conversion.");
  } else {
    // Use converter2 here
    double convertedAmount = converter2.convert(amount, fromCurrencyCode, toCurrencyCode);

    System.out.printf("%.2f %s is equal to %.2f %s", amount, fromCurrencyCode, convertedAmount, toCurrencyCode);
  }
} else {
  System.out.println("Invalid choice. Please enter either 1 for exchange rates or 2 for convert.");
}
    }
}