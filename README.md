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


