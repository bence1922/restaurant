import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import {  User, UserService } from 'src/app/generated-api';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-profile-profile',
  standalone: true,
  imports: [CommonModule, ButtonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './profile-profile.component.html',
  styleUrls: ['./profile-profile.component.scss'],
})
export class ProfileProfileComponent implements OnInit {
  user: User={
    name:"",
    email:"",
    mobil: "",
    address: "",
    points: 0,
  }
  userForm = new FormGroup({
    name: new FormControl(this.user!.name, [Validators.required]),
    phone: new FormControl(this.user!.mobil, [Validators.required]),
    email: new FormControl(this.user!.email, [Validators.required]),
    address: new FormControl(this.user!.address, [Validators.required]),
  })

  constructor(private userService: UserService){

  }

  ngOnInit(){
    this.userService.getUserById(localStorage.getItem('userId')!).subscribe(
      (result) => {
        this.user = result;
      }
    )
  }

  onSubmit(){
    var user : User={
      name: this.userForm.value.name!,
      email: this.userForm.value.email!,
      mobil: this.userForm.value.phone!,
      address: this.userForm.value.address!
    }
    this.userService.updateUserById(localStorage.getItem('userId')!, user).subscribe(
      (result)=>{
        alert("Success!")
      }
    )
  }
  
}
