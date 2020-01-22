import { AbstractControl } from '@angular/forms';

export function ValidateNombre(control: AbstractControl) {

    let nombre = control.value.toString().split(' ');

    if(nombre.length <= 3) {
        return {
            nombre: true
        }
    } 

    return null;
}