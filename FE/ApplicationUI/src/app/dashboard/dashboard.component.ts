import { Component, OnInit, ViewChild } from '@angular/core';
import { MeterDataService } from '../Service/MeterDataService';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  chart :Chart;
  readingDate = new Date('01/02/2019');
  constructor(private service: MeterDataService) {}
  ngOnInit() {
    this.service.getAllMeterDatas(this.readingDate).subscribe(res =>{
      res.intervalReadData = new Date('01/02/2019');
      let datas = res.map( res => res.intervalReadData);
      let alldates = res.map(res => res.meterReadDate.slice(11, 16)).sort();

      let weatherDates = []
      alldates.forEach((res) => {
        weatherDates.push(res)
      })
      console.log(alldates);

      this.chart = new Chart('canvas', {
        type: 'line',
        data: {
          labels: alldates,
          datasets: [
            {
              data: datas,
              borderColor: '#3cba9f',
              fill: false
            },
          ]
        },
        options: {
          legend: {
            display: false
          },
          scales: {
            xAxes: [{
              display: true
            }],
            yAxes: [{
              display: true
            }]
          }
        }
      });
    });
  }

  searchByUdcId(){
    console.log('Sujoy'+this.readingDate);
    this.service.getAllMeterDatas(this.readingDate).subscribe(res =>{
      let datas = res.map( res => res.intervalReadData);
      let alldates = res.map(res => res.meterReadDate.slice(11, 16)).sort();

      let weatherDates = []
      alldates.forEach((res) => {
        weatherDates.push(res)
      })
      console.log(alldates);

      this.chart = new Chart('canvas', {
        type: 'line',
        data: {
          labels: alldates,
          datasets: [
            {
              data: datas,
              borderColor: '#3cba9f',
              fill: false
            },
          ]
        },
        options: {
          legend: {
            display: false
          },
          scales: {
            xAxes: [{
              display: true
            }],
            yAxes: [{
              display: true
            }]
          }
        }
      });
    });
  }

}
