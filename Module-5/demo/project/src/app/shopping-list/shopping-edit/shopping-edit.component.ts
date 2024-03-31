import {Component, ElementRef, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {Ingredient} from "../../shared/ingredient.model";
import {ShoppingListService} from "../shopping-list.service";
import {NgForm} from "@angular/forms";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit, OnDestroy {
  @ViewChild('shoppingEditForm') editForm: NgForm
  subscription: Subscription
  editIngredient: Ingredient = new Ingredient(null, null, null)
  editMode = false;

  constructor(public shoppingListService: ShoppingListService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.subscription = this.shoppingListService.startEditIngredient.subscribe(
       (id: number) => {
        this.editMode = true
        this.editIngredient = this.shoppingListService.getIngredient(id)
        this.editForm.setValue({
          name: this.editIngredient.name,
          amount: this.editIngredient.amount
        })
      }
    )
  }

  onSubmit() {
    if (this.editMode) {
      let updateIngredient = new Ingredient(
        this.editIngredient.id,
        this.editForm.value.name,
        this.editForm.value.amount
      )
      this.onEditIngredient(updateIngredient)
    } else {
      this.addIngredient()
    }
    this.editForm.resetForm()
    this.editMode = false;
  }

  addIngredient() {
    let ingredient = new Ingredient(this.shoppingListService.id, this.editForm.value.name, this.editForm.value.amount);
    this.shoppingListService.addIngredient(ingredient);
  }

  onEditIngredient(ingredient: Ingredient) {
    this.shoppingListService.onEditIngredient(ingredient)
  }

  clearIngredientForm() {
    this.editForm.resetForm();
    this.editMode = false
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  onDeleteIngredient() {
    this.editForm.resetForm();
    this.shoppingListService.deleteIngredient(this.editIngredient.id)
  }
}
