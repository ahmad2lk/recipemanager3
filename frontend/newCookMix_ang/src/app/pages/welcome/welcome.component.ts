import { Component, OnInit } from '@angular/core';
import { WelcomeService } from '../../serives/welcome.service';
import {Router} from "@angular/router";





@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss'],
})
export class WelcomeComponent {

  constructor(private welcomeService: WelcomeService,
              private router: Router) { }


}



