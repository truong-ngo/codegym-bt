import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HeaderComponent} from "./header/header.component";
import { RecipesComponent } from './recipes/recipes.component';
import { RecipeListComponent } from './recipes/recipe-list/recipe-list.component';
import { RecipeDetailComponent } from './recipes/recipe-detail/recipe-detail.component';
import { RecipeItemComponent } from './recipes/recipe-list/recipe-item/recipe-item.component';
import { ShoppingListComponent } from './shopping-list/shopping-list.component';
import { ShoppingEditComponent } from './shopping-list/shopping-edit/shopping-edit.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { DropdownDirective } from './directive/dropdown.directive';
import {ShoppingListService} from "./shopping-list/shopping-list.service";
import {RouterLink, RouterOutlet} from "@angular/router";
import {AppRoutingModule} from "./app-routing.module";
import {RecipeService} from "./recipes/recipe.service";
import { RecipeStartComponent } from './recipes/recipe-start/recipe-start.component';
import { RecipeEditComponent } from './recipes/recipe-edit/recipe-edit.component';
import { ShoppingListStartComponent } from './shopping-list/shopping-list-start/shopping-list-start.component';
import {DataStorageService} from "./shared/data-storage.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RecipesResolverService} from "./recipes/recipes-resolver.service";
import {AuthComponent} from "./auth/auth.component";
import {AuthService} from "./auth/auth.service";
import { LoadingSpinerComponent } from './shared/loading-spiner/loading-spiner.component';
import {AuthInterceptorService} from "./auth/auth-interceptor.service";
import {AuthGuard} from "./auth/auth.guard";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RecipesComponent,
    RecipeListComponent,
    RecipeDetailComponent,
    RecipeItemComponent,
    ShoppingListComponent,
    ShoppingEditComponent,
    DropdownDirective,
    RecipeStartComponent,
    RecipeEditComponent,
    ShoppingListStartComponent,
    AuthComponent,
    LoadingSpinerComponent
  ],
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule
    ],
  providers: [ShoppingListService, RecipeService, DataStorageService, RecipesResolverService, AuthService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
