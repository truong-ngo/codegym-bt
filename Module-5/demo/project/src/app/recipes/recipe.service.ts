import {Injectable, OnDestroy, OnInit} from "@angular/core";
import {Recipe} from "./recipe.model";
import {Ingredient} from "../shared/ingredient.model";
import {ShoppingListService} from "../shopping-list/shopping-list.service";
import {Subject, Subscription} from "rxjs";

@Injectable()
export class RecipeService implements OnInit, OnDestroy {
  recipesChange = new Subject<Recipe[]>();
  subscription: Subscription

  recipes: Recipe[] = []

  ngOnInit() {
    this.subscription = this.recipesChange.subscribe(
      (recipes: Recipe[]) => {
        this.recipes = recipes
      }
    )

  }

  constructor(public slService: ShoppingListService) {}

  addIngredientToShoppingList(ingredients: Ingredient[]) {
    this.slService.ingredients = ingredients;
    this.slService.id = ingredients.length;
  }

  setRecipes(recipes: Recipe[]) {
    this.recipes = recipes;
    this.recipesChange.next(this.recipes)
    console.log(recipes)
  }

  getRecipe(id: number) {
    console.log(this.recipes)
    return this.recipes.find(
      (r: Recipe) => {
        return r.id === id
      }
    )
  }

  getRecipes() {
    return this.recipes
  }

  addRecipe(recipe: Recipe) {
    this.recipes.push(recipe)
    this.recipesChange.next(this.recipes)
  }

  updateRecipe(recipe: Recipe) {
    for (let r of this.recipes) {
      if (r.id === recipe.id) {
        r.name = recipe.name;
        r.imagePath = recipe.imagePath
        r.description = recipe.description
        r.ingredients = recipe.ingredients
      }
    }
    this.recipesChange.next(this.recipes)
  }

  deleteRecipe(id: number) {
    let index;
    for (let i = 0; i < this.recipes.length; i++) {
      if (this.recipes[i].id === id) {
        index = i;
      }
    }
    this.recipes.splice(index, 1);
    this.recipesChange.next(this.recipes)
  }

  deleteIngredient(id: number) {
    let index;
    let ingredients = this.recipes[this.slService.id].ingredients
    for (let i = 0; i < ingredients.length; i++) {
      if (ingredients[i].id === id) {
        index = i
      }
    }
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
