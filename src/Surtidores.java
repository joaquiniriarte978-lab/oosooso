import org.json.JSONObject;

import java.util.Objects;

public class Surtidores {
    private int id;
    private int litrosDisponibles;
    private Combustible combustible;

    public Surtidores(Combustible combustible, int litrosDisponibles, int id) {
        this.combustible = combustible;
        this.litrosDisponibles = litrosDisponibles;
        this.id = id;
    }
    public Surtidores(int id, int litrosDisponibles) {
        this.id = id;
        this.litrosDisponibles = litrosDisponibles;
        this.combustible = new Combustible();
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("litrosDisponibles", litrosDisponibles);
        json.put("combustible", combustible.toJSON());
        return json;
    }
    public void agregarCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public int getLitrosDisponibles() {
        return litrosDisponibles;
    }

    public void setLitrosDisponibles(int litrosDisponibles) {
        this.litrosDisponibles = litrosDisponibles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Surtidores that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Surtidores{" +
                "combustible=" + combustible +
                ", id=" + id +
                ", litrosDisponibles=" + litrosDisponibles +
                '}';
    }
}
