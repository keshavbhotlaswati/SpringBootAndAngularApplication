import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { DataService } from '../data.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {


  employees: Employee[] = [];
  constructor(private dataservice :DataService) { }

  ngOnInit(): void {
    this.dataservice.getAllEmployees().subscribe(
      response =>this.handleSuccessfulResponse(response),

    );

  }



  handleSuccessfulResponse(response: Employee[])
  {
      this.employees=response;
      console.log("successfully  completed");
      console.log(this.employees);
  }
  
  deleteEmployee(employee: Employee): void {
     this.dataservice.deleteEmployee(employee)
       .subscribe( data => {
        this.employees = this.employees.filter(u => u !== employee);
     })
  };
  

}
