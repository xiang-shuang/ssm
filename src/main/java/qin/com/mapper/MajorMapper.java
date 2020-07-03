package qin.com.mapper;

import qin.com.entity.Department;
import qin.com.entity.Major;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    List<Major> selectAll(); //查询所有单位的信息
}