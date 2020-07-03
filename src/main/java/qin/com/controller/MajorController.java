package qin.com.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Major;
import qin.com.service.MajorService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {

    @Resource(name = "majorServiceImpl")
    @Autowired
    private MajorService majorService;

    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(majorService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除专业成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Major record) { //专业的信息应该是由客户端传送过来
        Major major = new Major();
        major.setName(record.getName());

        if(majorService.insert(major)>0){
            return ServerResponse.createBySuccess(1,major);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Major record) {
        Major major = new Major();
        major.setName(record.getName());

        if(majorService.insert(major)>0){
            return ServerResponse.createBySuccess(1,major);
        }else {
            return ServerResponse.createByErrorMessage("添加专业数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Major major = majorService.selectByPrimaryKey(1);
        if (major!=null){
            return ServerResponse.createBySuccess(1,major);
        }else {
            return ServerResponse.createByErrorMessage("找不到专业");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Major record) {
        System.out.println("update");
        Major major = new Major();
        //更新操作必须要有id主关键字段
        major.setId(record.getId());
        major.setName(record.getName());

        if(majorService.updateByPrimaryKeySelective(major)>0){
            return ServerResponse.createBySuccess(0,major);
        }else {
            return ServerResponse.createByErrorMessage("更新专业数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Major record) {
        Major major = new Major();
        major.setId(record.getId());//更新操作必须要有id主关键字段
        major.setName(record.getName());

        if(majorService.updateByPrimaryKeySelective(major)>0){
            return ServerResponse.createBySuccess(1,major);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }


    

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Major> majorList=majorService.selectAll();
        System.out.println("ok");
        if(majorList.size()>0){
            return ServerResponse.createBySuccess(majorList.size(),majorList);
        }else{
            return ServerResponse.createByErrorMessage("找不到专业信息");
        }
    }

    


}