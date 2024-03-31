import {Injectable} from "@angular/core";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {BehaviorSubject, catchError, pipe, Subject, tap, throwError} from "rxjs";
import {User} from "./user.model";
import {Router} from "@angular/router";

export interface AuthResponse {
  idToken: string,
  email: string,
  refreshToken: string,
  expiresIn: string,
  localId: string
  register?: boolean
}

@Injectable()
export class AuthService {
  userSub = new BehaviorSubject<User>(null);
  tokenExpirationTimer: any

  constructor(private http: HttpClient) {
  }

  signup(email: string, password: string) {
    return this.http.post<AuthResponse>('https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAnz3Unnswzh-eTD2ZEBc7v-cyqLWBQVyc', {
      email: email,
      password: password,
      returnSecureToken: true
    }).pipe(catchError(this.handleError), tap(res => {this.handleAuthentication(res.email, res.localId, res.idToken, +res.expiresIn)}))
  }

  login(email: string, password: string) {
    return this.http.post<AuthResponse>('https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAnz3Unnswzh-eTD2ZEBc7v-cyqLWBQVyc', {
      email: email,
      password: password,
      returnSecureToken: true
    }).pipe(catchError(this.handleError), tap(res => {this.handleAuthentication(res.email, res.localId, res.idToken, +res.expiresIn)}))
  }

  logout() {
    this.userSub.next(null);
    localStorage.removeItem('userData')
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;
  }

  autoLogin() {
    const user: {
      email: string,
      id: string,
      _token: string,
      _tokenExpirationDate: string
    } = JSON.parse(localStorage.getItem('userData'))
    if (!user) {
      return
    }
    const loadUser = new User(user.email, user.id, user._token, new Date(user._tokenExpirationDate))
    if (loadUser.token) {
      this.userSub.next(loadUser);
      const expirationDuration = new Date(user._tokenExpirationDate).getTime() - new Date().getTime();
      this.autoLogout(expirationDuration);
    }
  }

  autoLogout(expirationDuration: number) {
    this.tokenExpirationTimer = setTimeout(() => { this.logout() }, expirationDuration)
    console.log(expirationDuration / 1000)
  }

  private handleAuthentication(email: string, userId: string, token: string, expireIn: number) {
    const expirationDate = new Date(new Date().getTime() + expireIn * 1000)
    const user = new User(email, userId, token, expirationDate);
    this.userSub.next(user);
    this.autoLogout(expireIn * 1000)
    localStorage.setItem('userData', JSON.stringify(user))
  }

  private handleError(err: HttpErrorResponse) {
    let errMess = 'An unknown error occur!'
    if (!err.error || !err.error.error) {
      return throwError(errMess)
    }
    switch (err.error.error.message) {
      case 'EMAIL_NOT_FOUND':
        errMess = 'Email not found!'
        break
      case 'INVALID_PASSWORD':
        errMess = 'Wrong password!'
        break
      case 'EMAIL_EXISTS':
        errMess = 'This email already exist!'
        break
    }
    return throwError(errMess);
  }
}
