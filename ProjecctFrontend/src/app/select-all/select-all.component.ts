import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DbData} from "../DbData";
import { Observable, throwError } from 'rxjs';
import { map, catchError} from 'rxjs/operators';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-select-all',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './select-all.component.html',
  styleUrl: './select-all.component.css'
})
export class SelectAllComponent {
  //data = DbData;

  constructor(private http: HttpClient) {
  }

  public selectAll(): Observable<any> {
    return this.http.get('localhost:8080/Hello');
  }
}
