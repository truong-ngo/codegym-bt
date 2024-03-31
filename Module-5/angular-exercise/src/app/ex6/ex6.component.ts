import {Component, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-ex6',
  templateUrl: './ex6.component.html',
  styleUrls: ['./ex6.component.css']
})
export class Ex6Component {
  @ViewChild('f') form: NgForm;
  subscriptions = ['Basic', 'Advance', 'Pro'];
  defaultSubscription = 'Advance';
  user = {email: '', subscription: '', password: ''};
  submitted = false;

  onSubmit() {
    this.submitted = true
    this.user.email = this.form.value.email
    this.user.subscription = this.form.value.subscription
    this.user.password = this.form.value.password
    this.form.resetForm();
  }
}
