import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {  Observable, throwError } from 'rxjs';
import { Root } from '../model/contacts.model';

@Component({
  selector: 'app-getcontacts',
  templateUrl: './getcontacts.component.html',
  styleUrls: ['./getcontacts.component.css']
})
export class GetcontactsComponent implements OnInit {

  route: string | undefined;

  public Contactdata:any = []

  constructor(private router: Router , private http: HttpClient ) {
    this.route = router.url;
  }
  ngOnInit(): void {
    /*
    this.getContacts().subscribe({
      next:(response)=>{
        console.log("Contacts Data : - "+response.name);
      }
    });*/

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
      });
  }

  edit(id:any){
    this.router.navigate(['/update'],{queryParams:{Conid:id}});
  }
}
