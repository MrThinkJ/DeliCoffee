package delicoffee.controller;

import delicoffee.dao.NhanVienDAOImpl;
import delicoffee.model.NhanVien;
import delicoffee.service.NhanVienService;
import delicoffee.service.NhanVienServiceImpl;
import delicoffee.utility.ClassTableModel;
import delicoffee.view.NhanVienJFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Long
 */
public class QuanLyNhanVienController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JButton btnDelete;
    private JTextField jtfSearch;
    private JButton btnPrint;

    private NhanVienService nhanVienService = null;
    private String[] listColumn = {"Mã nhân viên", "STT", "Họ và tên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Giới tính", "Chức vụ", "Tiền lương"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhanVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnDelete, JButton btnPrint) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.nhanVienService = new NhanVienServiceImpl();
        this.btnDelete = btnDelete;
        this.btnPrint = btnPrint;
    }

    public void setDateToTable() {
        List<NhanVien> listItem = nhanVienService.getList();

        DefaultTableModel model = new ClassTableModel().setTableNhanVien(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });

        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);

        table.getColumnModel().getColumn(1).setMinWidth(95);
        table.getColumnModel().getColumn(1).setMaxWidth(95);
        table.getColumnModel().getColumn(1).setPreferredWidth(95);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int maNhanVien = (int) table.getValueAt(row, 0);
                if (table.getSelectedRow() != -1) {
                    model.removeRow(table.getSelectedRow());
                    NhanVienDAOImpl.removeList(maNhanVien);
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    NhanVien nhanVien = new NhanVien();

                    nhanVien.setGioiTinh(model.getValueAt(selectedRowIndex, 6).toString().equalsIgnoreCase("Nam"));
                    nhanVien.setMaNhanVien((int) model.getValueAt(selectedRowIndex, 0));
                    nhanVien.setHoVaTen(model.getValueAt(selectedRowIndex, 2).toString());
                    nhanVien.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 3));
                    nhanVien.setDiaChi(model.getValueAt(selectedRowIndex, 4) != null
                            ? model.getValueAt(selectedRowIndex, 4).toString() : "");
                    nhanVien.setSoDienThoai(model.getValueAt(selectedRowIndex, 5) != null
                            ? model.getValueAt(selectedRowIndex, 5).toString() : "");
                    nhanVien.setChucVu(model.getValueAt(selectedRowIndex, 7) != null
                            ? model.getValueAt(selectedRowIndex, 7).toString() : "");
                    nhanVien.setTienLuong(model.getValueAt(selectedRowIndex, 8).toString());

                    NhanVienJFrame frame = new NhanVienJFrame(nhanVien);
                    frame.setTitle("Thông tin nhân viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }

        });

        table.getTableHeader()
                .setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader()
                .setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(
                50);
        table.validate();

        table.repaint();

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.getViewport()
                .add(table);
        scrollPane.setPreferredSize(
                new Dimension(1000, 400));

        jpnView.removeAll();

        jpnView.setLayout(
                new BorderLayout());
        jpnView.add(scrollPane);

        jpnView.validate();

        jpnView.repaint();

    }

    public void setEvent() {

        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVienJFrame frame = new NhanVienJFrame(new NhanVien());
                frame.setTitle("Thông tin nhân viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(Color.red);
            }
        });

        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Nhân viên");

                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow(3);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Họ và tên");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Ngày sinh");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Giới tính");

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Số điện thoại");

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Địa chỉ");

                List<NhanVien> listItem = nhanVienService.getList();

                if (listItem != null) {
                    FileOutputStream fis = null;
                    try {
                        int s = listItem.size();
                        for (int i = 0; i < s; i++) {
                            NhanVien nhanVien = listItem.get(i);

                            row = sheet.createRow(4 + i);

                            cell = row.createCell(0, CellType.NUMERIC);
                            cell.setCellValue(i + 1);

                            cell = row.createCell(1, CellType.STRING);
                            cell.setCellValue(nhanVien.getHoVaTen());

                            cell = row.createCell(2, CellType.STRING);
                            cell.setCellValue(nhanVien.getNgaySinh().toString());

                            cell = row.createCell(3, CellType.STRING);
                            cell.setCellValue(nhanVien.isGioiTinh() ? "Nam" : "Nữ");

                            cell = row.createCell(4, CellType.STRING);
                            cell.setCellValue(nhanVien.getSoDienThoai());

                            cell = row.createCell(5, CellType.STRING);
                            cell.setCellValue(nhanVien.getDiaChi());
                        }
                        
                        
                        File f = new File("D:/nhan_vien.xlsx");
                        fis = new FileOutputStream(f);
                        workbook.write(fis);
                        fis.close();
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnPrint.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnPrint.setBackground(Color.red);
            }
        });

    }

}
