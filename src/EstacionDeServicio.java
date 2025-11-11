import org.json.JSONObject;

import java.util.ArrayList;

public class EstacionDeServicio {
    private Informacion<Surtidores> surtidores;
    private Informacion<Empleados> empleados;
    private Registro registro;
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("surtidores", this.surtidores.toJSON());
        json.put("empleados", this.empleados.toJSON());
        json.put("registro", this.registro.toJSON());
        return json;
    }
    public EstacionDeServicio(Informacion<Empleados> empleados, Registro registro, Informacion<Surtidores> surtidores) {
        this.empleados = empleados;
        this.registro = registro;
        this.surtidores = surtidores;
    }
    public EstacionDeServicio(Informacion<Empleados> empleados) {
        this.empleados = empleados;
        this.surtidores = surtidores;
        Registro registro = new Registro();
    }
    public void agregarCarga(Carga carga)throws accionImposibleEx {
        boolean idEmpleados=empleados.traerDni(carga.getDniEmpleado());
        boolean idSurtidores=surtidores.traeridSurtidor(carga.getIdSurtidor());
        if(idEmpleados&&idSurtidores){
            boolean lts=surtidores.retornarLtsSurtidor(carga.getLtsCargados());
            if (lts) {
                registro.agregarCarga(carga);
            }else {
                throw new accionImposibleEx("soy un virgo");
            }
        }else{
            throw new accionImposibleEx("El surtidor y/o empleado no existe, y/o no hay suficiente combustible");
        }
        }
        public void recaudacionTotal(){
        registro.recaudacionTotal();
        }

    public void agregarEmpleados(Empleados emplead) {
        try {
            empleados.agregar(emplead);
        } catch (elementoDuplicadoEx e) {
            System.out.println(e.getMessage());
        }
    }
    public void agregarCombustible(Surtidores a,Combustible combustible) {
       a.agregarCombustible(combustible);
       try {
           surtidores.agregar(a);
       } catch (elementoDuplicadoEx e) {
           System.out.println(e.getMessage());
       }
    }
    public void agregarSurtidores(int id, int ltsCargados) {
        for(Surtidores s:surtidores.getLista()){
            if(s.getId()==id){
                s.setLitrosDisponibles(s.getLitrosDisponibles()+ltsCargados);
            }
        }
    }
}
