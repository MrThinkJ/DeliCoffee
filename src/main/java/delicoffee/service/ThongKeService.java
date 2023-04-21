package delicoffee.service;

import delicoffee.bean.ChiNhanhBean;
import delicoffee.bean.ChucVuBean;
import java.util.List;

/**
 *
 * @author HOME
 */
public interface ThongKeService {

    public List<ChucVuBean> getListByChucVu();

    public List<ChiNhanhBean> getListByChiNhanh();

}
