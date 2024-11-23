import { Component } from '@angular/core';
import { ChildComponent } from '../child/child.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [ChildComponent,CommonModule],
  templateUrl: './parent.component.html',
  styleUrl: './parent.component.css'
})
export class ParentComponent {

   createdDate= new Date();
   nameFromChild ="parent";

   updateDate(){
    this.createdDate=new Date(this.createdDate.getFullYear()-1,this.createdDate.getMonth()-1,this.createdDate.getDate()+1);
   }

   receiveData(childName:string){
      console.log('name--'+childName)
      this.nameFromChild =childName;
   }
}
