
package delicoffee.bean;

import java.util.Date;

/**
 *
 * @author Long
 */
public class ChiNhanhBean {
    private String maChiNhanh;
    private String tenChiNhanh;
    private Date ngayBatDau;
    private Date ngayTongKet;
    private int doanhThu;

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }

    
    
    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }
    
    

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayTongKet() {
        return ngayTongKet;
    }

    public void setNgayTongKet(Date ngayTongKet) {
        this.ngayTongKet = ngayTongKet;
    }

    
    
}
