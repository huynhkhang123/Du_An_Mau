/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAnMau_HelPer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class DateHelper {

    // khai báo biến mặc đinh và kiểu định dạng ngày tháng năm.
    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    // chuyển từ String sang Date
    // kiểu bắt buộc trả về là ngày
    public static Date toDate(String date, String... pattern) {
        try {
            // date là chuổi thời gian truyền vào , còn pattern là định dạng kiểu thời gian
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]); // pattern: mẫu để app vào định dạng đúng.
            }
            if (date == null) {
                return DateHelper.now();// nếu date ko có giữ liệu chuyển về đúng thì return về ngày hiện tại
            }
            return (Date) DATE_FORMATER.parse(date); // chuyển đổi String date về ngày
        } catch (ParseException ex) {
            // xử lí luồn ngoại lện ra ngoài và ko cần return nửa;
            throw new RuntimeException();
        }

    }

    // chuyển date sang ngày 
    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

    // lấy ngày h hiện tại
    public static Date now() {
        return new Date();
    }

    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        System.out.println(date);
        return date;
    }
    
     public static Date add(int days) {
            Date now = DateHelper.now();
            now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
            return now;
        }
  
}
