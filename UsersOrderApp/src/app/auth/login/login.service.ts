import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from '../../shared/constants/configuration';
import { HttpRequestService } from '../../shared/services/http-request.service';

@Injectable()
export class LoginService {

    constructor(private _httpService: HttpRequestService, private _router: Router) { }

    public getAllUsers(user,successcallback) {
        let responseObject: any;
        const payload = {
            username: user.username,
            password: user.password

        };
        // this._httpService.getRequest(Config.getEnvironmentVariable('finduser')+ userId, successcallback);
        console.log(Config.getEnvironmentVariable('finduser'));
        this._httpService.postRequest(Config.getEnvironmentVariable('finduser'), payload)
            .subscribe(
                (data) => {
                    responseObject = data;
                    successcallback(responseObject);
                },
                (error) => console.log('err'),
                () => {
                    console.log('success jai getAllPRoductsByCate');
                }
            );
    }

    public getUserByname(){

    }

}
