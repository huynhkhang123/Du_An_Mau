/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAnMau_HelPer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class jdbcHelper {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost;database=Polypro";
    static String user = "sa";
    static String pass = "123";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static PreparedStatement prst(String sql, Object... args) throws SQLException {
        // tạo đường dẫn kết nối sql sever
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement prst = null;// tạo prst để lưu trữ các câu lệnh sql nha

        if (sql.startsWith("{")) {// kiểm tra 
            prst = con.prepareCall(sql);// cho thực thi câu lệnh là Proc
        } else {
            prst = con.prepareStatement(sql); // thực thi sql
        }
        for (int i = 0; i < args.length; i++) {
            prst.setObject(i + 1, args[1]);
        }
        return prst;
    }

    public static void update(String sql, Object... args) throws SQLException {
        // tạo 1 cái prst để ta lưu các sql để thực thi và 
        PreparedStatement prst = jdbcHelper.prst(sql, args);//còn kiểm tra xem nó có phải là câu lệnh đó ko
        try {
            prst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {//luôn luôn chayhj khi code xong và đóng dòng lệnh lại
            prst.getConnection().close();
        }
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {// ở đây mình đang sử dunjh selet về thì phải dùng là Result trả về nề
        PreparedStatement prst = jdbcHelper.prst(sql, args);
        return prst.executeQuery(); // trả về câu lệnh chạy 
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if (rs.next()) {// kiểm tra có ko
                return rs.getObject(0);// lấy về giá trị oj đầu tiên
            }
            rs.getStatement().getConnection().close();//  đóng kết nối
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

   
}
