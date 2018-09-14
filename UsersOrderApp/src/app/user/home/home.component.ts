import { Component, OnInit } from '@angular/core';
import {  Orders } from './order.model';
import { MatTableDataSource } from '../../../../node_modules/@angular/material';
import { HomeService } from './home.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService]
})
export class HomeComponent implements OnInit {

  public x: Orders[] = [
    // { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
    // { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
    // { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
    // { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
    // { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
    // { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
    // { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
    // { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
    // { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
    // { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
  ];
  displayedColumns: string[] = ['orderId', 'orderDetail', 'quantity', 'quantityUnit'];
  public dataSource;
  constructor(private router: Router, private _homeservice: HomeService) { }

  ngOnInit() {
    console.log('bawa');
    const y = (data) => {
      for (let d of data) {

        const singleitem = {
          orderId: d.orderId,
          orderDetail: d.orderDetail,
          quantity: d.quantity,
          quantityUnit: d.quantityUnit
        };
        this.x.push(singleitem);
      }
      this.dataSource = new MatTableDataSource(this.x);
      // console.log(data);
    };
    this._homeservice.getAllOrders(y);
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
