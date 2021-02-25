package lk.server.cocktails.features.init.services;

import lk.server.cocktails.features.cocktail.entities.Cocktail;
import lk.server.cocktails.features.cocktail.services.CocktailService;
import lk.server.cocktails.features.ingredient.entities.Ingredient;
import lk.server.cocktails.features.ingredient.services.IngredientService;
import lk.server.cocktails.features.init.dto.CocktailDto;
import lk.server.cocktails.features.init.dto.CocktailMixDto;
import lk.server.cocktails.features.init.dto.InitDbDto;
import lk.server.cocktails.features.init.mappers.RowMapperCocktail;
import lk.server.cocktails.features.init.mappers.RowMapperCocktailMixDto;
import lk.server.cocktails.features.mix.services.MixCocktailService;
import lk.server.cocktails.features.modes.entities.GameMode;
import lk.server.cocktails.features.modes.service.GameModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitDbService {

    @Autowired
    private GameModeService gameModeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private CocktailService cocktailService;

    @Autowired
    private MixCocktailService mixCocktailService;

    @Autowired
    private RowMapperCocktail rowMapperCocktail;

    @Autowired
    private RowMapperCocktailMixDto rowMapperCocktailMixDto;

    public void init(InitDbDto dtos) {
        List<GameMode> gameModes = initModes(dtos.getGameModes());
        List<Ingredient> ingredients = initIngredients(dtos.getIngredients());
        List<Cocktail> cocktails = initCocktails(dtos.getCocktailsDto());
        List<Cocktail> mixedCocktails = mixCocktails(cocktails, dtos.getCocktailsDto(), ingredients);
    }

    private List<GameMode> initModes(List<GameMode> gameModes) {
        return gameModeService.saveAll(gameModes);
    }

    private List<Ingredient> initIngredients(List<Ingredient> ingredients) {
        return ingredientService.saveAll(ingredients);
    }

    private List<Cocktail> initCocktails(List<CocktailDto> cocktailsDto) {
        List<Cocktail> cocktails = cocktailsDto.stream()
                .map(it -> rowMapperCocktail.join(it)).collect(Collectors.toList());
        return cocktailService.saveAll(cocktails);
    }

    private List<Cocktail> mixCocktails(List<Cocktail> cocktails, List<CocktailDto> cocktailsDto, List<Ingredient> ingredients) {
        List<CocktailMixDto> cocktailsMixDto = rowMapperCocktailMixDto.join(cocktails, cocktailsDto, ingredients);
        return mixCocktailService.addIngredientsByCocktailMixDto(cocktailsMixDto);
    }

}