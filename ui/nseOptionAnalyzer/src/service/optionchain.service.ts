import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { DerivativeModel } from "src/model/derivative.model";

@Injectable()
export class OptionChainService{
    api: string = 'http://localhost:8080/data/get?symbol=NIFTY';

    constructor(
      private http: HttpClient
    ) { }

    getAll(): Observable<DerivativeModel[]> {
        return this.http.get<DerivativeModel[]>(this.api);
      }

    private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
          console.log(error.error.message)
    
        } else {
          console.log(error.status)
        }
        return throwError(
          console.log('Something is wrong!'));
      };
}