package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/delete")
    @ResponseBody
    int deleteByPrimaryKey(Integer id) {
        return 0;
    }


    @RequestMapping("/insert")
    @ResponseBody
    int insert(Admin record) {
        return 0;
    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    int insertSelective(Admin record) {
        return 0;
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    Admin selectByPrimaryKey(Integer id) {
        return null;
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    int updateByPrimaryKeySelective(Admin record) {
        return 0;
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    int updateByPrimaryKey(Admin record) {
        return 0;
    }


    @RequestMapping("/list")
    @ResponseBody
    public Admin list(HttpServletRequest request, HttpServletResponse response){
        Admin admin=adminService.selectByPrimaryKey(1);
        System.out.println(admin.getName());
        return admin;
    }

    @RequestMapping("/listall")
    @ResponseBody
    public List<Admin> listall(HttpServletRequest request, HttpServletResponse response){
        List<Admin> adminlist=adminService.selectAll();
        return adminlist;
    }


}