import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './model/User';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient:HttpClient) { }


  public  getAllUser()
  {
    console.log("test call");
    return this.httpClient.get<User[]>('http://localhost:8080/User');
  }

  
  public createUser(user:User) {
    return this.httpClient.post<User>("http://localhost:8080/user", user);
  }


  public getUserById(userid:number) {

    let getHeaders:HttpHeaders=new HttpHeaders({
      'Accept': 'application/json',
      // 'Authorization' :' my-token'
      
      
        });
      
        return this.httpClient.get<User>(`http://localhost:8080/user/${userid}`,{
      
          headers:getHeaders 
        });


  }
  public getUserByUsername(username:string) {

    let getHeaders:HttpHeaders=new HttpHeaders({
      'Accept': 'application/json',
      // 'Authorization' :' my-token'
      
      
        });
      
        return this.httpClient.get<User>(`http://localhost:8080/user/username/${username}`,{
      
          headers:getHeaders 
        });


  }


  

  
}


