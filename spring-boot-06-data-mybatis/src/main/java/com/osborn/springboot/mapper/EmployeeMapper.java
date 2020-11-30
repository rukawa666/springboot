package com.osborn.springboot.mapper;

import com.osborn.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 6:51
 */
@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmp(Integer id);
}
