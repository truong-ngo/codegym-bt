import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reverse'
})
export class ReversePipe implements PipeTransform {

  transform(value: any): any {
    let array = value.split('');
    let result = array.reverse();
    return result.join('')
  }

}
