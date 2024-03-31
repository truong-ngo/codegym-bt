import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, filterString: string, prop: string): any {
    if (value.length === 0 || filterString === undefined || filterString === '') {
      return value
    }
    const result = [];
    for (let v of value) {
      if (v[prop] === filterString) {
        result.push(v)
      }
    }
    return result
  }

}
