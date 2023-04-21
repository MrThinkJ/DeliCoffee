
package delicoffee.bean;

import java.util.Date;

public class MenuBean {
    private String maMon;
    private String tenMon;
    private int giaMon;

    public MenuBean() {
    }

    public MenuBean(String maMon, String tenMon, int giaMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giaMon = giaMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGiaMon() {
        return giaMon;
    }

    public void setGiaMon(int giaMon) {
        this.giaMon = giaMon;
    }
        
    
}
