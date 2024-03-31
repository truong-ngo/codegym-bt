import { Component } from '@angular/core';
import { Pet } from '../pet';

@Component({
    selector: 'app-pet',
    templateUrl: './pet.component.html',
    styleUrls: ['./pet.component.css']
})
export class PetComponent {
    pet: Pet = {
        name: 'puppie',
        image: 'https://petsafari.com/wp-content/uploads/2020/07/pets.jpg'
    }
}
