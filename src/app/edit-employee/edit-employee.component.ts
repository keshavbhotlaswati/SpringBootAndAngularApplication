import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  
  
  selectedEmployee: Employee = new Employee;

  constructor(private route: ActivatedRoute,private dataservice:DataService) {


   }

  ngOnInit(): void {

let employeeId: number=parseInt(this.route.snapshot.params['id']);
this.dataservice.getEmployeeById(employeeId).subscribe(
  (data)=> this.selectedEmployee=<Employee> data,(err)=>console.log(err)
)

  }

  saveChanges():void{
this.dataservice.updateEmployee( this.selectedEmployee ).subscribe(

  ()=>console.log(`${this.selectedEmployee.name} updated successfully`),
  (err:any)=>console.log(err)
);
  }

  

}
