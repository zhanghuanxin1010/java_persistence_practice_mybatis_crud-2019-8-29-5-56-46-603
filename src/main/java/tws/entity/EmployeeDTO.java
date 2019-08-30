package tws.entity;

public class EmployeeDTO {
	Employee employee=new Employee();
	private String desc;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public EmployeeDTO(Employee employee, String desc) {
		super();
		this.employee = employee;
		this.desc = desc;
	}
	
	    
}
