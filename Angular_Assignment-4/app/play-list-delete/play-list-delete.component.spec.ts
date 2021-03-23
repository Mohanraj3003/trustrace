import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayListDeleteComponent } from './play-list-delete.component';

describe('PlayListDeleteComponent', () => {
  let component: PlayListDeleteComponent;
  let fixture: ComponentFixture<PlayListDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayListDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayListDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
