import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-contactnavbar',
  templateUrl: './contactnavbar.component.html',
  styleUrls: ['./contactnavbar.component.css']
})
export class ContactnavbarComponent {

  @Input() username: any;
}
