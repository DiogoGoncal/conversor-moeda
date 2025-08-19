import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

// Classe que representa a resposta da API
class ExchangeRateResponse {
    String base;
    Map<String, Double> rates;
}

public class CurrencyConverterMenu {

    private static final String BASE_URL = "https://api.exchangerate.host/latest";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    // Método para buscar taxas da API
    public static ExchangeRateResponse getRates(String baseCurrency) throws Exception {
        String url = BASE_URL + "?base=" + baseCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }

    // Método de conversão
    public static double convert(String from, String to, double amount) throws Exception {
        ExchangeRateResponse exchangeRate = getRates(from);
        Double rate = exchangeRate.rates.get(to);

        if (rate == null) {
            throw new RuntimeException("Taxa de conversão não encontrada para " + to);
        }

        return amount * rate;
    }

    // Programa principal com menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Conversor de Moedas ===");
            System.out.println("1 - BRL -> USD");
            System.out.println("2 - USD -> BRL");
            System.out.println("3 - BRL -> EUR");
            System.out.println("4 - EUR -> BRL");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            String from = "", to = "";

            switch (opcao) {
                case 1 -> { from = "BRL"; to = "USD"; }
                case 2 -> { from = "USD"; to = "BRL"; }
                case 3 -> { from = "BRL"; to = "EUR"; }
                case 4 -> { from = "EUR"; to = "BRL"; }
                default -> {
                    System.out.println("Opção inválida!");
                    System.exit(0);
                }
            }

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            double result = convert(from, to, amount);
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", amount, from, result, to);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
