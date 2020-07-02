package qin.com.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Admin;
import qin.com.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminServiceImpl")
    @Autowired
    private AdminService adminService;

    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(adminService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除管理员成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Admin record) { //管理员的信息应该是由客户端传送过来
        Admin admin = new Admin();
        admin.setName(record.getName());
        admin.setPass(DigestUtils.md5DigestAsHex((record.getPass().getBytes())));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.insert(admin)>0){
            return ServerResponse.createBySuccess(1,admin);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Admin record) {
        Admin admin = new Admin();
        admin.setName(record.getName());
        admin.setPass(DigestUtils.md5DigestAsHex((record.getPass().getBytes())));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.insert(admin)>0){
            return ServerResponse.createBySuccess(1,admin);
        }else {
            return ServerResponse.createByErrorMessage("添加管理员数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Admin admin = adminService.selectByPrimaryKey(1);
        if (admin!=null){
            return ServerResponse.createBySuccess(1,admin);
        }else {
            return ServerResponse.createByErrorMessage("找不到管理员");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Admin record) {
        Admin admin = new Admin();
        //更新操作必须要有id主关键字段
        admin.setId(record.getId());
        admin.setName(record.getName());
        //采用spring mvc 的Digestutils.md5DigestAsHex()方法对密码进行加密
        admin.setPass(DigestUtils.md5DigestAsHex((record.getPass().getBytes())));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.updateByPrimaryKeySelective(admin)>0){
            return ServerResponse.createBySuccess(0,admin);
        }else {
            return ServerResponse.createByErrorMessage("更新管理员数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Admin record) {
        Admin admin = new Admin();
        admin.setId(record.getId());//更新操作必须要有id主关键字段
        admin.setName(record.getName());
        //采用spring mvc 的Digestutils.md5DigestAsHex()方法对密码进行加密
        admin.setPass(DigestUtils.md5DigestAsHex((record.getPass().getBytes())));
        admin.setPhone(record.getPhone());
        admin.setEmail(record.getEmail());
        admin.setQq(record.getQq());
        if(adminService.updateByPrimaryKeySelective(admin)>0){
            return ServerResponse.createBySuccess(1,admin);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }


    @RequestMapping("/list")
    @ResponseBody
    public Admin list(HttpServletRequest request, HttpServletResponse response){
        Admin admin=adminService.selectByPrimaryKey(1);
        System.out.println(admin.getName());
        return admin;
    }

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Admin> adminList=adminService.selectAll();
        System.out.println("ok");
        if(adminList.size()>0){
            return ServerResponse.createBySuccess(adminList.size(),adminList);
        }else{
            return ServerResponse.createByErrorMessage("找不到管理员信息");
        }
    }

    @RequestMapping("/checkAdmin")
    @ResponseBody
    public ServerResponse  checkAdmin(@Param("name") String name){
        if(adminService.checkAdmin(name)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"可以使用管理");
        }else{
            return ServerResponse.createByErrorMessage("管理员信息已经存在");
        }
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public ServerResponse  checkEmail(@Param("email") String email){
        if(adminService.checkEmail(email)<0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"邮箱可以使用");
        }else{
            return ServerResponse.createByErrorMessage("邮箱已经存在");
        }
    }

    @RequestMapping("/checkPhone")
    @ResponseBody
    public ServerResponse  checkPhone(@Param("phone") String phone){
        if(adminService.checkPhone(phone)<0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"电话可以使用");
        }else{
            return ServerResponse.createByErrorMessage("已经存在");
        }
    }


    @RequestMapping("/checkNameAndPass")
    @ResponseBody
    public ServerResponse  checkNameAndPass(@Param("name") String name,@Param("pass") String pass){
        if(adminService.checkAdmin(name)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"输入的管理员和密码正确");
        }else{
            return ServerResponse.createByErrorMessage("输入的管理员和密码错误");
        }
    }

    @RequestMapping("/checkEmailAndPass")
    @ResponseBody
    public ServerResponse  checkEmailAndPass(@Param("email") String email,@Param("pass") String pass){
        if(adminService.checkEmail(email)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"输入的邮箱华人密码正确");
        }else{
            return ServerResponse.createByErrorMessage("输入的邮箱和密码错误");
        }
    }

    @RequestMapping("/checkPhoneAndPass")
    @ResponseBody
    public ServerResponse  checkPhoneAndPass(@Param("phone") String phone,@Param("pass") String pass){
        if(adminService.checkPhone(phone)>0 && adminService.checkPass(DigestUtils.md5DigestAsHex(pass.getBytes()))>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"输入的电话和密码正确");
        }else{
            return ServerResponse.createByErrorMessage("输入的电话和密码错误");
        }
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public ServerResponse deleteAll(String id){
        //把客户端传送过来的字符串（一般为“1，2，3，4”）转换成数组
        String[] deleteIds=id.split(",");
        System.out.println("delete");
        if(deleteIds !=null && deleteIds.length>0){
            if(adminService.deleteByList(deleteIds)>0){
                return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除管理员成功");
            }else{
                return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
            }
        }else{
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }

}