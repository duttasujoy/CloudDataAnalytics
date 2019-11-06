import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MeterData } from '../Interface/MeterData';
@Injectable({
    providedIn: 'root'
  })
export class MeterDataService {
    private baseUrl = 'http://localhost:8070/';

    constructor(private http: HttpClient) { }

    getAllMeterTotalConsumption(): Observable<any> {
        return this.http.get(`${this.baseUrl}` + 'getAll');
      }

    getMeterByUdcId(udcId: string): Observable<any> {
      return this.http.get(`${this.baseUrl}` + 'getByUdcId/' + udcId);
    }

    getAllMeterDatas(readingDate: Date): Observable<any> {
      if(readingDate === undefined || readingDate === null){
        return this.http.get(`${this.baseUrl}` + 'getAllData/');
      }
      else {
        return this.http.get(`${this.baseUrl}` + 'getAllData/'+ readingDate);
      }
    }

    getMeterByUdcIdAndReadingDate(udcId: string, readingDate: Date): Observable<any> {
      return this.http.get(`${this.baseUrl}` + 'getByUdcId/' + udcId + '/' + readingDate);
    }
    getConsumptionByUdcIdAndReadingDate(udcId: string, readingDate: Date): Observable<any> {
      return this.http.get(`${this.baseUrl}` + 'getConsumptionByUdcId/' + udcId + '/' + readingDate);
    }
}
