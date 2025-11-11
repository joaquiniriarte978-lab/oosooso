import org.json.JSONObject;

public class Cliente {
    private int dniConductor;
    private String patente;

    public Cliente(int dniConductor, String patente) {
        this.dniConductor = dniConductor;
        this.patente = patente;
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("dniConductor", this.dniConductor);
        json.put("patente", this.patente);
        return json;
    }

    public int getDniConductor() {
        return dniConductor;
    }

    public void setDniConductor(int dniConductor) {
        this.dniConductor = dniConductor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dniConductor=" + dniConductor +
                ", patente='" + patente + '\'' +
                '}';
    }
}