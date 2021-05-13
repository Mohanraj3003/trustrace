import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByCountriesComponent } from './search-by-countries.component';

describe('SearchByCountriesComponent', () => {
  let component: SearchByCountriesComponent;
  let fixture: ComponentFixture<SearchByCountriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchByCountriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchByCountriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
