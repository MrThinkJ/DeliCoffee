
package delicoffee.dao;

import delicoffee.bean.ChiNhanhBean;
import delicoffee.bean.ChucVuBean;
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
 * @author HOME
 */
public class ThongKeDaoImpl implements ThongKeDAO{

    @Override
    public List<ChucVuBean> getListByChucVu() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ngayBatDau, COUNT(*) AS tienLuong FROM chuc_vu GROUP BY ngayBatDau";
            List<ChucVuBean> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChucVuBean chucVuBean = new ChucVuBean();
                chucVuBean.setNgayBatDau(rs.getString("ngayBatDau"));
                chucVuBean.setSoLuongNhanVien(rs.getInt("tienLuong"));
                list.add(chucVuBean);
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

    @Override
    public List<ChiNhanhBean> getListByChiNhanh() {
try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT tenChiNhanh, ngayBatDau, ngayTongKet, doanhThu FROM chi_nhanh";
            List<ChiNhanhBean> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiNhanhBean chiNhanhBean = new ChiNhanhBean();
                chiNhanhBean.setTenChiNhanh(rs.getString("tenChiNhanh"));
                chiNhanhBean.setNgayBatDau(rs.getDate("ngayBatDau"));
                chiNhanhBean.setNgayTongKet(rs.getDate("ngayTongKet"));
                chiNhanhBean.setDoanhThu(rs.getInt("doanhThu"));
                list.add(chiNhanhBean);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;    }
    
}
