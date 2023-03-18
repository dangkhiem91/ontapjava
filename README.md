# ontapjava
## 1.Thread.
Luông là đơn vị nhỏ nhất trong Java, có thể thực hiện một công việc riêng biệt, các luồng được quản lý bởi máy ảo Java(JVM).

## 2.Multithread.
đề cập đến khả năng thực thi đồng thời của nhiều luồng trong ứng dụng Java.Multithread cho phép các tác vụ có thể được thực hiện đồng thời trên
các luồng khác nhau.

## 3.Multitask:(đa nhiệm)
là khả năng của một chương trình Java để thực hiện nhiều tác vụ (tasks) đồng thời. Điều này có thể đạt được bằng cách sử dụng multithreading hoặc phân công
(concurrency) trong java.

## 4.Ưu nhược điểm của multi-thread
| Ưu điểm  |Nhược điểm |
|   ------ | ------ |
|1. Nó chặn người sử dụng vì các luồng là độc lập và bạn có thể thực hiện nhiều công việc cùng một lúc|1. Càng nhiều luồng thì xử lý càng phức tạp|
|2. Mỗi luồng có thể dùng chung và chia sẻ tài nguồn tài nguyên trong quá trình chạy, nhưng có thể thực hiện một cách độc lập|2. Xử lý vấn đề về tranh chấp bộ nhớ, đồng bộ dữ liệu khác phức tạp       |
|3. Luồng là độc lập vì vậy nó không ảnh hưởng đến luồng khác nếu ngoại lệ xảy ra trong một luồng duy  nhất|3. Cần phát hiện tránh các luồng chết (dead lock), luồng chạy mà không làm gì trong ứng ứng dụng cả|
|4. Có thể thực hiện nhiều hoạt động với nhau để tiết kiệm thời gian. Ví dụ một ứng dụng có thể được tách thành:luồng chính chạy giao diện người dùng và các luồng phụ gửi kết quả xử lý đến luồng chính||

## 5. Vòng đời của thread
![image](https://user-images.githubusercontent.com/73598267/224602745-0c21da03-aee9-427c-89a3-c1fb1c928196.png)

- [NEW] - Đây là trạng thái khi luồng vừa được khởi tạo bằng phương thức khởi tạo của lớp Thread nhưng chưa được start(). Ở trạng thái này, luồng được tạo ra nhưng chưa được cấp phát tài nguyên và cũng chưa chạy. Nếu luồng đang ở trạng thái này mà ta gọi các phương thức ép buộc stop, resume, suspend...sẽ là nguyên nhân xảy ra ngoại lệ IllegalThreadStateException.
- [RUNABLE] - Sau khi gọi phương thức start() thì luồng test đã được cấp phát tài nguyên và các lịch điều phối CPU cho luồng test cũng bắt đầu có hiệu lực. Ở đây, chúng ta dùng trạng thái là Runable chứ không phải Running, vì luồng không thực sự luôn chạy mà tùy vào hệ thống mà có sự điều phối CPU khác nhau.
- [WAITING] - Thread chờ không giới hạn cho đến khi một luồng khác đánh thức nó.
- [TIMED_WAITING] - Thread chờ trong một thời gian nhất định, hoặc là có một luồng khác đánh thức nó.
- [BLOCKED] - Đây là một dạng của trạng thái "Not Runable", là trạng thái khi thread vẫn còn sống, nhưng hiện tại không được chọn để chạy. Thread chờ một monitor để unlick một đối tượng mà nó cần.
- [TERMINATED] - Một thread ở trong trạng thái terminated hoặc dead khi phương thức run() của nó bị thoát.

## 6. Callable, Future, Executors
###### 6.1.Callable
Callable là một interface trong java, nó định nghĩa một công việc và trả về một kết quả trong tương lai và có thể throw Exception.
###### 6.2.Future
Future là kết quả trả về của Callable, nó thể hiện kết quá của một phép tính không đồng bộ, cho phép kiểm trả trạng thái của phép tính(đã thực hiện xong chưa, kết quả trả về là gì...)
###### 6.3.Executors
Executors là một class tiện ích trong java, dùng để tạo thread pool, đối tượng callable cho các xử lý bất đồng bộ.

## 7.Kế thừa
###### 7.1.Upcasting (Ép kiểu từ lớp con lên lớp cha)
Khi biến của lớp cha tham chiếu tới đối tượng của lớp con( đối tượng của lớp con bị chuyển kiểu dữ liệu về lớp cha)
Khi biến của lớp cha tham chiếu tới đối tượng của lớp con thì biến này sẽ được sử dụng các thuộc tính và phương thức của lớp cha, nếu phương thức ở lớp cha bị ghi đè ở lớp con thì phương thức của lớp con sẽ được dùng khi biến gọi đến.
![image](https://user-images.githubusercontent.com/73598267/225805209-b983c5dd-1039-4a76-9bf2-f952a8adbe48.png)

Kết quả trả về: 

![image](https://user-images.githubusercontent.com/73598267/225805303-134dc81a-7593-44a2-ad07-45619905b9f5.png)

###### 7.2.Downcasting (Ép kiểu từ lớp cha xuống lớp con)
Ngược lại của Upcasting
![image](https://user-images.githubusercontent.com/73598267/225804728-a73fbcbb-1f92-4e19-b4ac-7d812f1ddefa.png)
Có thể downcasting như sau:
![image](https://user-images.githubusercontent.com/73598267/225805120-a1d8d38f-763f-40b5-a982-d2bec3f80dba.png)

## 8. Từ khóa static 
Từ khóa static được sử dụng để quản lý bộ nhớ tốt hơn và nó có thể truy cập trực tiếp thông qua lớp mà không cần khởi tạo. Từ khóa static thuộc về lớp chứ không thuộc về instance của lớp.

###### 8.1. Biến static
Biến có thể được khai báo cùng với từ khóa static và biến đó được gọi là class variable. Việc cấp phát bộ nhớ cho biến static chỉ xảy ra một lần khi class được nạp vào bộ nhớ.
Biến static có thể được sử dụng làm thuộc tính chung, để dùng chung dữ liệu cho tất cả objects của lớp đó(giúp tiết kiệm bộ nhớ).

###### 8.2. Phương thức static
Một số đặc điểm:
1. Phương thức static thuộc lớp chứ không phải đối tượng của lớp.
2. Phương thức static có thể được gọi mà không cần khởi tạo instance của một lớp.
3. Một phương thức có thể truy cập biến static và có thể thay đổi giá trị của nó.(phương thức non-static cũng có thể thay đổi giá trị của biến static nhưng phải thông qua 1 class khác).
4. Một phương thức static chỉ có thể gọi một phương thức static khác, không thể gọi được một phương thức non-static.
5. Một phương thức static không thể được sử dụng với từ khóa this và super.
6. Người dùng không thể override phương thức static trong java, bởi vì kỹ thuật đè(overriding) phương thức được dựa trên quá trình gán(binding) động khi chương trình đang chạy(runtime) và những phương thức static được gãn tĩnh trong thời gian biên dịch.

###### 8.3.static blocks
1. Khối static được dùng để khởi tạo hoặc thay đổi giá trị của các biến static
2. Nó được thực thi trước phương thức main tại thời gian tải lớp.
3. Một class có thể có nhiều static blocks
