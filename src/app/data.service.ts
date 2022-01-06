import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './model/employee';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})


export class DataService {
constructor(private httpClient:HttpClient) {


   }


  public  getAllEmployees()
  {
    console.log("test call");
    return this.httpClient.get<Employee[]>('http://localhost:8080/employees');
  }

  public deleteEmployee(employee:Employee) {
    return this.httpClient.delete<Employee>("http://localhost:8080/delemployees" + "/"+ employee.id);
  }

  public createEmployee(employee:Employee) {
    return this.httpClient.post<Employee>("http://localhost:8080/employees", employee);
  }


  public getEmployeeById(id:number) {

    let getHeaders:HttpHeaders=new HttpHeaders({
      'Accept': 'application/json',
      // 'Authorization' :' my-token'
      
      
        });
      
        return this.httpClient.get<Employee>(`http://localhost:8080/employees/${id}`,{
      
          headers:getHeaders 
        });


  }

  
public updateEmployee(updatedEmployee:Employee){

  return this.httpClient.put<Employee>(`http://localhost:8080/employees/${updatedEmployee.id}`,updatedEmployee ,{


  headers:new HttpHeaders({
    'Content-Type':'application/json'
  })
  });
  
}}
