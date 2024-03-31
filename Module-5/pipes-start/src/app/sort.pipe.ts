import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sort'
})
export class SortPipe implements PipeTransform {

  transform(value: any, condition: string, prop: string): any {
    if (condition === 'asc') {
      return value.sort((a, b) => {
        if (a[prop] > b[prop]) return 1
        if (a[prop] < b[prop]) return -1
        return 0
      });
    } else if (condition === 'desc') {
      return value.sort((a, b) => {
        if (a[prop] > b[prop]) return -1
        if (a[prop] < b[prop]) return 1
        return 0
      });
    }
  }

}
