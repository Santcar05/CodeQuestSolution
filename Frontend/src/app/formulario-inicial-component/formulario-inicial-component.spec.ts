import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioInicialComponent } from './formulario-inicial-component';

describe('FormularioInicialComponent', () => {
  let component: FormularioInicialComponent;
  let fixture: ComponentFixture<FormularioInicialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormularioInicialComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioInicialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
