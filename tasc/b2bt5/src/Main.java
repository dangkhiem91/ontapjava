import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"TIKI", "LAZADA", "SHOPEE"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap chuoi vao day: ");
        String s = scanner.nextLine();

        boolean check = false;
        for (String str : strs){
            if (s.equals(str)){
                check = true;
                System.out.println("chuoi hop le");
                break;
            }
        }
        if (!check){
            System.out.println("chuoi khong hop le");
        }

    }
}