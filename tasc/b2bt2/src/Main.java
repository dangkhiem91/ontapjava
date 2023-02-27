import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap chuoi vao day: ");
        String s = scanner.nextLine();
        String snew = s.replace(" ","");
        int n = snew.length();
        System.out.println("Nhap ki tu chen vao chuoi: ");
        String stringAdd = scanner.nextLine();
        for (int i = 0;i <n;i++){
            System.out.println(snew.charAt(i) + "" + stringAdd;);
        }
    }
}