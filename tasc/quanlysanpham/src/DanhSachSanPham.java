import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSanPham {
    private ArrayList<SanPham> list ;
    private Scanner scanner;

    public DanhSachSanPham() {
        this.list = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public DanhSachSanPham(ArrayList<SanPham> list) {

    }
    int id = 0;
    int maxId = 0;

    public void input() {
        System.out.println("Nhap danh sach san pham: ");
        do {
            System.out.print("Tên sản phẩm: ");
            String sp = scanner.nextLine();
//            scanner.nextLine();
            id++;
//            if (id > maxId){
//                maxId = id;
//
//            }
            if (sp == null |sp.equals("")){
                break;
            } else {
                System.out.print("Nhập nhà sản xuất:");
                String nsx = scanner.nextLine();
                System.out.print("Nhập dòng sản phẩm:");
                String dsp = scanner.nextLine();
                System.out.print("Nhập giá thành sản phẩm:");
                double giasp = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("\n");
                list.add(new SanPham(id,sp, nsx, dsp, giasp));
            }

//            System.out.print("Nhập nhà sản xuất:");
//            String nsx = scanner.nextLine();
//            System.out.print("Nhập dòng sản phẩm:");
//            String dsp = scanner.nextLine();
//            System.out.print("Nhập giá thành sản phẩm:");
//            double giasp = scanner.nextDouble();
//            scanner.nextLine();


        }
        while (true);
    }

    public void display(){
        System.out.println("Danh sach san pham:");
        System.out.println("ID\t\t|Ten san pham\t\t|Nha san xuat\t\t|Dong san pham\t\t|Gia\t\t");
        for (SanPham sanPham : list) {
            System.out.printf("%7d |%18s | %18s| %18s| %.2f\n", sanPham.getId(),sanPham.getProductname(),sanPham.getManufacturer(),sanPham.getProductline(), sanPham.getPrice());
        }
    }

    public void findproduct() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap thong tin san pham: ");
        String sp = s.nextLine();
        SanPham found = null;

        for (SanPham sanPham : list) {
            if (sanPham.getProductname().equals(sp)) {
                found = sanPham;
                System.out.println("San pham can tim la: ");
                System.out.println("ID\t\t|Ten san pham\t\t|Nha san xuat\t\t|Dong san pham\t\t|Gia\t\t");
                System.out.printf("%7d |%18s | %18s| %18s| %.2f\n", found.getId(),found.getProductname(),found.getManufacturer(),found.getProductline(), found.getPrice());
                break;
            }
        }
    }

    public void addProduct(){
        System.out.println("Vui long nhap tiep san pham");
        int lengthID = list.size();
        id = lengthID;
        input();
    }

    public void updatebyId(){
        System.out.println("Nhap thong tin san pham can cap nhat: ");
        String s1 = scanner.nextLine();
        SanPham updateSP = null;

        for (SanPham sanPham : list) {
            if (sanPham.getProductname().equals(s1)) {
                updateSP = sanPham;
                int i = sanPham.getId();
            }
        }
    }

    public void deleteById(){
        
    }

    public void menu(){
        do {
            System.out.println("MENU CHUONG TRINH");
            System.out.println("1. Nhap danh sach san pham");
            System.out.println("2. Xuat danh sach san pham");
            System.out.println("3. Tim san pham theo ten");
            System.out.println("4. Them san pham");
            System.out.println("5. Cap nhat san pham theo ID");
            System.out.println("6. Xoa san pham theo Id");
            System.out.println("7. Thoat chuong trinh");
            System.out.print("Lua chon: ");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    findproduct();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    updatebyId();
                    break;
                //            case 6:
                case 7:
                    System.exit(0);
                    break;
                //
                default:
                    System.out.println("Gia tri lua chon khong dung");

            }
        }while(true);
    }

}
