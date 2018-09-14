import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from '../../shared/constants/configuration';
import { HttpRequestService } from '../../shared/services/http-request.service';

@Injectable()
export class AddOrderService {
    constructor(private _httpService: HttpRequestService, private _router: Router) { }

    public addAnOrder(order, successcallback) {
        let responseObject: any;
        const payload = {

            orderDate: new Date(),
            orderDetail: order.orderDetail,
            quantity: order.quantity,
            quantityUnit: order.quantityUnit,
            userId: order.userId
        };
        this._httpService.postRequest(Config.getEnvironmentVariable('saveorder'), payload)
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
}