package qin.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qin.com.entity.Admin;
import qin.com.mapper.AdminMapper;
import qin.com.service.AdminService;

import java.util.List;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer id){
        return adminMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(Admin record){
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record){
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Admin> selectAll() {
        return null;
    }

    @Override
    public int checkAdmin(String name) {
        return 0;
    }

    @Override
    public int checkEmail(String email) {
        return 0;
    }

    @Override
    public int checkPhone(String phone) {
        return 0;
    }

    @Override
    public int checkPass(String pass) {
        return 0;
    }

    @Override
    public boolean checkNameAndPass(String name, String pass) {
        return false;
    }
}