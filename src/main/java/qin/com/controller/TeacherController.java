package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Teacher;
import qin.com.service.TeacherService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource(name = "teacherServiceImpl")
    @Autowired
    private TeacherService teacherService;

    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(teacherService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除教师成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Teacher record) { //教师的信息应该是由客户端传送过来
        Teacher teacher = new Teacher();
        teacher.setName(record.getName());
        teacher.setPhone(record.getPhone());
        teacher.setEmail(record.getEmail());
        teacher.setQq(record.getQq());
        teacher.setDepartId(record.getDepartId());
        if(teacherService.insert(teacher)>0){
            return ServerResponse.createBySuccess(1,teacher);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Teacher record) {
        Teacher teacher = new Teacher();
        teacher.setName(record.getName());
        teacher.setPhone(record.getPhone());
        teacher.setEmail(record.getEmail());
        teacher.setQq(record.getQq());
        teacher.setDepartId(record.getDepartId());
        if(teacherService.insert(teacher)>0){
            return ServerResponse.createBySuccess(1,teacher);
        }else {
            return ServerResponse.createByErrorMessage("添加教师数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Teacher teacher = teacherService.selectByPrimaryKey(1);
        if (teacher!=null){
            return ServerResponse.createBySuccess(1,teacher);
        }else {
            return ServerResponse.createByErrorMessage("找不到教师");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Teacher record) {
        System.out.println("update");
        Teacher teacher = new Teacher();
        //更新操作必须要有id主关键字段
        teacher.setId(record.getId());
        teacher.setName(record.getName());
        teacher.setPhone(record.getPhone());
        teacher.setEmail(record.getEmail());
        teacher.setQq(record.getQq());
        teacher.setDepartId(record.getDepartId());
        if(teacherService.updateByPrimaryKeySelective(teacher)>0){
            return ServerResponse.createBySuccess(0,teacher);
        }else {
            return ServerResponse.createByErrorMessage("更新教师数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Teacher record) {
        Teacher teacher = new Teacher();
        teacher.setId(record.getId());//更新操作必须要有id主关键字段
        teacher.setName(record.getName());
        teacher.setPhone(record.getPhone());
        teacher.setEmail(record.getEmail());
        teacher.setQq(record.getQq());
        teacher.setDepartId(record.getDepartId());
        if(teacherService.updateByPrimaryKeySelective(teacher)>0){
            return ServerResponse.createBySuccess(1,teacher);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }


    

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Teacher> teacherList=teacherService.selectAll();
        System.out.println("ok");
        if(teacherList.size()>0){
            return ServerResponse.createBySuccess(teacherList.size(),teacherList);
        }else{
            return ServerResponse.createByErrorMessage("找不到教师信息");
        }
    }

    


}