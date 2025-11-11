import org.json.JSONObject;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /// Descargo el archivo a un String
        String contenido=JSONUtiles.downloadJSON("surtidores_y_empleados");
        /// De serialize e lo pase a un objeto y extraje tanto los empleados como los surtidores
        ContenidoArchivo contenidoArchivo=JSONUtiles.readJSON(contenido);
        ArrayList<Empleados> empleados=contenidoArchivo.extraerEmpleados();
        ArrayList<Surtidores>surtidores=contenidoArchivo.extraerSurtidores();
        /// Creo una clase generica de empleados y otra de surtidores
        Informacion<Empleados> n=new Informacion<Empleados>(empleados);
        Informacion<Surtidores> s=new Informacion<Surtidores>(surtidores);
        /// Cargo 2 cargas
        Cliente c=new Cliente(43893122,"nju623");
        Carga carga=new Carga(c,30888222,1,1000,2000.23);
        Carga carga2=new Carga(c,29999333,4,1000,2000.23);
        Registro registro=new Registro();
        /// Las agrego al registro
        registro.agregarCarga(carga);
        /// Paso los todo al sistema
        EstacionDeServicio estacionDeServicio=new EstacionDeServicio(n,registro,s);
        /// funciones del parcial
        Surtidores g=new Surtidores(12,2000);
        estacionDeServicio.agregarCombustible(g,new Combustible("Lucas Gimenez",1200.1));
       Empleados empleados1=new Empleados(47559511,"Playero","Joaquin","Noche");
        try {
            estacionDeServicio.agregarEmpleados(empleados1);
            estacionDeServicio.agregarCarga(carga2);
        } catch (accionImposibleEx e) {
            System.out.println(e.getMessage());
        }
        estacionDeServicio.recaudacionTotal();
        /// Cree un JSONOBJECT de todo EstacionDeServicio(el sistema),y no solo de Cargas
        JSONObject obj=estacionDeServicio.toJSON();
        JSONUtiles.uploadJSON(obj,"parcial");

    }
}