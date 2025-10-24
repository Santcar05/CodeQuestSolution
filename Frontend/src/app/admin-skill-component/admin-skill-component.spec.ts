import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSkillComponent } from './admin-skill-component';

describe('AdminSkillComponent', () => {
  let component: AdminSkillComponent;
  let fixture: ComponentFixture<AdminSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminSkillComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
