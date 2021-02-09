package lk.server.cocktails.features.init.dto.help;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavedCocktailsDto2 {
    private Long cocktailId;
    private String cocktailName;
    private List<Long> ingredientIds;
}