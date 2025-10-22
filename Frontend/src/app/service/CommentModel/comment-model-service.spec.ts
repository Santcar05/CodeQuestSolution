import { TestBed } from '@angular/core/testing';

import { CommentModelService } from './comment-model-service';

describe('CommentModelService', () => {
  let service: CommentModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommentModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
