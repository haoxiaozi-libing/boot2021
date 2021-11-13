package com.libing.mapper.services;

import com.libing.mapper.entities.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvlibing
 * @create 2021-10-27 21:58
 */
public class EmployeeServiceTest {

    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeService employeeService = iocContainer.getBean(EmployeeService.class);

    @Test
    public void testSelectOne() {

        //1.创建封装查询条件的实体类对象
        Employee employeeQueryCondition = new Employee(null, "bob", 5560.11, null);

        //2.执行查询
        Employee employeeQueryResult = employeeService.getOne(employeeQueryCondition);

        //3.打印
        System.out.println(employeeQueryResult);
    }



    @Test
    public void testSelectId() {

        //1.创建封装查询条件的实体类对象
        Employee employeeQueryCondition = new Employee(null, "bob", 5560.11, null);

        //2.执行查询
         employeeService.saveEmployee(employeeQueryCondition);
        Integer empId = employeeQueryCondition.getEmpId();

        //3.打印
        System.out.println(empId);
    }
}