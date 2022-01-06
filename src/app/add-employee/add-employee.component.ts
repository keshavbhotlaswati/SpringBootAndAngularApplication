import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user: Employee = new Employee( );

  constructor(private dataservice:DataService ,private router: Router) { }

  ngOnInit(): void {
  }

  createEmployee(): void {
    this.dataservice.createEmployee(this.user).subscribe(

      data => {
        alert("Employee created successfully.");

      })

  };


}
