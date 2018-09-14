import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '../../../../node_modules/@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private _loginservice: LoginService, private route: ActivatedRoute) { }
  user = {
    username: '',
    password: ''
  }
  ngOnInit() {
  }

  onSubmit(form) {
    this.user.username = form.value.email;
    this.user.password = form.value.password;
    console.log(form.value);
    const successcallback = (data) => {
      console.log(data);
      if (data === true) {
        localStorage.setItem('loggedin', this.user.username);
        this.router.navigate(['dashboard']);
      }
    };
    this._loginservice.getAllUsers(this.user, successcallback);
  }
}
