import { ComponentFixture, TestBed } from '@angular/core/testing';

import { APIControlComponent } from './api-control.component';

describe('APIControlComponent', () => {
  let component: APIControlComponent;
  let fixture: ComponentFixture<APIControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [APIControlComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(APIControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
