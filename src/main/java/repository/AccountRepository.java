package repository;

import daoconfig.AccountDatabaseConfig;
import entity.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> accountList = AccountDatabaseConfig.dataSource();
    Account findByUsernameAndPassword(String username, String password);
    int getMaxId();
    void addAccount(String username, String password, String role);
    void updateAccount(int id, String username, String password, String role);
    void deleteAccount(int id);
}
