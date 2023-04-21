/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Table;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface TableRepository {
    List<Table> getAllTable();
    void changeStatus(int id, boolean status);
}
