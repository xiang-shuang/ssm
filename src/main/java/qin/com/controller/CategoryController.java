package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;
import qin.com.entity.Category;
import qin.com.service.CategoryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource(name = "categoryServiceImpl")
    @Autowired
    private CategoryService categoryService;

    /*跳转到管理员的首页*/
    @RequestMapping("/index")
    public String index(){
        return "adminindex";

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {

        if(categoryService.deleteByPrimaryKey(id)>0){
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除教材成功");
        }else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Category record) { //教材的信息应该是由客户端传送过来
        Category category = new Category();
        category.setName(record.getName());

        if(categoryService.insert(category)>0){
            return ServerResponse.createBySuccess(1,category);
        }else {
            return ServerResponse.createByError();
        }

    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public ServerResponse insertSelective(Category record) {
        Category category = new Category();
        category.setName(record.getName());

        if(categoryService.insert(category)>0){
            return ServerResponse.createBySuccess(1,category);
        }else {
            return ServerResponse.createByErrorMessage("添加教材数据失败");
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) {
        Category category = categoryService.selectByPrimaryKey(1);
        if (category!=null){
            return ServerResponse.createBySuccess(1,category);
        }else {
            return ServerResponse.createByErrorMessage("找不到教材");
        }
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Category record) {
        System.out.println("update");
        Category category = new Category();
        //更新操作必须要有id主关键字段
        category.setId(record.getId());
        category.setName(record.getName());

        if(categoryService.updateByPrimaryKeySelective(category)>0){
            return ServerResponse.createBySuccess(0,category);
        }else {
            return ServerResponse.createByErrorMessage("更新教材数据失败");
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public ServerResponse updateByPrimaryKey(Category record) {
        Category category = new Category();
        category.setId(record.getId());//更新操作必须要有id主关键字段
        category.setName(record.getName());

        if(categoryService.updateByPrimaryKeySelective(category)>0){
            return ServerResponse.createBySuccess(1,category);
        }else {
            return ServerResponse.createByErrorMessage("更新管理数据失败");
        }
    }


    

    @RequestMapping("/listAll")
    @ResponseBody
    public ServerResponse listAll(HttpServletRequest request, HttpServletResponse response){
        List<Category> categoryList=categoryService.selectAll();
        System.out.println("ok");
        if(categoryList.size()>0){
            return ServerResponse.createBySuccess(categoryList.size(),categoryList);
        }else{
            return ServerResponse.createByErrorMessage("找不到教材信息");
        }
    }

    


}