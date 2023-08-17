import { Component , Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addcontact',
  templateUrl: './addcontact.component.html',
  styleUrls: ['./addcontact.component.css']
})
export class AddcontactComponent {

  userName : string = "";
  nickName : string = "";
  userEmail : string = "";
  userMobile : string = "";
  userWork : string = "";

  @Input()
  email:string="";

  @Input()
  userId:any=0;

  constructor(private http: HttpClient )
  {
  }


  save()
  {
    if(this.userName==="" || this.nickName==="" || this.userEmail==="" || this.userMobile==="" || this.userWork==="")
    {
      alert("Please Enter Valid Input !!");
    }
    else
    {
      let bodyData = {
        "userName" : this.userName,
        "nickName":  this.nickName,
        "userEmail" : this.userEmail,
        "userMobile" : this.userMobile,
        "userWork" : this.userWork
      };
      this.http.post("http://localhost:8080/api/v1/user/addcontact",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
      {
          console.log(resultData);
          console.log(this.email);
          alert("Contact Added Successfully");
          //this.router.navigateByUrl('/home');

          this.userEmail = "";
          this.userName = "";
          this.nickName = "";
          this.userMobile = "";
          this.userWork = "";
      });
    }
  }
}
