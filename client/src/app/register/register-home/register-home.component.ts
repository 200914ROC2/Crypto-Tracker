import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-home',
  templateUrl: './register-home.component.html',
  styleUrls: ['./register-home.component.css']
})
export class RegisterHomeComponent implements OnInit {

  constructor() { }

  username = "";
  email = "";
  password = "";
  confirmPassword = "";

  setUsername(username: string) {
    this.username = username;
  }

  setEmail(email: string) {
    this.email = email;
  }

  setPassword(password: string) {
    this.password = password;
  }

  setConfirmPassword(confirmPassword: string) {
    this.confirmPassword = confirmPassword;
  }

  register() {
    const data = {
      username: this.username,
      email: this.email,
      password: this.password,
      confirmPassword: this.confirmPassword
    };
    console.log(data);
  }

  ngOnInit(): void {
  }

}
