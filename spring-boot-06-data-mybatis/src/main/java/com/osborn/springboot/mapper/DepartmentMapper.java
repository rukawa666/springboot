package com.osborn.springboot.mapper;

import com.osborn.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-12 23:28
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}
