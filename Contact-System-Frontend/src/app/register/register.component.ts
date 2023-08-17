import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  userName : string = "";
  username : string = "";
  userEmail : string = "";
  userPassword : string = "";

  userId : any = 0 ;

  route: string | undefined;

  constructor(private http: HttpClient , private router : Router )
  {
    this.route = router.url;
  }

  save()
  {
    if(this.userName==="" || this.username==="" || this.userEmail==="" || this.userPassword==="")
    {
      alert("Please Enter Valid Input !!");
    }
    else
    {
      let bodyData = {
        "userName" : this.userName,
        "userEmail" : this.userEmail,
        "username":  this.username,
        "userPassword" : this.userPassword
      };
      this.http.post("http://localhost:8080/api/v1/user/saveuser",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
      {
          console.log(resultData);
          alert("User Registered Successfully");
          //this.router.navigateByUrl('/register/addcontact');

          //this.userEmail = "";
          this.userName = "";
          this.username = "";
          this.userPassword = "";
          this.userId = resultData ;

          //this.router.navigate(['/login'],{queryParams:{id:this.userId}});
          this.router.navigate(['/login']);
      });
    }
  }
}
