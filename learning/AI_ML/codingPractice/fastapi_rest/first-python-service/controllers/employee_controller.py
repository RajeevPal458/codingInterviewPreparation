# controllers/employee_controller.py

from fastapi import APIRouter, Depends, HTTPException
from model.employee import Employee
from services.employee_service import EmployeeService
from repositories.employee_repository import EmployeeRepository

employee_router = APIRouter()

# --- Dependency resolver ---
def get_employee_service() -> EmployeeService:
    return EmployeeService(employee_repository=EmployeeRepository())


@employee_router.get(
    "/employees",
    response_model=list[Employee],
    summary="Get all employees",
    description="Returns a list of all employees from the database.",
)
async def get_all_employees(service: EmployeeService = Depends(get_employee_service)):
    return await service.get_all_employees()


@employee_router.get(
    "/employees/{employee_id}",
    response_model=Employee,
    summary="Get an employee by ID",
    description="Returns the employee details for a given employee ID.",
)
async def get_employee_by_id(
    employee_id: int, service: EmployeeService = Depends(get_employee_service)
):
    return await service.get_employee_by_id(employee_id)


@employee_router.post(
    "/employees",
    response_model=dict,
    summary="Create a new employee",
    description="Creates a new employee with the provided data.",
)
async def create_employee(
    employee_data: Employee, service: EmployeeService = Depends(get_employee_service)
):
    return await service.create_employee(employee_data)


@employee_router.put(
    "/employees/{employee_id}",
    response_model=dict,
    summary="Update employee data",
    description="Updates an existing employee's data based on the employee ID.",
)
async def update_employee(
    employee_id: int,
    employee_data: Employee,
    service: EmployeeService = Depends(get_employee_service),
):
    return await service.update_employee(employee_id, employee_data)


@employee_router.delete(
    "/employees/{employee_id}",
    response_model=dict,
    summary="Delete an employee",
    description="Deletes the employee with the specified ID.",
)
async def delete_employee(
    employee_id: int, service: EmployeeService = Depends(get_employee_service)
):
    return await service.delete_employee(employee_id)
