package com.tasc.productmanagement.Utils;


import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    public static Integer validateId(Scanner scanner){
        Integer input = null;
        while (input == null){
            System.out.println("Nhập Id: ");
            String str = scanner.nextLine();
            try {
                input = Integer.parseInt(str);
            }catch (NumberFormatException n){
                System.out.println("Nhập không đúng");
            }
        }
        return input;
    }

    public static Double validatePrice(Scanner scanner) {
        Double input = null;
        while (input == null || input < 100) {
            try {
                System.out.println("Nhập giá sản phẩm: ");
                input = scanner.nextDouble();
                if (input < 100) {
                    System.out.println("Giá sản phẩm không hợp lý, vui lòng nhập lại: ");
                    input = null;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
        return input;
    }
}
