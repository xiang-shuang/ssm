package qin.com.service;

import qin.com.entity.Department;

import java.util.List;

public interface DepartmentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAll(); //查询所有单位的信息
}