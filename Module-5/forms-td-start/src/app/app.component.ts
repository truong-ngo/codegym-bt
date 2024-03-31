import {Component, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') form: NgForm;

  suggestUserName() {
    const suggestedName = 'Superuser';
    this.form.form.patchValue({
      username: suggestedName
    })
    // this.form.setValue({
    //   username: suggestedName,
    //   email: '',
    //   secret: 'pet',
    //   questionAnswer: '',
    //   gender: 'male'
    // })
  }

  // onSubmit(f: NgForm) {
  //   console.log(f.form.controls['username'].value)
  //   console.log(f.form.controls['email'].value)
  //   console.log(f.form.controls['secret'].value)
  // }
  defaultQuestion: string = 'pet';
  answer: string = '';
  genders: string[] = ['male', 'female']
  onSubmit() {
    console.log(this.form)
  }
}
