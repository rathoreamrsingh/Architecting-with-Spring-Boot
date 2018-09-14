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

  ngOnInit() {
  }
  onSubmitOrder(f) {
    console.log(f.value);
    const order = (data) => {
      console.log(data);
    };
    this._addorderservice.addAnOrder('gg', order);
  }
}
