import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {FormGroup, FormControl, ReactiveFormsModule, FormBuilder, Validators} from '@angular/forms';
@Component({
  selector: 'registration',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  registrationForm:FormGroup;

  constructor(private formBuilder:FormBuilder){

  }

  ngOnInit(){
    this.registrationForm=this.formBuilder.group({
      firstName :['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(15)])],
      lastName :['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(15)])],
      email :['',Validators.compose([Validators.required,Validators.email])],
      mobileNumber :['',Validators.compose([Validators.required,Validators.minLength(10),Validators.maxLength(10)])],
    });
  }


  formSubmit(form:FormGroup){
    console.log(this.registrationForm.value);
  }

}
