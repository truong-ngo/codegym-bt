import {HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";

export class AuthInterceptorService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const modifyReq = req.clone({
      headers: req.headers.append('Auth', 'JWT token')
    })
    return next.handle(modifyReq);
  }
}
