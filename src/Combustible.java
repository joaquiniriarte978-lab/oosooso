import org.json.JSONObject;

public class Combustible {
    private String nombre;
    private double precioLitro;

    public Combustible(String nombre, double precioLitro) {
        this.nombre = nombre;
        this.precioLitro = precioLitro;
    }
    public Combustible(){
        this.nombre = "";
        this.precioLitro = 0;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        json.put("nombre", nombre);
        json.put("precioLitro", precioLitro);
        return json;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioLitro() {
        return precioLitro;
    }

    public void setPrecioLitro(double precioLitro) {
        this.precioLitro = precioLitro;
    }

    @Override
    public String toString() {
        return "Combustible{" +
                "nombre='" + nombre + '\'' +
                ", precioLitro=" + precioLitro +
                '}';
    }
}
