import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vui long nhap so vao day: ");
        int n = scanner.nextInt();
        byte[] array = new byte[n];
        new Random().nextBytes(array);
        String generateString = new String(array, Charset.forName("UTF-8"));
        System.out.println("Random String: " + generateString);
    }
}