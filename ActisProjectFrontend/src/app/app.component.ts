import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { APIControlComponent} from "./api-control/api-control.component";

@Component({
  selector: 'app-root',
  styles: [
    'button { font-weight: bold; border-radius: 8px;}'
  ],
  standalone: true,
  imports: [CommonModule, RouterOutlet, APIControlComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public textjedna = APIControlComponent;
}
