import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Vui long nhap so tien vao day: ");
        double currency = scanner.nextDouble();
        String str = currencyFormat.format(currency);
        System.out.println("So sau khi dinh dang = " + str);
    }
}