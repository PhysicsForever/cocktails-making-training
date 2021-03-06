package lk.server.cocktails.database.cocktail.entities;

import com.google.gson.annotations.Expose;
import lk.server.cocktails.locale.ILocalization;
import lk.server.cocktails.locale.Locale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cocktail_association")
public class CocktailAssociation implements ILocalization {

    @Id
    @Column(name = "cocktail_association_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long cocktailAssociationId;

    @Column
    @Expose
    @NotNull
    private Locale locale;

    @Column
    @Expose
    @NotNull
    private String name;

    public CocktailAssociation(@NotNull Locale locale, @NotNull String name) {
        this.locale = locale;
        this.name = name;
    }
}
