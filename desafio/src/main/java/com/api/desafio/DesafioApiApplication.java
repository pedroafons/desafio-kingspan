package com.api.desafio;

import com.api.desafio.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/employees")
public class DesafioApiApplication {

	private final EmployeeRepository employeeRepository;

	public DesafioApiApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiApplication.class, args);
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping
	public void addEmployee(@RequestBody NewEmployeeRequest request) {
		Employee employee = new Employee();
		employee.setName(request.name);
		employee.setOffice(request.office);
		employee.setSalary(request.salary);
		employeeRepository.save(employee);
	}

	@PutMapping ("{employeeId}")
	public void updateEmployee(@PathVariable("employeeId") Integer id,
							   @RequestBody NewEmployeeRequest employee) {
		Employee updateEmployee = employeeRepository.findById(id).orElseThrow();
		updateEmployee.setName(employee.name);
		updateEmployee.setOffice(employee.office);
		updateEmployee.setSalary(employee.salary);
		employeeRepository.save(updateEmployee);
	}

	@DeleteMapping ("{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Integer id) {
		employeeRepository.deleteById(id);
	}

}
