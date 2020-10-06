import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  // @Input() user = null;
  // @Input() logout = null;

  constructor(private router: Router, public userService: UserService) { }

  handleLogout() {
    this.userService.user = null;
    this.router.navigateByUrl('');
  }

  ngOnInit(): void {
  }

}
