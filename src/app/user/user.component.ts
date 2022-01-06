import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  user1: User = new User( );
  constructor(private user_service:UserServiceService) { }

  ngOnInit(): void {



  }
  createUser(): void {
    this.user_service.createUser(this.user1).subscribe(

      data => {
        alert("User created successfully.");

      });
    }
}
