import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-home',
  templateUrl: './login-home.component.html',
  styleUrls: ['./login-home.component.css']
})
export class LoginHomeComponent implements OnInit {

  @Input() loggedIn;

  constructor(private router: Router) { }

  username = "";
  password = "";

  setUsername(username: string) {
    this.username = username;
  }

  setPassword(password: string) {
    this.password = password;
  }

  login() {
    // const data = {
    //   username: this.username,
    //   password: this.password
    // };
    this.loggedIn = true;
    this.router.navigateByUrl('');
  }

  ngOnInit(): void {
  }

}
