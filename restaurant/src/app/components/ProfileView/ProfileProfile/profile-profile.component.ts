import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { Order, User, UserService } from 'src/app/generated-api';
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { Form, FormBuilder, FormGroup, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-profile-profile',
  standalone: true,
  imports: [CommonModule, ButtonModule],
  templateUrl: './profile-profile.component.html',
  styleUrls: ['./profile-profile.component.scss'],
})
export class ProfileProfileComponent implements OnInit {
  form: FormGroup | null = null;
  order?: Order | null
  
  user?: User | null

  constructor(
    private storeUsderService: StoreUserService,
    private userService: UserService,
    private formBuilder: FormBuilder,
  ) {}

  ngOnInit() {
    this.user = this.storeUsderService.getUser();
    this.user ={
      id: "1",
      name: "test",
      email: "teszt",
      mobil: "teszt",
      address: "teszt",
    }
    this.form = this.formBuilder.group({
      name: this.user.name,
      email: this.user.email,
      mobil: this.user.mobil,
      address: this.user.address,
    })
  }

  changeUserData(){
    const user = {
      id: "1",
      name: "test",
      email: "teszt",
      mobil: "teszt",
      address: "teszt",
    } as User;
    this.userService.updateUserById(user.id!, user).subscribe(
      (user: User) => {
        this.user = user;
      },
      (error) => {
        console.log(error);
      }
    );

  }
}
