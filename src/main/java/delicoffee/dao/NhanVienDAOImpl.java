package delicoffee.dao;

import delicoffee.model.NhanVien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class NhanVienDAOImpl implements NhanVienDAO {

    @Override
    public List<NhanVien> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM nhan_vien";
            List<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(rs.getInt("maNhanVien"));
                nhanVien.setHoVaTen(rs.getString("hoVaTen"));
                nhanVien.setNgaySinh(rs.getDate("ngaySinh"));
                nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setGioiTinh(rs.getBoolean("gioiTinh"));
                nhanVien.setChucVu(rs.getString("chucVu"));
                nhanVien.setTienLuong(rs.getString("tienLuong"));
                list.add(nhanVien);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void removeList(int id) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM nhan_vien where maNhanVien = ?";
            PreparedStatement ps = cons.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
        }
    }

    public static void insertList(NhanVien nhanVien) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhan_vien(hoVaTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, tienLuong) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, nhanVien.getHoVaTen());
            ps.setDate(2, (Date) nhanVien.getNgaySinh());
            ps.setBoolean(3, nhanVien.isGioiTinh());
            ps.setString(4, nhanVien.getSoDienThoai());
            ps.setString(5, nhanVien.getDiaChi());
            ps.setString(6, nhanVien.getChucVu());
            ps.setString(7, nhanVien.getTienLuong());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static int createOrUpdate(NhanVien nhanVien) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "update nhan_vien set hoVaTen = ?, ngaySinh = ?, soDienThoai = ?, diaChi = ?, gioiTinh = ?, chucVu = ?, tienLuong = ? where maNhanVien = ?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nhanVien.getHoVaTen());
            ps.setDate(2, new Date(nhanVien.getNgaySinh().getTime()));
            ps.setString(3, nhanVien.getSoDienThoai());
            ps.setString(4, nhanVien.getDiaChi());
            ps.setBoolean(5, nhanVien.isGioiTinh());
            ps.setString(6, nhanVien.getChucVu());
            ps.setString(7, nhanVien.getTienLuong());
            ps.setInt(8, nhanVien.getMaNhanVien());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        NhanVienDAO NhanVienDAO = new NhanVienDAOImpl();
        System.out.println(NhanVienDAO.getList());
    }

}
