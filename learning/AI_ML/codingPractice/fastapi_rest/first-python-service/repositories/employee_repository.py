# class EmployeeRepository:
#     def __init__(self, db):
#         self.db = db

#     async def get_employee(self, employee_id: int):
#         query = "SELECT * FROM employees WHERE id = :id"
#         result = await self.db.fetch_one(query=query, values={"id": employee_id})
#         return result

#     async def create_employee(self, employee_data: dict):
#         query = "INSERT INTO employees (name, position) VALUES (:name, :position)"
#         await self.db.execute(query=query, values=employee_data)
#         return {"status": "Employee created successfully"}


from repositories.employees_data import EmployeesDataUploader
from model.employee import Employee

class EmployeeRepository:
    # declare a varriable to hold list of employees and also add the Employee type 
    
    def __init__(self):
        self.employeesDataUploader = EmployeesDataUploader()
        self.employeesDataUploader.upload_json_data()


    async def get_all_employees(self):
        return self.employeesDataUploader.get_employees()

    async def get_employee(self, employee_id: int):
        try:
            result =  list(filter(lambda emp: emp.id==employee_id ,self.employeesDataUploader.get_employees()))
            if result:
                result = result[0]
            print(f"Employee with ID {employee_id}: {result}")
        except Exception as e:
            print(f"Error fetching employee with ID {employee_id}: {e}")
            result = Employee()
            
        return result

    async def create_employee(self, employee_data: Employee):
        employees = self.employeesDataUploader.get_employees()
        print(f"Current employees: {employees}")
        employees.append(employee_data)
        return {"status": "Employee created successfully"}
    
    async def update_employee(self, employee_id: int, employee_data: Employee):
        for index, emp in enumerate(self.employeesDataUploader.get_employees()):
            if emp.id == employee_id:
                self.employeesDataUploader.get_employees()[index] = employee_data
                return {"status": "Employee updated successfully"}
        return {"status": "Employee not found"}
    
    async def delete_employee(self, employee_id: int):
        self.employeesDataUploader.set_employees(list(filter(lambda emp: emp.id != employee_id, self.employeesDataUploader.get_employees())))
        return {"status": "Employee deleted successfully"}
    
