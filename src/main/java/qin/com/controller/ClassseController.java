package qin.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Classse;
import qin.com.service.ClassseService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/classse")
public class ClassseController {

    @Resource(name = "classseServiceImpl")
    @Autowired
    private ClassseService classseService;


    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }
    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(classseService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除班级成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Classse record) { //班级的信息应该是由客户端传送过来
        Classse classse = new Classse();
        classse.setName(record.getName());
        classse.setMajorId(record.getMajorId());
        classse.setMajorName(record.getMajorName());
        classse.setStudentNumber(record.getStudentNumber());
        if(classseService.insert(classse)>0){
            return ServerResponse.createBySuccess(1,classse);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Classse record) {
        Classse classse = new Classse();
        classse.setName(record.getName());
        classse.setMajorId(record.getMajorId());
        classse.setMajorName(record.getMajorName());
        classse.setStudentNumber(record.getStudentNumber());
        if(classseService.insert(classse)>0){
            return ServerResponse.createBySuccess(1,classse);
        }else {
            return ServerResponse.createByErrorMessage("添加班级数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Classse classse = classseService.selectByPrimaryKey(1);
        if (classse!=null){
            return ServerResponse.createBySuccess(1,classse);
        }else {
            return ServerResponse.createByErrorMessage("找不到班级");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Classse record) {
        Classse classse = new Classse();
        //更新操作必须要有id主关键字段
        classse.setId(record.getId());
        classse.setName(record.getName());
        classse.setMajorId(record.getMajorId());
        classse.setMajorName(record.getMajorName());
        classse.setStudentNumber(record.getStudentNumber());
        if(classseService.updateByPrimaryKeySelective(classse)>0){
            return ServerResponse.createBySuccess(0,classse);
        }else {
            return ServerResponse.createByErrorMessage("更新班级数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Classse record) {
        Classse classse = new Classse();
        //更新操作必须要有id主关键字段
        classse.setId(record.getId());
        classse.setName(record.getName());
        classse.setMajorId(record.getMajorId());
        classse.setMajorName(record.getMajorName());
        classse.setStudentNumber(record.getStudentNumber());
        if(classseService.updateByPrimaryKeySelective(classse)>0){
            return ServerResponse.createBySuccess(1,classse);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Classse> classseList=classseService.selectAll();
        System.out.println("ok");
        if(classseList.size()>0){
            return ServerResponse.createBySuccess(classseList.size(),classseList);
        }else{
            return ServerResponse.createByErrorMessage("找不到班级信息");
        }
    }
}