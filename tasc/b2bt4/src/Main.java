import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        boolean isNumeric = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("vui long nhap chuoi vao day: ");
        String str = scanner.nextLine();

//        Pattern pattern = Pattern.compile(".*[^0-9].*");
//
//        if (!pattern.matcher(str).matches()){
//            System.out.println("day la mot so");
//        }else{
//            System.out.println("day khong phai la so");
//        }

        try {
            Double d = Double.parseDouble(str);
        }catch (NumberFormatException ex) {
            isNumeric = false;
        }

        if (isNumeric){
            System.out.printf("Day la mot so");
        }else {
            System.out.println("Day khong phai la mot so");
        }


    }
}