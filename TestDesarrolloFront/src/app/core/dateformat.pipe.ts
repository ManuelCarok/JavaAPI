import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateformat'
})
export class DateformatPipe implements PipeTransform {

  transform(value: any, args?: any): any {

    var fecha = value.toString();
    var fechaNew = fecha.replace(/-/g, '/');

    return fechaNew;
  }

}
