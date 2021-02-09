package lk.server.cocktails.database.cocktail.entities;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lk.server.cocktails.customtypes.locale.ILocalization;
import lk.server.cocktails.customtypes.locale.Locale;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CocktailGarnish")
public class CocktailGarnish implements ILocalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long cocktailGarnishId;

    @Column
    @Expose
    @NotNull
    private Locale locale;

    @Column
    @Expose
    @NotNull
    private String name;

    public CocktailGarnish(@NotNull Locale locale, @NotNull String name) {
        this.locale = locale;
        this.name = name;
    }
}