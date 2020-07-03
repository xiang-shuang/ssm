package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Levels;
import qin.com.service.LevelsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/levels")
public class LevelsController {

    @Resource(name = "levelsServiceImpl")
    @Autowired
    private LevelsService levelsService;

    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(levelsService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除层次成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Levels record) { //层次的信息应该是由客户端传送过来
        Levels levels = new Levels();
        levels.setName(record.getName());

        if(levelsService.insert(levels)>0){
            return ServerResponse.createBySuccess(1,levels);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Levels record) {
        Levels levels = new Levels();
        levels.setName(record.getName());

        if(levelsService.insert(levels)>0){
            return ServerResponse.createBySuccess(1,levels);
        }else {
            return ServerResponse.createByErrorMessage("添加层次数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Levels levels = levelsService.selectByPrimaryKey(1);
        if (levels!=null){
            return ServerResponse.createBySuccess(1,levels);
        }else {
            return ServerResponse.createByErrorMessage("找不到层次");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Levels record) {
        System.out.println("update");
        Levels levels = new Levels();
        //更新操作必须要有id主关键字段
        levels.setId(record.getId());
        levels.setName(record.getName());

        if(levelsService.updateByPrimaryKeySelective(levels)>0){
            return ServerResponse.createBySuccess(0,levels);
        }else {
            return ServerResponse.createByErrorMessage("更新层次数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Levels record) {
        Levels levels = new Levels();
        levels.setId(record.getId());//更新操作必须要有id主关键字段
        levels.setName(record.getName());

        if(levelsService.updateByPrimaryKeySelective(levels)>0){
            return ServerResponse.createBySuccess(1,levels);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }


    

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Levels> levelsList=levelsService.selectAll();
        System.out.println("ok");
        if(levelsList.size()>0){
            return ServerResponse.createBySuccess(levelsList.size(),levelsList);
        }else{
            return ServerResponse.createByErrorMessage("找不到层次信息");
        }
    }

    


}