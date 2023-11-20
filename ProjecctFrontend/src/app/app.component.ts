import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, RouterOutlet} from '@angular/router';
import {SelectAllComponent} from "./select-all/select-all.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, SelectAllComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title : string = 'ProjecctFrontend';
  Hellostring : string = '';
  loading: boolean = false;
  errorMessage : any;
  constructor(private selectAll: SelectAllComponent) {
  }

  public SelectAll() {
    this.loading = true;
    this.errorMessage = "";
    this.selectAll.selectAll()
      .subscribe(
        (response) => {                           //next() callback
          console.log('response received');
          console.log(response);
          this.Hellostring = response;
        },
        (error) => {                              //error() callback
          console.error('Request failed with error')
          this.errorMessage = error;
          this.loading = false;
        },
        () => {                                   //complete() callback
          console.error('Request completed')      //This is actually not needed
          this.loading = false;
        })
  }
}
