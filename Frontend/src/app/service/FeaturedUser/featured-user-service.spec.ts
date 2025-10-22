import { TestBed } from '@angular/core/testing';

import { FeaturedUserService } from './featured-user-service';

describe('FeaturedUserService', () => {
  let service: FeaturedUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeaturedUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
