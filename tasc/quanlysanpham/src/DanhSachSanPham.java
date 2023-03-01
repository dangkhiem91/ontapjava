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
            id++;
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
            }else {
                System.out.println("Khong tim thay san pham nao");
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
        Scanner update = new Scanner(System.in);
        System.out.println("Nhap ID san pham can cap nhat: ");
        int s1 = update.nextInt();
        SanPham updateSP = null;

        for (SanPham sanPham : list) {
            if (sanPham.getId() == s1){
                updateSP = sanPham;
                System.out.print("Ten san pham can cap nhat: ");
                String nameUpdate = update.nextLine();
                updateSP.setProductname(nameUpdate);
                update.nextLine();
                System.out.print("Ten nha san xuat can cap nhat: ");
                String manuUpdate = update.nextLine();
                updateSP.setManufacturer(manuUpdate);
//                update.nextLine();
                System.out.print("Ten dong san pham can cap nhat: ");
                String lineUpdate = update.nextLine();
                updateSP.setProductline(lineUpdate);
//                update.nextLine();
                System.out.print("Gia can cap nhat: ");
                double  priceupdate = update.nextDouble();
                updateSP.setPrice(priceupdate);
//                update.nextLine();
                System.out.println(nameUpdate);
                System.out.println("ID\t\t|Ten san pham\t\t|Nha san xuat\t\t|Dong san pham\t\t|Gia\t\t");
                System.out.printf("%7d |%18s | %18s| %18s| %.2f\n", updateSP.getId(),updateSP.getProductname(),updateSP.getManufacturer(),updateSP.getProductline(), updateSP.getPrice());
            } else {
                System.out.println("Khong tim thay ID phu hop");
            }
        }
    }

    public void deleteById(){
        System.out.println("Xoa san pham theo ID: ");
        System.out.println("Nhap ID can xoa: ");
        int idtoremove = scanner.nextInt();
        SanPham spfound = null;
        for (SanPham sp : list){
            if (sp.getId() == idtoremove){
                spfound = sp;
                break;
            }
        }
        if (spfound != null){
            list.remove(spfound);
            System.out.println("San pham da duoc xoa");
        } else {
            System.out.println("San pham khong tim thay trong danh sach");
        }
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
                case 6:
                    deleteById();
                    break;
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
