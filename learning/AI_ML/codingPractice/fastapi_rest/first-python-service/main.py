from  controllers.employee_controller import EmployeeController
from services.employee_service import EmployeeService
from repositories.employee_repository import EmployeeRepository
from fastapi import FastAPI, APIRouter

employeeController = EmployeeController(
    employee_service=EmployeeService(employeeRepository = EmployeeRepository()),
    router=APIRouter()
)

app = FastAPI()
# Include the employee controller routes
app.include_router(employeeController.router, prefix="/api/v1", tags=["employees"])
@app.get("/")
async def root():
    return {"message": "Welcome to the Employee Management API!"}

@app.get("/health")
async def health_check():
    return {"status": "OK", "message": "Service is running smoothly!"}

@app.get("/version")
async def version():
    return {"version": "1.0.0", "description": "Employee Management API Version 1.0.0"}


