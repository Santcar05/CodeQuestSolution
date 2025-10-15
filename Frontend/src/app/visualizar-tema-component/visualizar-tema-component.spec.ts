import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarTemaComponent } from './visualizar-tema-component';

describe('VisualizarTemaComponent', () => {
  let component: VisualizarTemaComponent;
  let fixture: ComponentFixture<VisualizarTemaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarTemaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarTemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
