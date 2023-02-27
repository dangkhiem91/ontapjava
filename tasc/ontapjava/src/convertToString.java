import java.text.Normalizer;
import java.util.regex.Pattern;

public class convertToString {
    public static String converToString (String value) {
        //dùng phương thức của lớp này để chuyển đổi văn bản Unicode thành dạng tổng hợp hoặc phân tách tương đương
        //cho phép sắp xếp và tìm kiếm văn bản dễ hơn
        String temp = Normalizer.normalize(value, Normalizer.Form.NFD).toUpperCase();
        //lớp này biên dịch đối tượng từ một biểu thức chính quy, dùng pt complie để tạo đối tượng, tham số là biểu thức chính quy
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("Đ", "D");
    }
}
