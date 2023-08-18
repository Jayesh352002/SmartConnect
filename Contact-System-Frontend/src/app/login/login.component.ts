import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userEmail:string="";
  userPassword:string="";

  route: string | undefined;

  constructor(private router: Router , private http: HttpClient ) {
    this.route = router.url;
  }

  loginUser(){

    if(this.userEmail === "" || this.userPassword=== ""){
      alert("Please Enter Valid Input !!");
    }
    else{
      let bodyData = {
        "userEmail": this.userEmail,
        "userPassword": this.userPassword,
      };

      this.http.post("http://localhost:8080/api/v1/user/loginusers",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
      {
        console.log(resultData);
        if (resultData == "Email Does Not Exists")
        {
          alert("Email not exits");
          this.userEmail = "";
          this.userPassword = "";

        }
        else if(resultData == this.userEmail)
        {
          alert("Login Successfull");
          this.router.navigate(['/getcontact']);
          this.userEmail = "";
          this.userPassword = "";
        }
        else
        {
          alert("Incorrect Email and Password not match");
          this.userEmail = "";
          this.userPassword = "";

        }
      });
    }
  }
}
