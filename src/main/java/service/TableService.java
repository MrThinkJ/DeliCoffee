/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.Connect;
import dao.DAO;
import entity.Table;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repository.TableRepository;

public class TableService extends DAO implements TableRepository{

    @Override
    public List<Table> getAllTable() {
        List<Table> tableList = new ArrayList<>();
        String query = "select * from t_table";
        try{
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next())
                tableList.add(new Table(rs.getInt(1), rs.getBoolean(2)));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tableList;
    }

    @Override
    public void changeStatus(int id, boolean status) {
        String query = "update t_table set status = ? where id = ?";
        try{
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
