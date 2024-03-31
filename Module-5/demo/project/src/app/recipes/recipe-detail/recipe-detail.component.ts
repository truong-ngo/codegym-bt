import {Component, OnInit} from '@angular/core';
import {Recipe} from "../recipe.model";
import {RecipeService} from "../recipe.service";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  recipe: Recipe
  id: number

  constructor(public recipeService: RecipeService,
              private route: ActivatedRoute,
              private router: Router) {}

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['id']
        this.recipe = this.recipeService.getRecipe(this.id)
        this.recipeService.slService.id = this.id;
      }
    )
  }

  addIngredientToShoppingList() {
    this.recipeService.addIngredientToShoppingList(this.recipe.ingredients);
    this.router.navigate(['/shopping-list'])
  }

  deleteRecipe(id: number) {
    this.recipeService.deleteRecipe(id);
    this.router.navigate(['../'], {relativeTo: this.route})
  }
}
