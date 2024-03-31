import {Injectable, OnDestroy, OnInit} from "@angular/core";
import {Ingredient} from "../shared/ingredient.model";
import {Subject, Subscription} from "rxjs";

@Injectable()
export class ShoppingListService implements OnInit, OnDestroy {
  ingredients: Ingredient[];
  listIngredient = new Subject<Ingredient[]>()
  id: number;
  startEditIngredient = new Subject<number>();

  ngOnInit() {

  }

  getIngredient(id: number) {
    this.id = this.ingredients.length;
    return this.ingredients.find(
      (r: Ingredient) => {
        return r.id === id
      }
    )
  }

  addIngredient(ingredient: Ingredient) {
    this.id++;
    this.ingredients.push(ingredient)
    this.listIngredient.next(this.ingredients);
  }

  onEditIngredient(ingredient: Ingredient) {
    for (let i of this.ingredients) {
      if (i.id === ingredient.id) {
        i.name = ingredient.name;
        i.amount = ingredient.amount
      }
    }
    this.listIngredient.next(this.ingredients);
  }

  deleteIngredient(id: number) {
    let index;
    for (let i = 0; i < this.ingredients.length; i++) {
      if (this.ingredients[i].id === id) {
        index = i
      }
    }
    this.ingredients.splice(index, 1)
    this.listIngredient.next(this.ingredients)
  }

  ngOnDestroy() {

  }
}
