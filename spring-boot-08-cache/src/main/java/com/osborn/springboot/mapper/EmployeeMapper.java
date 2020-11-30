package com.osborn.springboot.mapper;

import com.osborn.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-14 7:13
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);

    @Update("UPDATE employee SET lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} WHERE id = #{id}")
    void updateEmp(Employee employee);

    @Insert("INSERT INTO employee(lastName, email, gender, d_id) VALUES(#{lastName}, #{email}, #{gender}, #{d_Id})")
    void insertEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmp(Integer id);
}
