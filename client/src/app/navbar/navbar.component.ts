import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @Input() user = null;
  @Input() logout = null;

  constructor(private router: Router) { }

  handleLogout() {
    this.logout();
    this.router.navigateByUrl('');
  }

  ngOnInit(): void {
  }

}
