import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs";

@Component({
  selector: 'app-ex7',
  templateUrl: './ex7.component.html',
  styleUrls: ['./ex7.component.css']
})
export class Ex7Component implements OnInit {
  projectStatus = ['Stable', 'Critical', 'Finished']
  reactiveForm: FormGroup;
  submitted: boolean = false;
  project: {projectName: string, mail: string, projectStatus: string}

  ngOnInit(): void {
    this.reactiveForm = new FormGroup({
      'projectName': new FormControl(null, [Validators.required, this.forbiddenProjectName.bind(this)], this.forbiddenNameRequest.bind(this)),
      'mail': new FormControl(null, [Validators.required, Validators.email]),
      'projectStatus': new FormControl('Stable')
    })
    console.log(this.reactiveForm.value.projectName)
  }

  onSubmit() {
    this.submitted = true
    this.project = {
      projectName: this.reactiveForm.value.projectName,
      mail: this.reactiveForm.value.mail,
      projectStatus: this.reactiveForm.value.projectStatus,
    }
    this.reactiveForm.reset({
      'projectStatus': 'Stable'
    })
  }

  forbiddenProjectName(control: FormControl): {[s: string]: boolean} {
    if (control.value != null && control.value.toLowerCase() === 'test') {
      return {'nameIsForbidden': true}
    }
    return null
  }

  forbiddenNameRequest(control: FormControl): Promise<any> | Observable<any> {
    let promise = new Promise<any>((resolve, reject) => {
      setTimeout(() => {
        if (control.value != null && control.value.toLowerCase() === 'demo') {
          resolve ({'thisNameIsForbidden': true})
        } else {
          resolve (null)
        }
      },2000)
    })
    return promise;
  }
}
