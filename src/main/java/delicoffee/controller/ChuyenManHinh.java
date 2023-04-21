package delicoffee.controller;

import delicoffee.bean.DanhMucBean;
import delicoffee.view.ChiNhanhJPanel;
import delicoffee.view.MenuJPanel;
import delicoffee.view.NhanVienJPanel;
import delicoffee.view.ThongKeJPanel;
import delicoffee.view.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Long
 */
public class ChuyenManHinh {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public ChuyenManHinh(JPanel root) {
        this.root = root;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(Color.red);
        jlbItem.setBackground(Color.red);

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        if (listItem == null) {
            System.out.println("List Rỗng");
        } else {
            for (DanhMucBean item : listItem) {
                item.getJlb().addMouseListener(new labelEvent(item.getKind(), item.getJpn(), item.getJlb()));
            }
        }

    }

    class labelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public labelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "NhanVien":
                    node = new NhanVienJPanel();
                    break;
                case "ChucVu":
                    node = new MenuJPanel();
                    break;
//                case "ChiNhanh":
//                    node = new ChiNhanhJPanel();
//                    break;
                case "ThongKe":
                    node = new ThongKeJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(Color.red);
            jlbItem.setBackground(Color.red);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(0, 201, 167));
            jlbItem.setBackground(new Color(0, 201, 167));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(Color.red);
                jlbItem.setBackground(Color.red);

            }
        }

    }

    private void setChangeBackground(String kind) {
        if (listItem == null) {
            System.out.println("List Rỗng");
        } else {
            for (DanhMucBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(Color.red);
                    item.getJlb().setBackground(Color.red);
                } else {
                    item.getJpn().setBackground(new Color(0, 201, 167));
                    item.getJlb().setBackground(new Color(0, 201, 167));
                }
            }
        }

    }

}
