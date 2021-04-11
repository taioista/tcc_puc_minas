import { Norma } from "../model/model";
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class HomeService {

    norma: Norma = new Norma("1","ISO 19238","A NORMA PIPIPI POOPOPOP", new Date(), 0);
    norma2: Norma = new Norma("1","ISO 19238","A NORMA PIPIPI POOPOPOP", new Date(), 0);

    normas: Norma[] = [this.norma, this.norma2];

  
    constructor(private http: HttpClient) { }
  
    getNormas() : Norma [] {
      return this.normas;
    }


  }