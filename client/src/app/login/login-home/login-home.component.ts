import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-home',
  templateUrl: './login-home.component.html',
  styleUrls: ['./login-home.component.css']
})
export class LoginHomeComponent implements OnInit {

  constructor() { }

  username = "";
  password = "";

  setUsername(username: string) {
    this.username = username;
  }

  setPassword(password: string) {
    this.password = password;
  }

  login() {
    const data = {
      username: this.username,
      password: this.password
    };
    console.log(data);
  }

  ngOnInit(): void {
  }

}
