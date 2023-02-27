import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        convertToString convert = new convertToString();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap ten: ");
        String input = scanner.nextLine();
        System.out.println(convertToString.converToString(input));
    }
}