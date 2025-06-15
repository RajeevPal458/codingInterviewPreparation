
from repositories.employee_repository import EmployeeRepository

class EmployeeService:
    def __init__(self, employeeRepository: EmployeeRepository):
        self.employeeRepository = employeeRepository

    def get_all_employees(self):
        return self.employeeRepository.get_all_employees()

    def get_employee_by_id(self, employee_id):
        return self.employeeRepository.get_employee(employee_id)

    def create_employee(self, employee_data):
        return self.employeeRepository.create_employee(employee_data)

    def update_employee(self, employee_id, employee_data):
        return self.employeeRepository.update_employee(employee_id, employee_data)

    def delete_employee(self, employee_id):
        return self.employeeRepository.delete_employee(employee_id)