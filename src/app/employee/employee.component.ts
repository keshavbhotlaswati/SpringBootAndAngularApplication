import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { DataService } from '../data.service';
import { PageserviceService } from '../pageservice.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {


  employees: Employee[]=[];
  count=3;
  config: any;
  pager: any = {};

  // paged items
  pagedItems: any[]=[];
  constructor(private dataservice :DataService, private pagerService:PageserviceService) {
    
   }

  ngOnInit(): void {
 
    this.dataservice.getAllEmployees().subscribe(
      response =>this.handleSuccessfulResponse(response),

    );

  }



  handleSuccessfulResponse(response: Employee[])
  {
      this.employees=response;
      console.log("successfully  completed");
      console.log(this.employees.length);
      this.setPage(1);
      console.log(this.employees);
  }
  
  deleteEmployee(employee: Employee): void {
     this.dataservice.deleteEmployee(employee)
       .subscribe( () => {
        this.employees = this.employees.filter(u => u !== employee);
     })
  };
  

show(){
  if(this.pager.currentPage!=1){
    return true;
  }
  else{
    return false;
  }
}
 
  setPage(page: number) {
    if (page < 1 || page > this.pager.totalPages) {
        return;
    }

    // get pager object from service
    this.pager = this.pagerService.getPager(this.employees.length, page);

    // get current page of items
    this.pagedItems = this.employees.slice(this.pager.startIndex, this.pager.endIndex + 1);
}
}
