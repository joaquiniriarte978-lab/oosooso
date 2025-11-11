import org.json.JSONObject;

import java.util.Objects;

public class Empleados {
    private int dni;
    private String nombre;
    private String puesto;
    private String turno;

    public Empleados(int dni, String puesto, String nombre, String turno) {
        this.dni = dni;
        this.puesto = puesto;
        this.nombre = nombre;
        this.turno = turno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("dni", dni);
        json.put("nombre", nombre);
        json.put("puesto", puesto);
        json.put("turno", turno);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Empleados empleados)) return false;
        return dni == empleados.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }
}
