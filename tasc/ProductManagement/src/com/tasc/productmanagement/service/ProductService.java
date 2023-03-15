package com.tasc.productmanagement.service;
import com.tasc.productmanagement.Utils.FileUtils;
import com.tasc.productmanagement.entity.Product;
import java.util.Scanner;
import static com.tasc.productmanagement.Utils.Validation.validateId;
import static com.tasc.productmanagement.Utils.Validation.validatePrice;

public class ProductService {
    Scanner scanner = new Scanner(System.in);
    static FileUtils fileUtils = new FileUtils();
    public static final String filename = "productlist.txt";

    public boolean findById(String id) {
        String readline = fileUtils.readFile(filename);
        boolean found = false;
        String[] lines = readline.split("\n");
        if (readline == null){
            System.out.println("File không có dữ liệu");
            return found;
        } else {
            for (String line : lines) {
                String[] newline = line.substring(1, line.length() - 1).split(",");
                String findid = newline[0].split("=")[1];
                if (id.equals(findid)){
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public void findAll() {
        String fileall = fileUtils.readFile(filename);
        System.out.println("Danh sách sản phẩm: ");
//        System.out.printf("%6s%3s | %15s%9s | %15s%8s | %11s%6s | %15s%5s\n",
//                "Id", "",
//                "Name", "",
//                "Producer", "",
//                "Model", "",
//                "Price", "");
        System.out.print("----------------------------------------------------" +
                "---------------------------------------------------\n");
        System.out.println(fileall);
        System.out.print("----------------------------------------------------" +
                "---------------------------------------------------\n");
    }

    public void createProduct(){
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tên công ty sản xuất: ");
        String producer = scanner.nextLine();
        System.out.println("Nhập tên dòng sản phẩm: ");
        String model = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = validatePrice(scanner);
        int id = getMaxId();
        Product product = new Product(id, name, producer, model, price);
        StringBuffer sb = new StringBuffer();
        String newline = String.valueOf(sb.append("[id=").append(id)
                .append(",name=").append(name)
                .append(",manufacturer=").append(producer)
                .append(",model=").append(model)
                .append(",price=").append(price).append("]"));
        fileUtils.writeFile(filename,newline, true);
    }

    public static Integer getMaxId(){
       int maxId = 0;
       String readfile = fileUtils.readFile(filename);
       String[] lines = readfile.split("\n");
       for (String line : lines){
           String[] newline = line.substring(1,line.length()-1).split(",");
           int id = Integer.parseInt(newline[0].split("=")[1]);
           if (maxId < id){
               maxId = id;
           }
       }
        return maxId + 1;
    }

    public String[] findByName() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String findname = scanner.nextLine();
        boolean found = false;
        String readfile = fileUtils.readFile(filename);
        if (readfile == null){
            System.out.println("File không có sản phẩm");
        } else{
            String[] lines = readfile.split("\n");
            for (String line : lines){
                String[] newline = line.substring(1,line.length()-1).split(",");
                String name = newline[1].split("=")[1];
                if (name.toLowerCase().trim().contains(findname)){
                    System.out.println(line);
                }
            }
        }
        return null;
    }

    public void updateById(){
        String readfile = fileUtils.readFile(filename);
        String[] lines = readfile.split("\n");
        Integer id = validateId(scanner);
        boolean found = findById(String.valueOf(id));
        if (found == false){
            System.out.println("Không tìm thấy");
        } else {
            System.out.println("Nhập tên sản phẩm: ");
            String name = scanner.nextLine().trim();
            System.out.println("Nhập tên nhà sản xuất: ");
            String producer = scanner.nextLine().trim();
            System.out.println("Nhập dòng sản phầm: ");
            String model = scanner.nextLine().trim();
            double price = validatePrice(scanner);
            Product product = new Product(id, name, producer, model, price);
            for (int i = 0; i < lines.length; i++) {
                String regex = "^\\[id=" + id + "\\,(.*)$";
                if(lines[i].matches(regex)){
                    lines[i] = String.format("[id=%d,name=%s,manufacturer=%s,model=%s,price=%.1f]",product.getId(),product.getName(),product.getProducer(),product.getModel(),product.getPrice());
                    found = true;
                }
            }
            if(found = true){
                String updateline = String.join("\n",lines);
                fileUtils.writeFile(filename, updateline,false);
            }else {
                System.out.println("Không tìm thấy Id: " + id);
            }
        }
    }

    public void deleteById(){
        String readfile = fileUtils.readFile(filename);
        String[] lines = readfile.split("\n");
        Integer id = validateId(scanner);
        boolean found = findById(String.valueOf(id));
        if (found == false){
            System.out.println("Không tìm thấy");
        } else {
            for (int i = 0; i < lines.length; i++) {
                String regex = "^\\[id=" + id + "\\,(.*)$";
                if (lines[i].matches(regex)){
                    lines[i] = null;
                    found = true;
                }


            }
            if (found){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < lines.length; i++) {
                    if (lines[i] != null){
                        sb.append(lines[i]).append("\n");
                    }
                }
                fileUtils.writeFile(filename,sb.toString().trim(),false);
            } else {
                System.out.println("Không tìm thấy Id");
            }
        }
    }

//        public boolean delete(String id){
//        boolean found = false;
//        String readfile = fileUtils.readFile(filename);
//        String[] lines = readfile.split("\n");
//        for (int i = 0; i < lines.length; i++) {
//            String regex = "^\\[id=" + id + "\\,(.*)$";
//            if(lines[i].matches(regex)){
//                lines[i] = null;
//                found = true;
//                break;
//            }
//        }
//        if (found){
//            StringBuilder sbuilder = new StringBuilder();
//            for (int i = 0; i < lines.length; i++) {
//                if(lines[i] != null){
//                    sbuilder.append(lines[i]).append("\n");
//                    System.out.println("Xóa thành công");
//                    break;
//                }
//            }
//            fileUtils.writeFile(filename, sbuilder.toString().trim(), false);
//        }else {
//            System.out.println("Không tìm thấy ID");
//        }
//        return found;
//    }

//        public boolean update(String id, Product product){
//        boolean found = false;
//        String readfile = fileUtils.readFile(filename);
//        String[] lines = readfile.split("\n");
//
//        for (int i = 0; i < lines.length; i++) {
//            String regex = "^\\[id=" + id + "\\,(.*)$";
//            if(lines[i].matches(regex)){
//                lines[i] = String.format("[id=%d,name=%s,manufacturer=%s,model=%s,price=%.1f]",product.getId(),product.getName(),product.getProducer(),product.getModel(),product.getPrice());
//                found = true;
//            }
//        }
//        if (found){
//            String updateline = String.join("\n",lines);
//            fileUtils.writeFile(filename, updateline,false);
//        } else {
//            System.out.println("Không tìm thấy Id: " + id);
//        }
//
//        return found;
//    }
}







