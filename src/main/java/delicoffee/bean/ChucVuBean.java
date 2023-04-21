package delicoffee.bean;
public class ChucVuBean {
    private String ngayBatDau;
    private int soLuongNhanVien;

    public ChucVuBean() {
    }

    public ChucVuBean(String ngayBatDau, int soLuongNhanVien) {
        this.ngayBatDau = ngayBatDau;
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }
    
    
}
