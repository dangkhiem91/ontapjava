import java.util.Scanner;

public class SanPham {
    private int Id;
    private String productname;
    private String manufacturer;
    private String productline;
    private double price;

    public SanPham() {
    }

    public SanPham(int id ,String productname, String manufacturer, String productline, double price){
        this.Id = id;
        this.productname = productname;
        this.manufacturer = manufacturer;
        this.productline = productline;
        this.price = price;
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
