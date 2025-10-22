import { TestBed } from '@angular/core/testing';

import { ResourceModelService } from './resource-model-service';

describe('ResourceModelService', () => {
  let service: ResourceModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResourceModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
