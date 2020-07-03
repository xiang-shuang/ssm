package qin.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Department;
import qin.com.entity.Department;
import qin.com.service.DepartmentService;
import qin.com.service.DepartmentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource(name = "departmentServiceImpl")
    @Autowired
    private DepartmentService departmentService;


    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }
    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(departmentService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除单位成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Department record) { //单位的信息应该是由客户端传送过来
        Department department = new Department();
        department.setName(record.getName());
        department.setdManager(record.getdManager());
        if(departmentService.insert(department)>0){
            return ServerResponse.createBySuccess(1,department);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Department record) {
        Department department = new Department();
        department.setName(record.getName());
        department.setdManager(record.getdManager());
        if(departmentService.insert(department)>0){
            return ServerResponse.createBySuccess(1,department);
        }else {
            return ServerResponse.createByErrorMessage("添加单位数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Department department = departmentService.selectByPrimaryKey(1);
        if (department!=null){
            return ServerResponse.createBySuccess(1,department);
        }else {
            return ServerResponse.createByErrorMessage("找不到单位");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Department record) {
        Department department = new Department();
        //更新操作必须要有id主关键字段
        department.setId(record.getId());
        department.setName(record.getName());
        department.setdManager(record.getdManager());
        if(departmentService.updateByPrimaryKeySelective(department)>0){
            return ServerResponse.createBySuccess(0,department);
        }else {
            return ServerResponse.createByErrorMessage("更新单位数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Department record) {
        Department department = new Department();
        //更新操作必须要有id主关键字段
        department.setId(record.getId());
        department.setName(record.getName());
        department.setdManager(record.getdManager());
        if(departmentService.updateByPrimaryKeySelective(department)>0){
            return ServerResponse.createBySuccess(1,department);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Department> departmentList=departmentService.selectAll();
        System.out.println("ok");
        if(departmentList.size()>0){
            return ServerResponse.createBySuccess(departmentList.size(),departmentList);
        }else{
            return ServerResponse.createByErrorMessage("找不到单位信息");
        }
    }
}