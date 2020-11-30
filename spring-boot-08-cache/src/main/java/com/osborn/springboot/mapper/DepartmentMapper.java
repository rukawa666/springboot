package com.osborn.springboot.mapper;

import com.osborn.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-14 7:13
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);
}
