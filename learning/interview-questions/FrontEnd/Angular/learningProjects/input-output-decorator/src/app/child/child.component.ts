import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent{
  data = 'Hello from Child!';
  @Input() createdfullDate=new Date();

  constructor(){

  }

  @Output() nameUpdateEvent: EventEmitter<string> = new EventEmitter<string>();


  
  sendData(data:string) {
    console.log('data--'+data);
    this.nameUpdateEvent.emit(data); // Emits data to parent
  }
}
