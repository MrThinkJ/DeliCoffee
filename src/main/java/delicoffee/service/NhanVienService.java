package delicoffee.service;

import delicoffee.model.NhanVien;
import java.util.List;

/**
 *
 * @author Long
 */
public interface NhanVienService {

    public List<NhanVien> getList();
    public int createOrUpdate(NhanVien nhanVien);

}
