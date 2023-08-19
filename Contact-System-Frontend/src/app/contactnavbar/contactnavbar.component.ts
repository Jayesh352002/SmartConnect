import { Component, Input, OnInit } from '@angular/core';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-contactnavbar',
  templateUrl: './contactnavbar.component.html',
  styleUrls: ['./contactnavbar.component.css']
})
export class ContactnavbarComponent implements OnInit {

  @Input() username: any;

  constructor(public nav: NavbarService){

  }
  ngOnInit(): void {

  }

  show(){
    this.nav.toggle();
  }
}
