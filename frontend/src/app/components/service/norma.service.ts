import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { throwError } from "rxjs";
import { catchError, map } from "rxjs/operators";
import { Norma } from "../model/model";

@Injectable()
export class NormaService {
  baseUrl = "api/normas";

  constructor(private http: HttpClient) {}

  getNormas() {
    return this.http
      .get<any>("assets/normas.json")
      .toPromise()
      .then((res) => <Norma[]>res.data)
      .then((data) => {
        return data;
      });
  }

  public getAll() {
    console.log(this.baseUrl);
    return this.http.get(this.baseUrl).pipe(
      map((response) => response),
      catchError((e) => this.handleError(e))
    );
  }

  public delete(id) {
    return this.http.delete(this.baseUrl + "/" + id).pipe(
      map((response) => response),
      catchError((e) => this.handleError(e))
    );
  }

  public get(id) {
    return this.http.get(this.baseUrl + "/" + id).pipe(
      map((response) => response),
      catchError((e) => this.handleError(e))
    );
  }

  protected handleError(error: Response) {
    console.log(error);
    return throwError(error);
  }
}
