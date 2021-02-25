package lk.server.cocktails.features.init.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lk.server.cocktails.features.cocktail.entities.Cocktail;
import lk.server.cocktails.features.ingredient.entities.Ingredient;
import lk.server.cocktails.features.init.dto.CocktailDto;
import lk.server.cocktails.features.init.services.parent.InitDbService;
import lk.server.cocktails.features.modes.entities.GameMode;
import lk.utils.files.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class InitDbByFileService extends InitDbService {

    @Autowired
    private FileManager fileManager;

    @Autowired
    @Qualifier("Gson")
    private Gson gson;

    public void init() throws IOException {
        List<GameMode> readGameModes = readGameModesMethod();
        List<GameMode> gameModes = initModes(readGameModes);
        List<Ingredient> readIngredients = readIngredientsMethod();
        List<Ingredient> ingredients = initIngredients(readIngredients);
        List<CocktailDto> readCocktails = readCocktailsDtoMethod();
        List<Cocktail> cocktails = initCocktails(readCocktails);
        List<Cocktail> mixedCocktails = mixCocktails(cocktails, readCocktails, ingredients);
    }

    private List<GameMode> readGameModesMethod() throws IOException {
        String readGameModes = fileManager.readString("src/main/resources/db_new/modes.json");
        return gson.fromJson(readGameModes, getGameModeTypeList());
    }

    private List<Ingredient> readIngredientsMethod() throws IOException {
        String readIngredients = fileManager.readString("src/main/resources/db_new/ingredients.json");
        return gson.fromJson(readIngredients, getIngredientsTypeList());
    }

    private List<CocktailDto> readCocktailsDtoMethod() throws IOException {
        String readCocktails = fileManager.readString("src/main/resources/db_new/cocktails.json");
        return gson.fromJson(readCocktails, getCocktailTypeList());
    }

    private Type getGameModeTypeList() {
        return new TypeToken<List<GameMode>>() {
        }.getType();
    }

    private Type getIngredientsTypeList() {
        return new TypeToken<List<Ingredient>>() {
        }.getType();
    }

    private Type getCocktailTypeList() {
        return new TypeToken<List<CocktailDto>>() {
        }.getType();
    }

}
