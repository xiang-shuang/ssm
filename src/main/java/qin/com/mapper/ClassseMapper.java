package qin.com.mapper;

import qin.com.entity.Classse;
import qin.com.entity.Department;

import java.util.List;

public interface ClassseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classse record);

    int insertSelective(Classse record);

    Classse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classse record);

    int updateByPrimaryKey(Classse record);

    List<Classse> selectAll(); //查询所有单位的信息
}