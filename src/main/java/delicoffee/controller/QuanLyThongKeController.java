package delicoffee.controller;

import delicoffee.bean.ChiNhanhBean;
import delicoffee.bean.ChucVuBean;
import delicoffee.service.ThongKeService;
import delicoffee.service.ThongKeServiceImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author HOME
 */
public class QuanLyThongKeController {

    private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        thongKeService = new ThongKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<ChucVuBean> listItem = thongKeService.getListByChucVu();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ChucVuBean item : listItem) {
                dataset.addValue(item.getSoLuongNhanVien(), "Nhân Viên", item.getNgayBatDau());
            }

            JFreeChart chart = ChartFactory.createBarChart("ThỐNG KÊ SỐ LƯỢNG NHÂN VIÊN", "Thời gian", "Số lượng", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

    public void setDataToChart2(JPanel jpnItem) {
         List<ChiNhanhBean> listItem = thongKeService.getListByChiNhanh();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ChiNhanhBean item : listItem) {
                System.out.println(item.getDoanhThu());
                dataset.addValue(item.getDoanhThu(), "Nghìn", item.getNgayTongKet());
            }

            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ DOANH THU", "Thời gian", "Doanh Thu", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

}
