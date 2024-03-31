import {HttpHandler, HttpInterceptor, HttpParams, HttpRequest} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {Injectable, OnInit} from "@angular/core";
import {User} from "./user.model";
import {exhaustMap, take} from "rxjs";

@Injectable()
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private authService: AuthService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    return this.authService.userSub.pipe(take(1), exhaustMap(
      (user: User) => {
        if (!user) {
          return next.handle(req)
        } else {
          const authReq = req.clone({
            params: new HttpParams().set('auth', user.token)
          })
          return next.handle(authReq)
        }
      }
    ))
  }
}
