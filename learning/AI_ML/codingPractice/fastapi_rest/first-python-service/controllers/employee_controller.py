from services.employee_service import EmployeeService
from fastapi import FastAPI, APIRouter, HTTPException
from model.employee import Employee


class EmployeeController:
    def __init__(self, employee_service: EmployeeService, router: APIRouter):
        self.router = router
        self.employee_service = employee_service
        self.setup_routes()

    def setup_routes(self):

        @self.router.get(
            "/employees",
            response_model=list[Employee],
            summary="Get all employees",
            description="Returns a list of all employees from the database.",
        )
        async def get_all_employees():
            return await self.employee_service.get_all_employees()

        @self.router.get(
            "/employees/{employee_id}",
            response_model=Employee,
            summary="Get an employee by ID",
            description="Returns the employee details for a given employee ID.",
        )
        async def get_employee_by_id(employee_id: int):
            return await self.employee_service.get_employee_by_id(employee_id)

        @self.router.post(
            "/employees",
            response_model=dict,
            summary="Create a new employee",
            description="Creates a new employee with the provided data.",
        )
        async def create_employee(employee_data: Employee):
            return await self.employee_service.create_employee(employee_data)

        @self.router.put(
            "/employees/{employee_id}",
            response_model=dict,
            summary="Update employee data",
            description="Updates an existing employee's data based on the employee ID.",
        )
        async def update_employee(employee_id: int, employee_data: Employee):
            return await self.employee_service.update_employee(
                employee_id, employee_data
            )

        @self.router.delete(
            "/employees/{employee_id}",
            response_model=dict,
            summary="Delete an employee",
            description="Deletes the employee with the specified ID.",
        )
        async def delete_employee(employee_id: int):
            return await self.employee_service.delete_employee(employee_id)
