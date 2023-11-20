import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-api-control',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './api-control.component.html',
  styleUrl: './api-control.component.css'
})
export class APIControlComponent {
  private DbLink = "jdbc:postgresql://localhost:5432/TrialDB";
  private DbUsername : string = "postgres";
  private DbPassword : string = "000";
}
