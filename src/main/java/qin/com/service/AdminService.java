package qin.com.service;

import org.apache.ibatis.annotations.Param;
import qin.com.entity.Admin;

import java.util.List;

public interface AdminService {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAll(); //查询所有管理员的信息

    int checkAdmin(@Param("name") String name); //名称进行查询

    int checkEmail(@Param("Email") String email); //邮箱进行查询

    int checkPhone(@Param("phone") String phone); //电话进行查询

    int checkPass(@Param("pass") String pass);  //密码进行查询

    boolean checkNameAndPass(String name,String pass);//用户和密码进行查询


}