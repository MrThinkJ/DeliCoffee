package delicoffee.model;

/**
 *
 * @author Long
 */
import java.util.Date;

public class NhanVien {
    private int maNhanVien;
    private String hoVaTen;
    private Date ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private boolean gioiTinh;
    private String chucVu;
    private String tienLuong;

    public String getTienLuong() {
        return tienLuong;
    }

    public void setTienLuong(String tienLuong) {
        this.tienLuong = tienLuong;
    }

   

    
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return  maNhanVien + " - " + hoVaTen;
    }
    
    
    
}
