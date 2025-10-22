import { TestBed } from '@angular/core/testing';

import { CodeExplanationService } from './code-explanation-service';

describe('CodeExplanationService', () => {
  let service: CodeExplanationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CodeExplanationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
