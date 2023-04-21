package service;

import config.Connect;
import dao.DAO;
import entity.Bill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Drink;
import entity.Table;
import repository.OrderRepository;

public class OrderService extends DAO implements OrderRepository {

    @Override
    public void addBill(int drinkId, int drinkQuantity) {
        String query = "insert into orderdrink (drinkId, quantity) value (?, ?)";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, drinkId);
            ps.setInt(2, drinkQuantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bill> getBillList(int tableId) {
        List<Bill> billList = new ArrayList<>();
        String query = "select od.ID, d.name, d.price, sum(od.quantity) from orderdrink as od join drink d on od.drinkId = d.ID join t_table tt on od.tableId = tt.ID where tt.ID = ? group by d.ID";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, tableId);
            rs = ps.executeQuery();
            while (rs.next()) {
                billList.add(new Bill(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public void remove(int drinkId) {
        String query = "delete from orderdrink where drinkId = ? and tableId = 0";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, drinkId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setTable(int tableId) {
        String query = "update orderdrink set tableId = ? where tableId = 0";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, tableId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll(int id) {
        String query = "delete from orderdrink where tableId = ?";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll() {
        String query = "delete from orderdrink where tableId = 0";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeDataToLog(int tableId) {
        String query = "insert into orderlog (date, drinkId, drinkQuantity) select curdate(), drinkId, quantity from orderdrink where tableId = ?";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, tableId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDataToChiNhanh() {
        String query = "insert into chi_nhanh(ngayTongKet, doanhThu)\n"
                + "select ol.date, sum(d.price*ol.drinkQuantity) from orderlog ol join drink d on d.id = ol.drinkId group by date having date = curdate();";
    }

    public int findDrinkIdFromDrinkName(String drinkName) {
        String query = "select id from drink where name = ?";
        int drinkId = 0;
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, drinkName);
            rs = ps.executeQuery();
            if (rs.next()) {
                drinkId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinkId;
    }

    @Override
    public void removeBillHaveDrinkName(String drinkName) {
        String query = "delete from orderdrink where drinkId = ?";
        int drinkId = findDrinkIdFromDrinkName(drinkName);
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, drinkId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
