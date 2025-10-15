import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiRutaComponent } from './mi-ruta-component';

describe('MiRutaComponent', () => {
  let component: MiRutaComponent;
  let fixture: ComponentFixture<MiRutaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MiRutaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MiRutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
