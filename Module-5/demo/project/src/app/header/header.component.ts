import {Component, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {DataStorageService} from "../shared/data-storage.service";
import {AuthService} from "../auth/auth.service";
import {Router} from "@angular/router";
import {User} from "../auth/user.model";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['header.component.css']
})
export class HeaderComponent implements OnInit {
  userSub: Subscription
  isAuthenticated

  constructor(private storageService: DataStorageService,
              private authService: AuthService,
              private router: Router) {
  }

  ngOnInit() {
    this.userSub = this.authService.userSub.subscribe(
      (user: User) => {
        this.isAuthenticated = !!user
      }
    )
  }

  onSaveData() {
    this.storageService.storeRecipes();
  }

  onFetchData() {
    this.storageService.fetchRecipes().subscribe();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/auth'])
  }
}
