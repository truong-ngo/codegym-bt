import {Component, OnDestroy, OnInit} from '@angular/core';
import { Ingredient } from "../shared/ingredient.model";
import {ShoppingListService} from "./shopping-list.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit, OnDestroy {
  ingredients: Ingredient[];
  subscription: Subscription

  constructor(public shoppingListService: ShoppingListService) {
  }

  ngOnInit(): void {
    this.ingredients = this.shoppingListService.ingredients;
    this.subscription = this.shoppingListService.listIngredient.subscribe(
      (listIngredient: Ingredient[]) => {
        this.ingredients = listIngredient;
      }
    )
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  editIngredient(id: number) {
    this.shoppingListService.startEditIngredient.next(id)
  }
}
