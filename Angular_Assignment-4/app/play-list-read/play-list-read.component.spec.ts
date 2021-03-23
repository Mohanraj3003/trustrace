import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayListReadComponent } from './play-list-read.component';

describe('PlayListReadComponent', () => {
  let component: PlayListReadComponent;
  let fixture: ComponentFixture<PlayListReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayListReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayListReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
