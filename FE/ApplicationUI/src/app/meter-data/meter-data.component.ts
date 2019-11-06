import { Component, OnInit, Input } from '@angular/core';
import { MeterDataService } from '../Service/MeterDataService';
import { MeterData } from '../Interface/MeterData';
import { Observable  } from 'rxjs';
import { NgxSpinnerService  } from 'ngx-spinner';

@Component({
  selector: 'app-meter-data',
  templateUrl: './meter-data.component.html',
  styleUrls: ['./meter-data.component.css']
})
export class MeterDataComponent implements OnInit {

  udcId = null;
  meterDatas: Observable<MeterData[]>;
  readingDate = null;

  constructor(private service: MeterDataService, private spinner: NgxSpinnerService ) { }

  ngOnInit() {
    this.searchAll();
    console.log(this.meterDatas);
  }

  showSpinner() {
    this.spinner.show();
    setTimeout(() => {
      this.spinner.hide();
    }, 1000);
  }
  searchAll() {
    this.showSpinner();
    this.service.getAllMeterTotalConsumption().subscribe( data => {
      this.meterDatas = data;
    });
  }


  updateUdcId(event: Event) {
    this.udcId = (<HTMLInputElement>event.target).value;
    if(this.udcId === ''){
      this.udcId = null;
    }
  }

  searchByUdcId() {
    console.log(this.udcId);
    if ( (this.udcId === null || this.udcId === '') && this.readingDate === null) {
      this.searchAll();
      return;
    }
    console.log(this.readingDate);
    this.showSpinner();
    this.service.getConsumptionByUdcIdAndReadingDate(this.udcId, this.readingDate).subscribe( data => {
      this.meterDatas = data;
    });
    console.log( this.meterDatas);
  }
}
