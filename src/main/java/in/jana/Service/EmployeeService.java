package in.jana.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jana.Model.Employee;
import in.jana.Repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo emprepo;

	public List<Employee> getallaemployees() {
		return emprepo.findAll();
	}

	public Optional<Employee> getEmployeeById(Integer id) {
		return emprepo.findById(id);
	}

	public Employee saveEmployee(Employee employee) {
		return emprepo.save(employee);
	}

	public void deleteEmployee(Integer id) {

		emprepo.deleteById(id);
	}

}
