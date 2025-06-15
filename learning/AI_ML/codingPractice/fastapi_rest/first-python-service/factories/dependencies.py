# dependencies/di.py
from services.employee_service import EmployeeService
from repositories.employee_repository import EmployeeRepository
from functools import lru_cache

@lru_cache()
def get_employee_service() -> EmployeeService:
    return EmployeeService(employeeRepository=EmployeeRepository())
# This function is decorated with lru_cache to cache the instance of EmployeeService,
# ensuring that the same instance is reused across requests, which can improve performance

