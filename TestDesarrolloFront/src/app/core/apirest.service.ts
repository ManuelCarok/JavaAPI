import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApirestService {

  private readonly baseUrl = environment.baseApiUrl;
  private readonly endPoint = `${this.baseUrl}/api`;

  constructor(
    private http: HttpClient
  ) { }

  getData(nombre:string, fecha: string): Observable<any> {
    const post = {
      nombre: nombre,
      fecha: fecha
    }

    return this.http.post<any>(this.endPoint, post);
  }
}
