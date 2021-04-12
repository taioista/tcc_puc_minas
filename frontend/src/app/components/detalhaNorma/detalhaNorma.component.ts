import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuItem, MessageService } from 'primeng/api';
import { Norma } from '../model/model';
import { NormaService } from '../service/norma.service';

@Component({
  selector: 'app-detalhaNorma',
  templateUrl: './detalhaNorma.component.html',
  styleUrls: ['./detalhaNorma.component.css']
})
export class DetalhaNormaComponent {
  [x: string]: any;

  items: MenuItem[];
  norma: Norma;
  sub: any;
  normas: Norma[];

  constructor(private messageService: MessageService, private router : Router, private route: ActivatedRoute, private normaService: NormaService) {}
  
  ngOnInit() {
 
    const id = this.route.snapshot.params['id'];
    this.normaService.getNormas().then(data => this.normas = data);


   for(var i = 0; this.normas.length > i; i++) {
    if(this.normas[i].id == id) {
      this.norma = this.normas[i];
    }
   }

  }

  

}