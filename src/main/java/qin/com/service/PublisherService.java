package qin.com.service;

import qin.com.entity.Department;
import qin.com.entity.Publisher;

import java.util.List;

public interface PublisherService {
    int deleteByPrimaryKey(Integer id);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    Publisher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);

    List<Publisher> selectAll(); //查询所有单位的信息
}