import { OnInit } from '@angular/core';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  user = "User";
  loggedIn = false;
  
  logout() {
    this.user = "User";
  }

  ngOnInit() {
    
  }
}
