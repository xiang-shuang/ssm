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
        return adminMapper.selectAll();
    }

    @Override
    public int checkAdmin(String name) {
        return adminMapper.checkAdmin(name);
    }

    @Override
    public int checkEmail(String email) {
        return adminMapper.checkEmail(email);
    }

    @Override
    public int checkPhone(String phone) {
        return adminMapper.checkPhone(phone);
    }

    @Override
    public int checkPass(String pass) {
        return adminMapper.checkPass(pass);
    }

    @Override
    public boolean checkNameAndPass(String name, String pass) {
        if((checkAdmin(name)>0) && (checkPass(pass)>0)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkEmailAndPass(String email, String pass) {
        if((checkAdmin(email)>0) && (checkPass(pass)>0)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkPhoneAndPass(String phone, String pass) {
        if((checkAdmin(phone)>0) && (checkPass(pass)>0)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int deleteByList(String[] ids) {  //注意方法参数是字符串的数组
        return adminMapper.deleteByList(ids);

    }
}