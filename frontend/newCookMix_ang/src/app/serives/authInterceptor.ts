import {Injectable} from "@angular/core";
import {
  HttpRequest,
  HttpEvent, HttpHandler
  , HttpInterceptor, HTTP_INTERCEPTORS
} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "./authentication.service";
import {getXHRResponse} from "rxjs/internal/ajax/getXHRResponse";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private authService: AuthenticationService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authService.isLoggedIn()) {
      const token = this.authService.getAccessToken(); // Adjust this based on your service

      // Clone the request and add the authorization header
      const authReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });

      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
}
 export const AuthInterceptorProvider = {
   provide: HTTP_INTERCEPTORS,
   useClass: AuthInterceptor,
   multi: true,
 }
