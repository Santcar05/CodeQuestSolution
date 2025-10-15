import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaProfesionalComponent } from './ruta-profesional-component';

describe('RutaProfesionalComponent', () => {
  let component: RutaProfesionalComponent;
  let fixture: ComponentFixture<RutaProfesionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RutaProfesionalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaProfesionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
