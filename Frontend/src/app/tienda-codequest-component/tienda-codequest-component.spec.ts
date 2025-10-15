import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiendaCodequestComponent } from './tienda-codequest-component';

describe('TiendaCodequestComponent', () => {
  let component: TiendaCodequestComponent;
  let fixture: ComponentFixture<TiendaCodequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TiendaCodequestComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TiendaCodequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
