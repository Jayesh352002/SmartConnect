import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {  Observable, throwError } from 'rxjs';
import { Root } from '../model/contacts.model';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-getcontacts',
  templateUrl: './getcontacts.component.html',
  styleUrls: ['./getcontacts.component.css']
})
export class GetcontactsComponent implements OnInit {

  route: string | undefined;

  public Contactdata:any = [];

  name:string="";

  mail:string="";

  constructor(private router: Router , private http: HttpClient , public nav: NavbarService ) {
    this.route = router.url;
  }
  ngOnInit(): void {
    /*
    this.getContacts().subscribe({
      next:(response)=>{
        console.log("Contacts Data : - "+response.name);
      }
    });*/

    //this.getUserName();

    this.nav.hide();

    this.getUserContacts();
  }

  getContacts(): Observable<Root>{
    return this.http.get<Root>("http://localhost:8080/api/v1/user/getcontact");

  }

  getUserContacts(){
    this.http.get("http://localhost:8080/api/v1/user/getcontact").subscribe((
      resultData: any)=>{
        this.Contactdata = resultData;
        console.log("Contact Details : - "+this.Contactdata);

        for(let con of this.Contactdata)
        {
          this.name = con.user.username;
        }
      });
  }

  edit(id:any){
    this.router.navigate(['/update'],{queryParams:{Conid:id}});
  }
}
