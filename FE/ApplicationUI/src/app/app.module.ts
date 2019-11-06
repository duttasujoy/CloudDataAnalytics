import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { MeterDataComponent } from './meter-data/meter-data.component';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import {NgxPaginationModule} from 'ngx-pagination';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxSpinnerModule } from 'ngx-spinner';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChartsModule } from 'ng2-charts';
import { MeterDataDashboardComponent } from './meter-data-dashboard/meter-data-dashboard.component';

const appRoutes: Routes = [
  { path: '',  pathMatch: 'full', redirectTo: '/dashboard' },
  { path: 'meterdata', component: MeterDataComponent },
  { path: 'dashboard/:udcId/:readingDate', component: MeterDataDashboardComponent },
  { path: 'dashboard', component: DashboardComponent }
  
];
@NgModule({
  declarations: [
    AppComponent,
    MeterDataComponent,
    DashboardComponent,
    MeterDataDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule,
    NgxSpinnerModule,
    RouterModule.forRoot(appRoutes),
    ChartsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
