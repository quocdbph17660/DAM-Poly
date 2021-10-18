package com.edusys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckForm {

    public static boolean checkRong(JTextField txt, StringBuilder sb, String text) {
        if (txt.getText().isEmpty()) {
            sb.append(text + " không được để trống\n");
            txt.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean checkRong(JPasswordField txt, StringBuilder sb, String text) {
        if (new String(txt.getPassword()).isEmpty()) {
            sb.append(text + " không được để trống\n");
            txt.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean checkRong(JTextArea txt, StringBuilder sb, String text) {
        if (txt.getText().isEmpty()) {
            sb.append(text + " không được để trống\n");
            txt.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean checkSoNguyen(JTextField txt, StringBuilder sb, String Text) {

        if (!checkRong(txt, sb, Text)) {
            return false;
        }
        try {
            float so = Float.parseFloat(txt.getText());
            int so2 = (int) so;
            if (so == so2 && so > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        sb.append(Text + " phải là số nguyên\n");
        return false;
    }

    public static boolean checkSoThuc(JTextField txt, StringBuilder sb, String Text) {

        if (!checkRong(txt, sb, Text)) {
            return false;
        }
        try {
            float so = Float.parseFloat(txt.getText());
            if (so > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        sb.append(Text + " phải là số nguyên và lớn hơn 0\n");
        return false;
    }

    public static boolean checkDate(JTextField txt, StringBuilder sb, String text) {
        if (!checkRong(txt, sb, text)) {
            return false;
        }
        try {
            String date = txt.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateForm = sdf.parse(date);
            return true;
        } catch (Exception e) {
            sb.append(text + " nhập đúng định dạng là yyyy-MM-dd \n");
            return false;
        }
    }

    public static boolean checkEmail(JTextField txt, StringBuilder sb, String text) {
        if (!checkRong(txt, sb, text)) {
            return false;
        }
        try {
            String id = txt.getText();
            String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
            if (id.matches(rgx)) {
                return true;
            } else {
                sb.append(text + " nhập đúng định dạng đi<3\n");
                return false;
            }
        } catch (Exception e) {
            sb.append(text + " nhập đúng định dạng đi<3\n");
            return false;
        }
    }

    public static boolean checkSDT(JTextField txt, StringBuilder sb, String text) {
        if (!checkRong(txt, sb, text)) {
            return false;
        }
        String sdt = txt.getText();
        try {
            for (int i = 0; i < sdt.length(); i++) {
                int sdt1 = Integer.parseInt(sdt.charAt(i) + "");
            }
            if (sdt.length() > 10) {
                sb.append(text + "không được quá 10 số \n");
                return false;
            }
            return true;
        } catch (Exception e) {
            sb.append(text + " nhập đúng định dạng đi<3\n");
            return false;
        }
    }
}
