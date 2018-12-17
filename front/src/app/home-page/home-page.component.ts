import { Component, OnInit, HostListener } from '@angular/core';
import {Title, Meta} from "@angular/platform-browser";
import {
  trigger,
  state,
  style,
  animate,
  transition
} from '@angular/animations';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
  animations: [
    trigger('getData', [
      state('inactive', style({
        opacity: 0
      })),
      state('active',   style({
        opacity: 1
      })),
      transition('inactive => active', animate('500ms ease-in')),
    ])
  ]
})
export class HomePageComponent implements OnInit {

  getData = 'inactive';

  constructor(private titleService: Title, private metaService: Meta) {
    window.scrollTo(0,0);
    this.metaService.addTag({name:"description",content:"Сервис экономии. Товары на скидках и акциях в магазинах и торговых сетях. Составьте свой список покупок, распечайте его или перешлите в Viber."});
  }

  ngOnInit() {
    this.titleService.setTitle('Акции и скидки в магазинах Минска и других городах - Наакции.бай.');
  }

  @HostListener('window:scroll', ['$event'])
  onWindowScroll() {
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
      document.getElementById("up-btn").style.display = "block";
      this.getData = 'active';
    } else {
      document.getElementById("up-btn").style.display = "none";
      this.getData = 'inactive';
    }
  }

  clickToTop() {
    document.documentElement.scrollTop = 0;
  }

}
