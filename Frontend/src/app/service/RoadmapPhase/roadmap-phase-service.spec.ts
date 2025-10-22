import { TestBed } from '@angular/core/testing';

import { RoadmapPhaseService } from './roadmap-phase-service';

describe('RoadmapPhaseService', () => {
  let service: RoadmapPhaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoadmapPhaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
