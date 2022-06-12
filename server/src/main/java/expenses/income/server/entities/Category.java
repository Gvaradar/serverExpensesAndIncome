package expenses.income.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    Long id;
    String name_category;

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_category() {
        return name_category;
    }
}