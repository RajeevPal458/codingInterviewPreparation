from pydantic import BaseModel, HttpUrl
from typing import Optional
from datetime import date

class Employee(BaseModel):
    id: int
    FIRST_NAME: str
    LAST_NAME: str
    EMAIL: str
    PHONE_NUMBER: str
    HIRE_DATE: date
    SALARY: float
    DEPARTMENT_ID: Optional[int] = None
    Image: Optional[HttpUrl] = None
    
    
    
    def __str__(self):
        return f"Employee(id={self.id}, name={self.FIRST_NAME} {self.LAST_NAME}, email={self.EMAIL})"   
    