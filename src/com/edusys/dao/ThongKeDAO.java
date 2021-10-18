/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ciuz
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql,String[] cols,Object...args){
        List<Object[]> lst = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i = 0 ; i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                lst.add(vals);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
    public  List<Object[]> getBangDiem(int makh){
        String sql = "{Call sp_BangDiem(?)}";
        String[] cols={"MaNH","HoTen","Diem"};
        return this.getListOfArray(sql, cols, makh);
    }
    public  List<Object[]> getLuongNguoiHoc(){
        String sql = "{Call sp_ThongKeNguoiHoc}";
        String[] cols={"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListOfArray(sql, cols);
    }
    public  List<Object[]> getDiemChuyenDe(){
        String sql = "{Call sp_ThongKeDiem}";
        String[] cols={"ChuyenDe","SoHV","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols);
    }
    public  List<Object[]> getDoanhThu(int nam){
        String sql = "{Call sp_ThongKeDoanhThu(?)}";
        String[] cols={"ChuyenDe","SoKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, cols, nam);
    }
    
}
