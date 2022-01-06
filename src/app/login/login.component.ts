import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false
  users:User[]=[]
  
  constructor(private router: Router,
    private loginservice: AuthenticationService,private user_service:UserServiceService) { }

  ngOnInit(): void {
    this.user_service.getAllUser().subscribe(
      (response)=>this.handleSuccessfulResponse(response),
      (err)=>console.log("error in loading users"));

       

  }

  
  handleSuccessfulResponse(response: User[])
  {
      this.users=response;
      console.log("successfully  completed");
      console.log(this.users);
  }
  checkLogin() {
    if (this.loginservice.authenticate(this.username, this.password,this.users)
    ) {
      this.router.navigateByUrl('/employee');
      this.invalidLogin = false;
    } else{
      this.invalidLogin = true;
      alert("username or password is wrong .kindly register")
      this.router.navigateByUrl('/user');
  }
  }
}
