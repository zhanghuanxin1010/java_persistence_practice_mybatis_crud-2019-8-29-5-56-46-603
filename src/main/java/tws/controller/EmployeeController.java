package tws.controller;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tws.Service.EmployService;
import tws.entity.Employee;
import tws.entity.EmployeeDTO;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;

	@GetMapping("")
	public ResponseEntity<List<Employee>> getAll(@RequestParam(required = false) int page,
			@RequestParam(required = false) int pageSize) {
		EmployService employSizeServic = new EmployService();
		return ResponseEntity.ok(employSizeServic.getPage(page, pageSize));
	}

	@GetMapping("/{name}")
	public ResponseEntity<List<Employee>> getAllName(@PathVariable String name) {

		EmployService employNameServic = new EmployService();
		/* employNameServic.selectAll(name); */

		return ResponseEntity.ok(employNameServic.selectAllName(name));
	}

	@PostMapping("")
	public ResponseEntity<List<Employee>> insert(@RequestBody Employee employee) {
		String id = UUID.randomUUID().toString();
		employee.setId(id);
		employeeMapper.insert(employee);
		return ResponseEntity.created(URI.create("/employees" + id)).build();
	}

	/*
	 * @GetMapping("/{id}") public ResponseEntity<Employee> getOne(@PathVariable
	 * String id) { Employee employee=employeeMapper.selectOne(id);
	 * 
	 * return ResponseEntity.ok(employee); }
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateOne(@PathVariable String id, @RequestBody Employee employee) {
		employeeMapper.updateOne(id, employee);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteOne(@PathVariable String id) {
		employeeMapper.deleteOne(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getdescService(@PathVariable String id) {
		EmployService employServic = new EmployService();
		EmployeeDTO employees = employServic.getdesc(id);
		return ResponseEntity.ok(employees);
	}

}
