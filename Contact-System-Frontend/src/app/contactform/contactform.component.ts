import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-contactform',
  templateUrl: './contactform.component.html',
  styleUrls: ['./contactform.component.css']
})
export class ContactformComponent implements OnInit {

  url = "http://localhost:8080/api/v1/user/updatecontact";

  route: string | undefined;

  userName : string = "";
  nickName : string = "";
  userEmail : string = "";
  userMobile : string = "";
  userWork : string = "";

  cName : string = "";
  cNickName : string = "";
  cEmail : string = "";
  cMobile : string = "";
  cWork : string = "";

  idData : any ;

  constructor(private router: Router , private http: HttpClient , private activatedRoute: ActivatedRoute ) {
    this.route = router.url;
    this.activatedRoute.queryParams.subscribe(params => {
      this.idData = params['Conid'];
      console.log("Retrived Contact ID :- "+this.idData); // Print the parameter to the console.
  });
  }
  ngOnInit(): void {
    this.updateData();
  }

  updateData(){
    this.http.get(this.url+'/'+this.idData).subscribe((
      resultData: any)=>{
        console.log("Contact Details Based on Id : - "+resultData.mobile);
        this.cName = resultData.name ;
        this.cNickName = resultData.nickname ;
        this.cEmail = resultData.email;
        this.cMobile = resultData.mobile ;
        this.cWork=  resultData.work ;
      })
  }

  update(name:string,nickname:string,email:string,mobile:string,work:string)
  {
      this.userName = name ;
      this.nickName = nickname ;
      this.userEmail = email;
      this.userMobile = mobile ;
      this.userWork = work ;

      let bodyData = {
        "userName" : this.userName,
        "nickName":  this.nickName,
        "userEmail" : this.userEmail,
        "userMobile" : this.userMobile,
        "userWork" : this.userWork
      };
      this.http.post(this.url+'/'+this.idData,bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
      {
          console.log(resultData + this.userName);
          //console.log(this.email);
          alert("Contact Updated Successfully");
          this.router.navigateByUrl('/getcontact');

          this.userEmail = "";
          this.userName = "";
          this.nickName = "";
          this.userMobile = "";
          this.userWork = "";
      });
    }

    deleteData()
    {
      this.http.delete(this.url+'/'+this.idData,{responseType: 'text'}).subscribe((
        result:any)=>{

          alert("Contact Deleted Successfully");
          console.log(result);
          this.router.navigateByUrl('/getcontact');

        });
    }

}
