package be.ifosup.todo;

public class Todo {
    //attributs
    private String nom;
    private String categorie;

    public Todo(String nom, String categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;

        Todo todo = (Todo) o;

        if (getNom() != null ? !getNom().equals(todo.getNom()) : todo.getNom() != null) return false;
        return getCategorie() != null ? getCategorie().equals(todo.getCategorie()) : todo.getCategorie() == null;
    }

    @Override
    public int hashCode() {
        int result = getNom() != null ? getNom().hashCode() : 0;
        result = 31 * result + (getCategorie() != null ? getCategorie().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
