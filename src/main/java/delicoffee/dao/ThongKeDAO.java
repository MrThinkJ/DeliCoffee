
package delicoffee.dao;

import delicoffee.bean.ChiNhanhBean;
import delicoffee.bean.ChucVuBean;
import java.util.List;

/**
 *
 * @author HOME
 */
public interface ThongKeDAO {
    public List<ChucVuBean> getListByChucVu();
    public List<ChiNhanhBean> getListByChiNhanh();
}
