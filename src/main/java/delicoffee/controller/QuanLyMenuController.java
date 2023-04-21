package delicoffee.controller;

import delicoffee.dao.MenuImpl;
import delicoffee.model.Menu;
import delicoffee.service.MenuService;
import delicoffee.service.MenuServiceImpl;
import delicoffee.utility.ClassTableModel;
import delicoffee.view.MenuJFrame;
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

public class QuanLyMenuController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JButton btnDelete;
    private JTextField jtfSearch;
    private JButton btnPrint;

    private MenuService menuService = null;
    private String[] listColumn = {"Mã món","STT", "Tên món", "Giá món"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyMenuController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnDelete, JButton btnPrint) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.menuService = new MenuServiceImpl();
        this.btnDelete = btnDelete;
        this.btnPrint = btnPrint;
    }

    public void setDateToTable() {
        List<Menu> listItem = menuService.getList();

        DefaultTableModel model = new ClassTableModel().setTableMenu(listItem, listColumn);
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
                int menu = (int) table.getValueAt(row, 0);
                if (table.getSelectedRow() != -1) {
                    model.removeRow(table.getSelectedRow());
                    MenuImpl.removeList(menu);
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

                    Menu menu = new Menu();

                    menu.setMaMon((int) model.getValueAt(selectedRowIndex, 0));
                    menu.setTenMon(model.getValueAt(selectedRowIndex, 2).toString());
                    menu.setGiaMon(Integer.parseInt(String.valueOf(model.getValueAt(selectedRowIndex, 1))));

                    MenuJFrame frame = new MenuJFrame(menu);
                    frame.setTitle("Thông tin cụ thể của món");
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
                MenuJFrame frame = new MenuJFrame(new Menu());
                frame.setTitle("Thông tin cụ thể của món");
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
                XSSFSheet sheet = workbook.createSheet("Thực Đơn");

                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow(3);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên món");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Số lượng món");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Giá món");

                List<Menu> listItem = menuService.getList();

                if (listItem != null) {
                    FileOutputStream fis = null;
                    try {
                        int s = listItem.size();
                        for (int i = 0; i < s; i++) {
                            Menu menu = listItem.get(i);

                            row = sheet.createRow(4 + i);

                            cell = row.createCell(0, CellType.NUMERIC);
                            cell.setCellValue(i + 1);

                            cell = row.createCell(1, CellType.STRING);
                            cell.setCellValue(menu.getTenMon());

                            cell = row.createCell(2, CellType.STRING);
                            cell.setCellValue(menu.getSoLuongMon());

                            cell = row.createCell(3, CellType.STRING);
                            cell.setCellValue(menu.getGiaMon());

                        }

                        File f = new File("D:/Thuc_Don.xlsx");
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
