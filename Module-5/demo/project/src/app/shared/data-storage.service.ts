import {Injectable, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {RecipeService} from "../recipes/recipe.service";
import {Recipe} from "../recipes/recipe.model";
import {tap} from "rxjs";

@Injectable()
export class DataStorageService implements OnInit {

  constructor(private http: HttpClient, private recipeService: RecipeService) {
  }

  ngOnInit(): void {
    this.fetchRecipes();
  }

  storeRecipes() {
    const recipes = this.recipeService.getRecipes()
    this.http.put('https://recipe-book-4dd61-default-rtdb.firebaseio.com/recipes.json', recipes).subscribe(
      response => {
        console.log(response)
      }
    )
  }

  fetchRecipes() {
    return this.http.get<Recipe[]>('https://recipe-book-4dd61-default-rtdb.firebaseio.com/recipes.json')
      .pipe(tap(data => {
        this.recipeService.setRecipes(data);
      })
    )
  }
}
