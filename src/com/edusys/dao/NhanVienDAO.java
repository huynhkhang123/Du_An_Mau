package com.edusys.dao;

import com.edusys.entity.NhanVien;
import com.edusys.jdbcHelper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends EduSysDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NhanVien(MaNV, MatKhau, HoTen, VaiTro) VALUES(?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NhanVien SET MatKhau = ?, HoTen = ?, VaiTro = ? WHERE MaNV = ?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV = ?";
    String SELECT_TAI_KHOAN = "SELECT MaNV, MatKhau FROM NhanVien WHERE MaNV = ? AND MatKhau = ?";

    @Override
    public void insert(NhanVien entity) {
        
    }

    @Override
    public void update(NhanVien entity) {
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public List<NhanVien> selectAll() {
        return null;
    }

    @Override
    public NhanVien selectByID(String maNV) {
        return null;
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(SELECT_TAI_KHOAN, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        System.out.println(list);
        return list;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
}
