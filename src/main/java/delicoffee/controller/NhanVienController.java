package delicoffee.controller;

import com.toedter.calendar.JDateChooser;
import delicoffee.dao.NhanVienDAOImpl;
import delicoffee.model.NhanVien;
import delicoffee.service.NhanVienService;
import delicoffee.service.NhanVienServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Long
 */
public class NhanVienController {

    private JButton btnSubmit;
    private JButton btnSubmit1;
    private JTextField jtfMaNhanVien;
    private JTextField jtfHoVaTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JTextField jtfChucVu;
    private JTextField jtfTienLuong;
    private JLabel jlbMsg;

    private NhanVien nhanVien = null;
    private NhanVienService nhanVienService = null;

    public NhanVienController(JButton btnSubmit, JTextField jtfMaNhanVien, JTextField jtfHoVaTen, JDateChooser jdcNgaySinh, JRadioButton jrdNam, JRadioButton jrdNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi, JTextField jtfChucVu, JTextField jtfTienLuong, JLabel jlbMsg, JButton btnSubmit1) {
        this.btnSubmit = btnSubmit;
        this.jtfMaNhanVien = jtfMaNhanVien;
        this.jtfHoVaTen = jtfHoVaTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jtfChucVu = jtfChucVu;
        this.jtfTienLuong = jtfTienLuong;
        this.jlbMsg = jlbMsg;
        this.btnSubmit1 = btnSubmit1;

        this.nhanVienService = new NhanVienServiceImpl();
    }

    public void setView(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        jtfMaNhanVien.setText("" + nhanVien.getMaNhanVien());
        jtfHoVaTen.setText(nhanVien.getHoVaTen());
        jdcNgaySinh.setDate(nhanVien.getNgaySinh());
        jtaDiaChi.setText(nhanVien.getDiaChi());

        if (nhanVien.isGioiTinh()) {
            jrdNam.setSelected(true);
            jrdNam.setSelected(false);
        } else {
            jrdNam.setSelected(false);
            jrdNam.setSelected(true);
        }

        jtfSoDienThoai.setText(nhanVien.getSoDienThoai());
        jtfChucVu.setText(nhanVien.getChucVu());
        jtfTienLuong.setText(nhanVien.getTienLuong() + "");
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoVaTen.getText().length() == 0 || jdcNgaySinh.getDate() == null) {
                    jlbMsg.setText("Vui lòng nhập đầy đủ các thông tin dưới đây");
                } else {
                    nhanVien.setHoVaTen(jtfHoVaTen.getText());
                    nhanVien.setNgaySinh(jdcNgaySinh.getDate());
                    nhanVien.setDiaChi(jtaDiaChi.getText());
                    nhanVien.setGioiTinh(jrdNam.isSelected());
                    nhanVien.setSoDienThoai(jtfSoDienThoai.getText());
                    nhanVien.setChucVu(jtfChucVu.getText());
                    nhanVien.setTienLuong(jtfTienLuong.getText());
                    int lastId = nhanVienService.createOrUpdate(nhanVien);
                    if (lastId > 0) {
                        nhanVien.setMaNhanVien(lastId);
                        jtfMaNhanVien.setText("" + lastId);
                        jlbMsg.setText("Cập nhật thành công!");
                    }
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(Color.red);
            }

        });

        btnSubmit1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVien nhanVien = new NhanVien();

                try {
                    nhanVien.setMaNhanVien(Integer.parseInt(jtfMaNhanVien.getText()));
                    nhanVien.setChucVu(jtfChucVu.getText());
                    nhanVien.setDiaChi(jtaDiaChi.getText());
                    nhanVien.setGioiTinh(jrdNam.isSelected() ? true : false);
                    nhanVien.setSoDienThoai(jtfSoDienThoai.getText());
                    nhanVien.setTienLuong(jtfTienLuong.getText());
                    nhanVien.setNgaySinh(new Date(jdcNgaySinh.getDate().getTime()));
                    nhanVien.setHoVaTen(jtfHoVaTen.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Mã Nhân Viên Là Số");
                }

                NhanVienDAOImpl.insertList(nhanVien);
            }

        });

    }

}
