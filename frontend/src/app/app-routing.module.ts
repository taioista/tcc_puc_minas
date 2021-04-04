import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NormaListComponent } from './components/norma/norma-list/norma-list.component';

const routes: Routes = [{
  path: "",
  component: HomeComponent
},
{
  path: "normas/list",
  component: NormaListComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
