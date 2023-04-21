
package delicoffee.service;

import delicoffee.dao.NhanVienDAO;
import delicoffee.dao.NhanVienDAOImpl;
import delicoffee.model.NhanVien;
import java.util.List;

/**
 *
 * @author Long
 */
public class NhanVienServiceImpl implements NhanVienService{

    private NhanVienDAO nhanVienDAO = null;

    public NhanVienServiceImpl() {
        nhanVienDAO = new NhanVienDAOImpl();
    }
    
    
    
    @Override
    public List<NhanVien> getList() {
        return nhanVienDAO.getList();
    }
    
    

    @Override
    public int createOrUpdate(NhanVien nhanVien) {
        return NhanVienDAOImpl.createOrUpdate(nhanVien);
    }

   

    
}
