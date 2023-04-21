package delicoffee.service;

import delicoffee.dao.MenuDAO;
import delicoffee.dao.MenuImpl;
import delicoffee.model.Menu;
import java.util.List;

/**
 *
 * @author Long
 */
public class MenuServiceImpl implements MenuService {

    private MenuDAO menuDAO = null;

    public MenuServiceImpl() {
        menuDAO = new MenuImpl();
    }

    @Override
    public List<Menu> getList() {
        return menuDAO.getList();
    }


    @Override
    public void createOrUpdate(Menu menu) {
        MenuImpl.createOrUpdate(menu);
    }

}
