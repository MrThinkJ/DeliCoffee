package delicoffee.service;

import delicoffee.bean.ChiNhanhBean;
import delicoffee.bean.ChucVuBean;
import delicoffee.dao.ThongKeDAO;
import delicoffee.dao.ThongKeDaoImpl;
import java.util.List;

/**
 *
 * @author HOME
 */
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        thongKeDAO = new ThongKeDaoImpl();
    }

    
    
    @Override
    public List<ChucVuBean> getListByChucVu() {
        return thongKeDAO.getListByChucVu();
        
    }

    @Override
    public List<ChiNhanhBean> getListByChiNhanh() {
        return thongKeDAO.getListByChiNhanh();
    }
    
}
