import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';

import { AppComponent }   from './app.component';

import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {CalendarModule} from 'primeng/calendar';
import {SliderModule} from 'primeng/slider';
import {MultiSelectModule} from 'primeng/multiselect';
import {ContextMenuModule} from 'primeng/contextmenu';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {ProgressBarModule} from 'primeng/progressbar';
import {InputTextModule} from 'primeng/inputtext';
import {FileUploadModule} from 'primeng/fileupload';
import {ToolbarModule} from 'primeng/toolbar';
import {RatingModule} from 'primeng/rating';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputNumberModule} from 'primeng/inputnumber';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { NormaService } from './components/service/norma.service';
import { NormaComponent } from './components/norma/norma.component';
import { DetalhaNormaComponent } from './components/detalhaNorma/detalhaNorma.component';
import { ConsultoriaComponent } from './components/consultoria/consultoria.component';
import { AppRoutingModule } from './app-routing.module';
import { ConsultoriaService } from './components/service/consultoria.service';
import { HomeService } from './components/service/home.service';
import { ProductComponent } from './components/norma/product.component';
import { ProductService } from './components/norma/productservice';
import { PanelModule } from 'primeng/panel';

@NgModule({
  imports: [
    RouterModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    TableModule,
    CalendarModule,
		SliderModule,
		DialogModule,
		MultiSelectModule,
		ContextMenuModule,
		DropdownModule,
		ButtonModule,
		ToastModule,
    InputTextModule,
    ProgressBarModule,
    HttpClientModule,
    FileUploadModule,
    ToolbarModule,
    RatingModule,
    FormsModule,
    RadioButtonModule,
    InputNumberModule,
    ConfirmDialogModule,
    InputTextareaModule,
    PanelModule
  ],
  declarations: [ AppComponent, NormaComponent, DetalhaNormaComponent, ConsultoriaComponent, ProductComponent ],
  bootstrap:    [ AppComponent ],
  providers: [ MessageService, ConfirmationService, NormaService, ConsultoriaService, HomeService, ProductService]
})

export class AppModule { }
