package com.learn.issuetracker.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learn.issuetracker.model.Employee;

/*
 * This class is used to read employees data from the file and store the data in a List.
 * Java 8 NIO should be used to read the file data in to streams 
 */
public class EmployeeRepository {

	/*
	 * This List will store the employee details read from the file
	 */
	private static List<Employee> employees;

	/*
	 * This static block should populate the 'employees' List by calling the static
	 * method 'initializeEmployeesFromFile' of this class. The path of the
	 * employees.csv file is "src --> data -> employees.csv"
	 */
	static {

		Path path = Paths.get("src", "data", "employees.csv");
		initializeEmployeesFromFile(path);
	}

	/*
	 * This method is used to read from the file given in the input Path parameter.
	 * It should store all the records read from the file in to 'employees' member
	 * variable. This method should use 'parseEmployee' method of Utility class for
	 * converting the line read from the file in to Employee Object
	 */
	public static void initializeEmployeesFromFile(Path employeesfilePath) {

		try(Stream<String> fileData = Files.newBufferedReader(employeesfilePath).lines()){	

			employees = fileData.map(Utility :: parseEmployee)
					.collect(Collectors.toList());

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * getEmployee method should search the 'employees' List based on the input
	 * employee Id, and return the employee found, in an Optional<Employee> object
	 */
	public static Optional<Employee> getEmployee(int empId) {

		Optional<Employee> empty = Optional.empty();

		/*List<Employee> newEmpList = employees.stream().filter(p -> p.getEmplId() == empId).collect(Collectors.toList());
		if(null != newEmpList || newEmpList.size() > 0) {
			return  Optional.ofNullable(newEmpList.get(0));
		}else {
			return null;
		}*/

		Optional<Employee> optionalEmployee = employees.stream().filter(p -> p.getEmplId() == empId).findFirst();

		if(optionalEmployee.isPresent()) {
			return optionalEmployee;
		}else {
			return empty;
		}

	}

	// Getter
	public static List<Employee> getEmployees() {
		return employees;
	}
}