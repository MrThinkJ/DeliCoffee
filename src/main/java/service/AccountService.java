package service;

import daoconfig.AccountDatabaseConfig;
import daoconfig.DrinkDatabaseConfig;
import entity.Account;
import repository.AccountRepository;

public class AccountService implements AccountRepository {
    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        for (Account account : accountList) {
            if (account.getUsername().equalsIgnoreCase(username) && account.getPassword().equalsIgnoreCase(password))
                return account;
        }
        return null;
    }
    @Override
    public int getMaxId() {
        int maxId = 1;
        for (Account account : accountList)
            if (account.getId()>=maxId)
                maxId = account.getId();
        return maxId;
    }

    @Override
    public void addAccount(String username, String password, String role) {
        Account account = new Account();
        account.setId(getMaxId()+1);
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(role);

        accountList.add(account);
        AccountDatabaseConfig.changeAccountDatabase(accountList);
    }

    @Override
    public void updateAccount(int id, String username, String password, String role) {
        accountList.get(id - 1).setUsername(username);
        accountList.get(id - 1).setPassword(password);
        accountList.get(id - 1).setRole(role);
        AccountDatabaseConfig.changeAccountDatabase(accountList);
    }

    @Override
    public void deleteAccount(int id) {
        accountList.remove(id - 1);
        for (int i = id - 1; i < accountList.size(); i++) {
            accountList.get(i).setId(accountList.get(i).getId() - 1);
        }
        AccountDatabaseConfig.changeAccountDatabase(accountList);
    }
}
