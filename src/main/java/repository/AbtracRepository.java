package repository;

import jdbc.myConnection;

import java.sql.Connection;
import java.sql.SQLException;



/*Đây là 1 abtrac được xây dụng theo mô hình M Repository và trong class Sẽ khai báo 1 paramater.
* paramater đuợc khai báo trong đây là T tham số truyền vào ở đây là tham số chưa được xác định.
*  Khai báo 1 Class Có tên gọi là AbtracRepository và có tham số truyền vào cho T kiểu chưa được xác định.

* Ta khai báo 1 hàm chưa được xác định trong class và có hàm đó nhận 1 interface có tên JDBC Connect.
* Tại vì sao khải khi báo 1 hàm chưa được xác định bởi vì class nó nhận vào 1 paramater chưa được xác định.
*
*
* Tại vì sao phải sửa dụng kiểuAbtract chỗ này.
* Dùng để tối ưu hoá có dể tối ưu hoá code.
* Nhằm giảm tải code và những code lặp đi lặp lại quá nhiều lần trong 1 class.
* chẵn hạn như try ctach trong khi connect với Data.
* */

public class AbtracRepository <T>{


    public T ExcuteQuery(JDBCexcutive<T> process){


        try(Connection connection = myConnection.getConnection()){

               return process.process(connection);
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e);
        }

    }


    public void ExcuteQueryUpdate(JDBCexcutive<T> process){
        try(Connection connection = myConnection.getConnection()){

            process.process(connection);
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e);
        }


    }
}
