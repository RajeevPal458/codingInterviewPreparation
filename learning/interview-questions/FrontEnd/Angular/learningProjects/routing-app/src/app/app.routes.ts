import { Routes } from '@angular/router';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

export const routes: Routes = [
    {path: '', redirectTo: '/', pathMatch: 'full'},
    {path: 'first-work', component: FirstComponent},
    {path: 'second-work', component: SecondComponent},
    {path: '**', component: PageNotFoundComponent}
];
