import { Component, OnInit, ViewChild } from '@angular/core';
import {  Orders } from './order.model';
import { MatTableDataSource, MatPaginator } from '../../../../node_modules/@angular/material';
import { HomeService } from './home.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService]
})
export class HomeComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;

  public x: Orders[] = [  ];
  displayedColumns: string[] = ['orderId', 'orderDetail', 'quantity', 'quantityUnit'];
  public dataSource;
  constructor(private router: Router, private _homeservice: HomeService) { }

  ngOnInit() {
    const success = (data) => {
      for (const ord of data) {

        const singleitem = {
          orderId: ord.orderId,
          orderDetail: ord.orderDetail,
          quantity: ord.quantity,
          quantityUnit: ord.quantityUnit
        };
        this.x.push(singleitem);
      }
      this.dataSource = new MatTableDataSource(this.x);
      this.dataSource.paginator = this.paginator;
      // console.log(data);
    };
    this._homeservice.getAllOrders(success);
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
