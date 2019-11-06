import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MeterDataService } from '../Service/MeterDataService';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-meter-data-dashboard',
  templateUrl: './meter-data-dashboard.component.html',
  styleUrls: ['./meter-data-dashboard.component.css']
})
export class MeterDataDashboardComponent implements OnInit {
meterData: {udcId: string, readingDate: Date};
  chart : Chart;
  constructor(private route: ActivatedRoute, private service: MeterDataService) { }

  ngOnInit() {
    this.meterData = {
      udcId: this.route.snapshot.params['udcId'],
      readingDate: this.route.snapshot.params['readingDate']
    };
    console.log(this.meterData);
    this.service.getMeterByUdcIdAndReadingDate(this.meterData.udcId,new Date(this.meterData.readingDate)).subscribe(res =>{
      console.log(res);
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
              borderColor: '#FF7D33',
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

  getTimeFromDate(date: Date) {
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    return this.pad(hours) + ':' + this.pad(minutes) + ':' + this.pad(seconds);
  }
  pad(num) { 
    return ("0"+num).slice(-2);
  }
}
