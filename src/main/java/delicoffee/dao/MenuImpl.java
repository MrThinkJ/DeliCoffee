package delicoffee.dao;

import delicoffee.model.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class MenuImpl implements MenuDAO {

    @Override
    public List<Menu> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM drink";
            List<Menu> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setMaMon(rs.getInt(1));
                menu.setTenMon(rs.getString(3));
                menu.setGiaMon(rs.getInt(2));
                list.add(menu);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void removeList(int id) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM drink where id = ?";
            PreparedStatement ps = cons.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertList(Menu menu) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO drink(name, price) VALUES(?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, menu.getTenMon());
            ps.setInt(2, menu.getGiaMon());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createOrUpdate(Menu menu) {
        try {
            System.out.println("aaa");
            Connection cons = DBConnect.getConnection();
            String sql = "update drink set price = ?, name = ? where id = ?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(2, menu.getTenMon());
            ps.setInt(1, menu.getGiaMon());
            ps.setInt(3, menu.getMaMon());
            System.out.println(sql);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            ps.close();
            cons.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MenuDAO MenuDAO = new MenuImpl();
        System.out.println(MenuDAO.getList());
    }

}
