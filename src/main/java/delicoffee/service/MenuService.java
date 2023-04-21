package delicoffee.service;

import delicoffee.model.Menu;
import java.util.List;

/**
 *
 * @author Long
 */
public interface MenuService {

    public List<Menu> getList();
    public void createOrUpdate(Menu menu);

}
