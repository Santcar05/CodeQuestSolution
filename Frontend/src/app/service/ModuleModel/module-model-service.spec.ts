import { TestBed } from '@angular/core/testing';

import { ModuleModelService } from './module-model-service';

describe('ModuleModelService', () => {
  let service: ModuleModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModuleModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
