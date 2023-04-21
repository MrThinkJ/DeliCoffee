/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.Connect;
import dao.DAO;
import entity.Drink;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.DrinkRepository;

public class DrinkService extends DAO implements DrinkRepository {

    @Override
    public void addDrink(int price, String name) {
        String query = "Insert into drink (price, name) value (?, ?)";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, price);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDrink(int id, int price, String name) {
        String query = "update drink set price = ?, name = ? where id = ?";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, price);
            ps.setString(2, name);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDrink(int id) {
        String query = "delete from drink where id = ?";
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
    public List<Drink> getAllDrink() {
        List<Drink> drinkList = new ArrayList<>();
        String query = "select * from drink";
        try {
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
                drinkList.add(new Drink(rs.getInt(1), rs.getString(3), rs.getInt(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinkList;
    }
}
