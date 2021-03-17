import { Search } from './search';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'piping',
})
export class PipingPipe implements PipeTransform {
  transform(searchs: Search[], searchText: string): Search[] {
    if (!searchText) {
      return searchs;
    } else {
      return searchs.filter((Search) => {
        return (
          Search.title
            .toLocaleLowerCase()
            .includes(searchText.toLocaleLowerCase()) ||
          Search.id
            .toString()
            .toLocaleLowerCase()
            .includes(searchText.toLocaleLowerCase()) ||
          Search.completed
            .toString()
            .toLocaleLowerCase()
            .includes(searchText.toLocaleLowerCase())
        );
      });
    }
  }
}
