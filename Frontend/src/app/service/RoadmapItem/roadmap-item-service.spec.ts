import { TestBed } from '@angular/core/testing';

import { RoadmapItemService } from './roadmap-item-service';

describe('RoadmapItemService', () => {
  let service: RoadmapItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoadmapItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
