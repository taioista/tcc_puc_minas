import { Component } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { Norma } from '../model/model';
import { NormaService } from '../service/norma.service';

@Component({
  selector: 'app-norma',
  templateUrl: './norma.component.html',
  styleUrls: ['./norma.component.css'],
  styles: [`
      :host ::ng-deep .p-dialog .product-image {
          width: 150px;
          margin: 0 auto 2rem auto;
          display: block;
      }
  `],
  providers: [MessageService,ConfirmationService]
})
export class NormaComponent {

  normaDialog: boolean;

  normas: Norma[];

  norma: Norma;

  selectedNormas: Norma[];

  submitted: boolean;

  statuses: any[];

  
  constructor(private normaService: NormaService, private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit() {
      this.normaService.getNormas(); //.then(data => this.normas = data);

      this.statuses = [
          {label: 'INSTOCK', value: 'instock'},
          {label: 'LOWSTOCK', value: 'lowstock'},
          {label: 'OUTOFSTOCK', value: 'outofstock'}
      ];
  }

  openNew() {
      this.norma = null; // mexi
      this.submitted = false;
      this.normaDialog = true;
  }

  deleteSelectedNormas() {
      this.confirmationService.confirm({
          message: 'Você tem certeza que quer deletar as normas selecionadas?',
          header: 'Confirm',
          icon: 'pi pi-exclamation-triangle',
          accept: () => {
              this.normas = this.normas.filter(val => !this.selectedNormas.includes(val));
              this.selectedNormas = null;
              this.messageService.add({severity:'success', summary: 'Successful', detail: 'Normas excluídas', life: 3000});
          }
      });
  }

  editNorma(norma: Norma) {
      this.norma = {...norma};
      this.normaDialog = true;
  }

  deleteNorma(norma: Norma) {
      this.confirmationService.confirm({
          message: 'Você tem certeza que quer deletar a norma ' + norma.codigo + '?',
          header: 'Confirm',
          icon: 'pi pi-exclamation-triangle',
          accept: () => {
              this.normas = this.normas.filter(val => val.id !== norma.id);
              this.norma = null; //mexi
              this.messageService.add({severity:'success', summary: 'Successful', detail: 'Norma excluída', life: 3000});
          }
      });
  }

  hideDialog() {
      this.normaDialog = false;
      this.submitted = false;
  }
  
  saveNorma() {
      this.submitted = true;

      if (this.norma.codigo.trim()) {
          if (this.norma.id) {
              this.normas[this.findIndexById(this.norma.id)] = this.norma;                
              this.messageService.add({severity:'success', summary: 'Successful', detail: 'Norma Atualizada', life: 3000});
          }
          else {
              this.norma.id = this.createId();
              this.normas.push(this.norma); //mexi
              this.messageService.add({severity:'success', summary: 'Successful', detail: 'Norma Criada', life: 3000});
          }

          this.normas = [...this.normas];
          this.normaDialog = false;
          this.norma = null; //mexi
      }
  }

  findIndexById(id: string): number {
      let index = -1;
      for (let i = 0; i < this.normas.length; i++) {
          if (this.normas[i].id === id) {
              index = i;
              break;
          }
      }

      return index;
  }

  createId(): string {
      let id = '';
      var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
      for ( var i = 0; i < 5; i++ ) {
          id += chars.charAt(Math.floor(Math.random() * chars.length));
      }
      return id;
  }
  
}