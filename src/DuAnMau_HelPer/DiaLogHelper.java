/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuAnMau_HelPer;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DiaLogHelper {

    public static void alert(Component parent, String message) {
        // 2 tham số là thành phần và mess lỗi
        JOptionPane.showMessageDialog(parent, message);
    }
    // trả về đúng sai
    public static boolean confirn(Component parent, String message) {
        // trả về giá trị int và return giá trị true (yes options)
        int result = JOptionPane.showConfirmDialog(parent, message, "Hệ thống quả lí đào tạo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;// trả về
    }
    // trả về String nên retunr thằng
    public static  String inputMessage(Component parent, String message){
        return JOptionPane.showInputDialog(parent, message, "Hệ thống quả lí đào tạo", JOptionPane.INFORMATION_MESSAGE);
    }
}
