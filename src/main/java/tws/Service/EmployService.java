package tws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tws.entity.Employee;
import tws.entity.EmployeeDTO;
import tws.repository.EmployeeMapper;

public class EmployService {
	@Autowired
	private EmployeeMapper employeeMapper;
	//@GetMapping("/{id}")
	public EmployeeDTO getdesc(@PathVariable String id) {
		Employee employee=employeeMapper.selectOne(id);
		String desc="name: "+employee.getName()+"age: "+employee.getAge();
		
		EmployeeDTO employees=new EmployeeDTO(employee,desc);
		
		return employees;
	}
	
}
