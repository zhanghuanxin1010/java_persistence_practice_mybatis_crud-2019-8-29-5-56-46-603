package tws.Service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Employee> getPage(int page,int pageSize) {
	   int offset=(page-1)*pageSize;
	   List<Employee>employsize=new ArrayList<Employee>();		   
	   employsize=employeeMapper.selectAll();
	   List<Employee>employsizePre=new ArrayList<Employee>();	
	   employsizePre=employsize.subList(offset,pageSize*page );
	  return employsizePre;
	}

	public List<Employee> selectAllName(String name) {
		 List<Employee>employName=new ArrayList<Employee>();		   
		 employName=employeeMapper.selectAllName(name);
		 return employName;
		// TODO Auto-generated method stub
		
	}
	
}
