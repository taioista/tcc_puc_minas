import { Component } from '@angular/core';
import { MenuItem, MessageService } from 'primeng/api';
import { Norma } from '../model/model';

@Component({
  selector: 'app-detalhaNorma',
  templateUrl: './detalhaNorma.component.html',
  styleUrls: ['./detalhaNorma.component.css']
})
export class DetalhaNormaComponent {

  items: MenuItem[];
  norma: Norma;
    
  constructor(private messageService: MessageService) {}
  
  ngOnInit() {
    this.norma = new Norma("1","ISO 19238","A NORMA PIPIPI POOPOPOP", new Date(), 0);
  }


}