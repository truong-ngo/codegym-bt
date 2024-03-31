import {Component, OnInit} from '@angular/core';
import {Recipe} from "../recipe.model";
import {RecipeService} from "../recipe.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {FormArray, FormControl, FormGroup, Validators} from "@angular/forms";
import {Ingredient} from "../../shared/ingredient.model";

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
  styleUrls: ['./recipe-edit.component.css']
})
export class RecipeEditComponent implements OnInit {
  recipe: Recipe
  id: number
  editMode = false;
  recipeForm: FormGroup;

  constructor(private recipeService: RecipeService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.editMode = params['id'] !== undefined;
        if (this.editMode) {
          this.recipe = this.recipeService.getRecipe(this.id);
        }
        this.initForm()
        // this.recipeService.slService.ingredients = this.recipe.ingredients
      }
    )
  }

  initForm() {
    let recipeName = '';
    let recipeDescription = '';
    let recipeImagePath = '';
    let ingredients = new FormArray([]);

    if (this.editMode) {
      const recipe = this.recipeService.getRecipe(this.id);
      recipeName = recipe.name;
      recipeDescription = recipe.description;
      recipeImagePath = recipe.imagePath;
      if (recipe.ingredients) {
        for (let ingredient of recipe.ingredients) {
          ingredients.push(new FormGroup({
            'name': new FormControl(ingredient.name, Validators.required),
            'amount': new FormControl(ingredient.amount, [Validators.required, Validators.pattern(/^[1-9]+[0-9]*$/)])
          }))
        }
      }
    }

    this.recipeForm = new FormGroup({
      'name': new FormControl(recipeName, Validators.required),
      'description': new FormControl(recipeDescription, Validators.required),
      'imagePath': new FormControl(recipeImagePath, Validators.required),
      'ingredients': ingredients
    })

    this.recipeForm.statusChanges.subscribe((status) => {
      console.log(status)
    })
  }

  onSubmit() {
    const recipe = new Recipe(null, this.recipeForm.value.name, this.recipeForm.value.description, this.recipeForm.value.imagePath, this.recipeForm.value.ingredients)
    if (this.editMode) {
      recipe.id = this.recipe.id
      this.recipeService.updateRecipe(recipe);
    } else {
      recipe.id = this.recipeService.recipes.length + 1
      this.recipeService.addRecipe(recipe);
    }
    this.editMode = false;
    this.router.navigate(['../'], {relativeTo: this.route})
  }

  getIngredients() {
    return (<FormArray>this.recipeForm.get('ingredients')).controls
  }

  onAddIngredient() {
    (<FormArray>this.recipeForm.get('ingredients')).push(new FormGroup({
      'name': new FormControl(null, Validators.required),
      'amount': new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]+[0-9]*$/)])
    }))
  }

  deleteIngredient(index) {
    (<FormArray>this.recipeForm.get('ingredients')).removeAt(index)
  }
}
