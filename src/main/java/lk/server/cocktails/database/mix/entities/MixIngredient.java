//package lk.server.cocktails.database.mix.entities;
//
//import com.google.gson.annotations.Expose;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lk.server.cocktails.customtypes.cocktail.type.CocktailType;
//import lk.server.cocktails.customtypes.ingredient.volume.IngredientVolumeType;
//import lk.server.cocktails.customtypes.mix.state.MixState;
//import lk.server.cocktails.database.cocktail.entities.Cocktail;
//import lk.server.cocktails.database.ingredient.entities.Ingredient;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "MixIngredient")
//public class MixIngredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Expose
//    private Long mixIngredientId;
//
//    @OneToMany
//    private Ingredient ingredient;
//
//    private IngredientVolumeType volumeType;
//
//    private String volume;
//
//    public MixIngredient(Ingredient ingredient, IngredientVolumeType volumeType, String volume) {
//        this.ingredient = ingredient;
//        this.volumeType = volumeType;
//        this.volume = volume;
//    }
//}