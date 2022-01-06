import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './model/User';
import { UserServiceService } from './user-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
 user: User | undefined 
  user1: User[]=[];
  password: User |undefined;

  constructor(private user_service:UserServiceService) { 
   

  }
 
  authenticate(username: string, password: string,users:User[]) {
   
this.user1=users;

this.user=this.user1.find(x=>x.username===username);
console.log("user name" + JSON.stringify(this.user));
this.password=this.user1.find(x=>x.password===password);
if(this.user!=undefined && this.user!=null  && this.password!=null && this.password!=undefined){
  localStorage.setItem('username', username);
     return true;
  } else {
    return false;


  }
  }



  isUserLoggedIn() {
    let user = localStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    localStorage.removeItem('username');
    
   

  }
}
