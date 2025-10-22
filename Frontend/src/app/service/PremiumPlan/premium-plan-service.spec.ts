import { TestBed } from '@angular/core/testing';

import { PremiumPlanService } from './premium-plan-service';

describe('PremiumPlanService', () => {
  let service: PremiumPlanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PremiumPlanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
