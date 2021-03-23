import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayListCreateComponent } from './play-list-create.component';

describe('PlayListCreateComponent', () => {
  let component: PlayListCreateComponent;
  let fixture: ComponentFixture<PlayListCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayListCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayListCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
