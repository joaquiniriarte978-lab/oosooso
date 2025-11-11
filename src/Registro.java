import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Registro {
    private ArrayList<Carga> carga;

    public Registro(ArrayList<Carga> carga) {
        this.carga = carga;
    }
    public Registro() {
        this.carga = new ArrayList<>();
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Carga carga : this.carga) {
            jsonArray.put(carga.toJSON());
        }
        json.put("carga", jsonArray);
        return json;
    }
    public void recaudacionTotal(){
        double total = 0;
        for (Carga c : carga){
            total=+c.recaudacionTotal(total);
        }
        System.out.println("Total Recaudacion: "+total);
    }

    public void agregarCarga(Carga carga) {
        this.carga.add(carga);
    }

    public ArrayList<Carga> getCarga() {
        return carga;
    }

    public void setCarga(ArrayList<Carga> carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "carga=" + carga +
                '}';
    }
}
