import { Component, OnInit } from '@angular/core';
import { AddOrderService } from './addorder.component.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-addorder',
  templateUrl: './addorder.component.html',
  styleUrls: ['./addorder.component.css'],
  providers: [AddOrderService]
})
export class AddorderComponent implements OnInit {

  constructor(private router: Router, private _addorderservice: AddOrderService) { }
  orderdetails = {
    orderDetail: '',
    quantity: '',
    quantityUnit: '',
    userId: ''
  };
  ngOnInit() {
  }
  onSubmitOrder(f) {
    this.orderdetails = {
      orderDetail: f.value.orderdetail,
      quantity: f.value.quantity,
      quantityUnit: f.value.unit,
      userId: localStorage.getItem('loggedin')
    };
    console.log(f.value);
    const order = (data) => {
      console.log(data);
      this.router.navigate(['']);
    };
    this._addorderservice.addAnOrder(this.orderdetails, order);
  }
}
