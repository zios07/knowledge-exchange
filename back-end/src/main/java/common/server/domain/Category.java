package common.server.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CATEGORY_TABLE")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String code;

    private String label;

    public Category(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(code, category.code) &&
                Objects.equals(label, category.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, label);
    }
}
