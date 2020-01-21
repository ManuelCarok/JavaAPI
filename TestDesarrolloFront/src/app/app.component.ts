import { Component, OnInit } from '@angular/core';
import { ApirestService } from './core/apirest.service';
import { IfStmt } from '@angular/compiler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'TestDesarrolloFront';
  headers: string [] = ["Nombre","Apellido","Fecha","Edad","Días"];
  columns: any [] = [];

  nombre: string = "";
  fecha: string = "";

  constructor(
    private service: ApirestService 
  ) { }

  ngOnInit(): void {
    localStorage.setItem('personas', '[]');
  }

  addPersona() {
    this.service.getData(this.nombre, this.fecha).subscribe(data => {
      this.addLocalStorage({ nombre: data.nombre.toString().split(' ')[0], apellido: data.nombre.toString().split(' ')[1], fecha: this.fecha, edad: data.edad, dias: data.dias });
      this.columns = JSON.parse(localStorage.getItem('personas'));
    });
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