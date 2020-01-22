import { Component, OnInit } from '@angular/core';
import { ApirestService } from './core/apirest.service';
import { IfStmt } from '@angular/compiler';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ValidateNombre } from './core/nombre.validator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'TestDesarrolloFront';
  headers: string [] = ["Nombre","Apellido","Fecha","Edad","Días"];
  columns: any [] = [];

  formPerson: FormGroup;

  constructor(
    private service: ApirestService 
  ) { 
    this.formPerson = new FormGroup({
      txtNombre: new FormControl('', [Validators.required, ValidateNombre]),
      txtFecha: new FormControl('', Validators.required)
    });
  }

  ngOnInit(): void {
    localStorage.setItem('personas', '[]');
  }

  addPersona(values: any) {
    
    this.service.getData(values.txtNombre, values.txtFecha).subscribe(data => {
      this.addLocalStorage({ nombre: data.nombre.toString().split(' ')[0], apellido: data.nombre.toString().split(' ')[1], fecha: values.txtFecha, edad: data.edad, dias: data.dias });
      this.columns = JSON.parse(localStorage.getItem('personas'));
    });

    return false;
  }

  addLocalStorage(element: any) {
    let array = [];
    let getLocal = JSON.parse(localStorage.getItem('personas'));
    
    getLocal.forEach(element => {
      array.push(element);
    });
    array.push(element);
    
    localStorage.setItem('personas', JSON.stringify(array));
  }
}