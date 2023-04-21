package service;

import config.Connect;
import dao.DAO;
import entity.Account;
import java.sql.SQLException;
import repository.AccountRepository;

public class AccountService extends DAO implements AccountRepository{
    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        Account account = new Account();
		String query = "select * from account where username = ? && password = ?";
		try
		{
			conn = Connect.openConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next())
				account= new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return account;
    }

    @Override
    public void addAccount(String username, String password, String role) {
        String query = "insert into account (username, password, role) value (?,?,?)";
        try{
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(int id, String username, String password, String role) {
        String query = "update from account set username = ?, password = ?, role = ? where id = ?";
        try{
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int id) {
        String query = "delete from account where id = ?";
        try{
            conn = Connect.openConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
