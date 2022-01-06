import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  // private loginService:AuthenticationService;
  isUserLogged:boolean=false;

  constructor(private loginService:AuthenticationService) {
  //  this.loginService=loginService1;
   }


    isUserLoggedIn() :boolean{


return this.loginService.isUserLoggedIn();
   }
  ngOnInit(): void {

  }

}
