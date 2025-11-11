import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Informacion<T> {
    private ArrayList<T> lista;

    public Informacion(ArrayList<T> lista) {
        this.lista = lista;
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (T item : lista) {
            if (item instanceof Surtidores) {
                jsonArray.put(((Surtidores) item).toJSON());
            }else if (item instanceof Empleados) {
                jsonArray.put((((Empleados) item).toJSON()));
            }
        }
        json.put("lista", jsonArray);
        return json;
    }
    public boolean retornarLtsSurtidor(int lts){
        int i=0;
        for(T surtidor:lista){
            if(surtidor instanceof Surtidores){
                if(lts<((Surtidores) surtidor).getLitrosDisponibles()){
                    ((Surtidores) surtidor).setLitrosDisponibles(((Surtidores) surtidor).getLitrosDisponibles()-lts);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean traerDni(int dni){
        for(T elemento : lista){
            if(elemento instanceof Empleados){
                if(((Empleados)elemento).getDni() == dni) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean traeridSurtidor(int id) {
        int i = 0;
        for (T surtidor : this.lista) {
            if (surtidor instanceof Surtidores) {
                if (((Surtidores) surtidor).getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public void agregar(T elemento) throws  elementoDuplicadoEx{
        if(elemento instanceof Empleados) {
            for(T element:lista) {
                if(element.equals(elemento)){
                    throw new elementoDuplicadoEx("El empleado ya se encuentra entre la informacion");
                }
            }
        }
        lista.add(elemento);
    }
    public void verInfo(int enteroAbuscar){
        for(T elemento:lista){
            if(elemento instanceof Empleados){
                if(elemento.equals(enteroAbuscar)){
                    System.out.println(elemento);
                }
            } else if (elemento instanceof Surtidores) {
                if(elemento.equals(enteroAbuscar)){
                    System.out.println(elemento);
                }
            }
        }
    }
    public boolean siExiste(int enteroAbuscar){
        for(T elemento:lista){
            if(elemento instanceof Empleados){
                if(elemento.equals(enteroAbuscar)){
                    System.out.println("El empleado existe en el sistema");
                    return true;
                }
            } else if (elemento instanceof Surtidores) {
                if(elemento.equals(enteroAbuscar)){
                    System.out.println("El surtidor existe en el sistema");
                    return true;
                }
            }
        }
        return false;
    }
    public Informacion() {
        this.lista = new ArrayList<>();
    }


    public ArrayList<T> getLista() {
        return lista;
    }

    public void setLista(ArrayList<T> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "lista=" + lista +
                '}';
    }
}
