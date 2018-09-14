import { Component } from '@angular/core';
import { Router } from '../../node_modules/@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  loginlogout = localStorage.getItem('loggedin') === null ? 'Login' : 'Logout';

  constructor(private router: Router) { }

  logout() {
    localStorage.removeItem('loggedin');
    this.router.navigate(['']);
  }
}
