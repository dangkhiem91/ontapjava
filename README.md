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

