import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayListUpdateComponent } from './play-list-update.component';

describe('PlayListUpdateComponent', () => {
  let component: PlayListUpdateComponent;
  let fixture: ComponentFixture<PlayListUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayListUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayListUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
