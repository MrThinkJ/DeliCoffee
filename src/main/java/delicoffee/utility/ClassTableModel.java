package delicoffee.utility;

import delicoffee.model.Menu;
import delicoffee.model.NhanVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Long
 */
public class ClassTableModel {

    public DefaultTableModel setTableNhanVien(List<NhanVien> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                NhanVien nhanVien = listItem.get(i);
                obj = new Object[columns];
                obj[0] = nhanVien.getMaNhanVien();
                obj[1] =(i+1);
                obj[2] = nhanVien.getHoVaTen();
                obj[3] = nhanVien.getNgaySinh();
                obj[4] = nhanVien.getDiaChi();
                obj[5] = nhanVien.getSoDienThoai();
                obj[6] = nhanVien.isGioiTinh() == true ? "Nam" : "Nu";
                obj[7] = nhanVien.getChucVu();
                obj[8] = nhanVien.getTienLuong();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }

     public DefaultTableModel setTableMenu(List<Menu> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }    
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                Menu menu = listItem.get(i);
                obj = new Object[columns];
                obj[0] = menu.getMaMon();
                obj[1] =(i+1);
                obj[2] = menu.getTenMon();
                obj[3] = menu.getGiaMon();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }


}
