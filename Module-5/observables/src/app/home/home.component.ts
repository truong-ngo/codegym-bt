import {Component, OnDestroy, OnInit} from '@angular/core';
import {interval, Observable, Observer, Subscription} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  private firstObsSubscription: Subscription | undefined;

  ngOnInit(): void {
    // this.firstObsSubscription = interval(1000).subscribe(count => {
    //   console.log(count)
    // })
    const customIntervalObservable = Observable.create((observer: Observer<any>) => {
      let count = 0
      setInterval(() => {
        observer.next(count)
        if (count === 2) {
          observer.complete();
        }
        if (count > 3) {
          observer.error(new Error('Count is greater than 3'))
        }
        count++
      }, 1000)
    });

    this.firstObsSubscription = customIntervalObservable.subscribe((data: any) => {
      console.log(data)
    }, (error: any) => {
      alert(error.message)
    }, () => {
      alert("complete")
    })
  }

  ngOnDestroy(): void {
    this.firstObsSubscription?.unsubscribe();
  }

}
