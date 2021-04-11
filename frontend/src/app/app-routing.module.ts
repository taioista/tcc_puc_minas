import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ConsultoriaComponent } from './components/consultoria/consultoria.component';
import { DetalhaNormaComponent } from './components/detalhaNorma/detalhaNorma.component';
import { HomeComponent } from './components/home/home.component';
import { NormaComponent } from './components/norma/norma.component';
import { ProductComponent } from './components/norma/product.component';


const routes: Routes = [{
  path: "",
  component: HomeComponent
},
{
  path: "norma",
  component: NormaComponent
},
{
  path: "consultoria",
  component: ConsultoriaComponent
},
{
  path: "detalhaNorma",
  component: DetalhaNormaComponent
},
{
path: "product",
component: ProductComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
