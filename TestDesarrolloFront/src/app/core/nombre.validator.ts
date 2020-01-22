import { AbstractControl } from '@angular/forms';

export function ValidateNombre(control: AbstractControl) {

    let nombre = control.value.toString().split(' ');

    if(nombre.filter(f => f !== '').length <= 2) {
        return {
            nombre: true
        }
    } 

    return null;
}