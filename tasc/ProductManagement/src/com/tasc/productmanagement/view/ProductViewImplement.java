package com.tasc.productmanagement.view;

import com.tasc.productmanagement.service.ProductService;
import java.util.Scanner;

public class ProductViewImplement{
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();

    public void generateMenu() {
        do {
            System.out.println("MENU");
            System.out.println("-------------------------");
            System.out.println("1.Danh sách sản phẩm");
            System.out.println("2.Tìm kiếm sản phẩm");
            System.out.println("3.Thêm sản phẩm");
            System.out.println("4.Cập nhật sản phẩm");
            System.out.println("5.Xóa sản phẩm");
            System.out.println("6.Thoát chương trình");
            System.out.println("-------------------------");
            System.out.println("Lựa chọn (1 - 6): ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    productService.findAll();
                    scanner.nextLine();
                    break;
                case 2:
                    productService.findByName();
                    scanner.nextLine();
                    break;
                case 3:
                    productService.createProduct();
                    scanner.nextLine();
                    break;
                case 4:
                    productService.updateById();
                    scanner.nextLine();
                    break;
                case 5:
                    productService.deleteById();
                    scanner.nextLine();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không đúng, vui lòng nhập lại");
            }
            scanner.nextLine();
        } while(true);
    }
}
