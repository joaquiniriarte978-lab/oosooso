import java.util.ArrayList;

public class ContenidoArchivo {
    private ArrayList<Surtidores> surtidores;
    private ArrayList<Empleados> empleados;

    public ContenidoArchivo(ArrayList<Empleados> empleados, ArrayList<Surtidores> surtidores) {
        this.empleados = empleados;
        this.surtidores = surtidores;
    }
    public ArrayList<Surtidores> extraerSurtidores() {
        return surtidores;
    }
    public ArrayList<Empleados> extraerEmpleados() {
        return empleados;
    }

    public ArrayList<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleados> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Surtidores> getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(ArrayList<Surtidores> surtidores) {
        this.surtidores = surtidores;
    }

    @Override
    public String toString() {
        return "ContenidoArchivo{" +
                "empleados=" + empleados +
                ", surtidores=" + surtidores +
                '}';
    }
}
