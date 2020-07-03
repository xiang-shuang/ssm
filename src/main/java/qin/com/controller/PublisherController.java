package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Publisher;
import qin.com.service.PublisherService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Resource(name = "publisherServiceImpl")
    @Autowired
    private PublisherService publisherService;

    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(publisherService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除出版设信息成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Publisher record) { //出版设信息的信息应该是由客户端传送过来
        Publisher publisher = new Publisher();
        publisher.setName(record.getName());

        if(publisherService.insert(publisher)>0){
            return ServerResponse.createBySuccess(1,publisher);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Publisher record) {
        Publisher publisher = new Publisher();
        publisher.setName(record.getName());

        if(publisherService.insert(publisher)>0){
            return ServerResponse.createBySuccess(1,publisher);
        }else {
            return ServerResponse.createByErrorMessage("添加出版设信息数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Publisher publisher = publisherService.selectByPrimaryKey(1);
        if (publisher!=null){
            return ServerResponse.createBySuccess(1,publisher);
        }else {
            return ServerResponse.createByErrorMessage("找不到出版设信息");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Publisher record) {
        System.out.println("update");
        Publisher publisher = new Publisher();
        //更新操作必须要有id主关键字段
        publisher.setId(record.getId());
        publisher.setName(record.getName());

        if(publisherService.updateByPrimaryKeySelective(publisher)>0){
            return ServerResponse.createBySuccess(0,publisher);
        }else {
            return ServerResponse.createByErrorMessage("更新出版设信息数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Publisher record) {
        Publisher publisher = new Publisher();
        publisher.setId(record.getId());//更新操作必须要有id主关键字段
        publisher.setName(record.getName());

        if(publisherService.updateByPrimaryKeySelective(publisher)>0){
            return ServerResponse.createBySuccess(1,publisher);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }


    

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Publisher> publisherList=publisherService.selectAll();
        System.out.println("ok");
        if(publisherList.size()>0){
            return ServerResponse.createBySuccess(publisherList.size(),publisherList);
        }else{
            return ServerResponse.createByErrorMessage("找不到出版设信息信息");
        }
    }

    


}