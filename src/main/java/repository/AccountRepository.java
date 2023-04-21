package repository;
import dao.DAO;
import entity.Account;


public interface AccountRepository{
    Account findByUsernameAndPassword(String username, String password);
    void addAccount(String username, String password, String role);
    void updateAccount(int id, String username, String password, String role);
    void deleteAccount(int id);
}
