package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
   

	Employee selectOne(@Param("id") String id) ;

	List<Employee> selectAll();

	
	void insert(@Param("employee")Employee employee );

	void updateOne(@Param("id")String id, @Param("employee")Employee employee);

	void deleteOne(@Param("id")String id);
}
