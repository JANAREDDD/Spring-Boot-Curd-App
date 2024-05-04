package in.jana.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jana.Model.Employee;
import in.jana.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@GetMapping("/")
	public List<Employee> getAllEmployees() {
		return empservice.getallaemployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeid(@PathVariable Integer id) {
		return empservice.getEmployeeById(id).orElseThrow(() -> new RuntimeException("Employee  not found with id:"));

	}

	@PostMapping("/")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empservice.saveEmployee(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
		Employee employee = empservice.getEmployeeById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

		employee.setId(employeeDetails.getId());
		employee.setName(employeeDetails.getName());
		employee.setName(employeeDetails.getEmail());
		employee.setPhoneno(employeeDetails.getPhoneno());

		return empservice.saveEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		empservice.deleteEmployee(id);

	}

}
