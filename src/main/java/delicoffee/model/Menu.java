package delicoffee.model;

import java.util.Date;

/**
 *
 * @author Long
 */
public class Menu {
    private int maMon;
    private String tenMon;
    private int soLuongMon;    
    private int giaMon;

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoLuongMon() {
        return soLuongMon;
    }

    public void setSoLuongMon(int soLuongMon) {
        this.soLuongMon = soLuongMon;
    }

   
    public int getGiaMon() {
        return giaMon;
    }

    public void setGiaMon(int giaMon) {
        this.giaMon = giaMon;
    }

    @Override
    public String toString() {
        return "maMon=" + maMon + ", tenMon=" + tenMon;
    }
    
    

   
    
}
