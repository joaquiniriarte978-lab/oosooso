import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumMap;

public class JSONUtiles {
    public static void uploadJSON(JSONArray jsonArray, String archive){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archive+".json"));
            salida.write(jsonArray.toString());
            salida.flush();
            salida.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void uploadJSON(JSONObject jsonObject, String archive){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archive+".json"));
            salida.write(jsonObject.toString());
            salida.flush();
            salida.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String downloadJSON(String archive){
        StringBuilder contenido = new StringBuilder();
        String lectura= "";
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(archive+".json"));
            while((lectura = entrada.readLine())!=null){
                contenido.append(lectura);
            }
            entrada.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return contenido.toString();
    }
    public static ContenidoArchivo readJSON(String archive){
        ContenidoArchivo contenido=null;
        JSONObject json=new JSONObject(archive);
        JSONArray surtidores=json.getJSONArray("surtidores");
        ArrayList<Surtidores> surtidoresArrayList=new ArrayList<Surtidores>();
        for(int i=0;i<surtidores.length();i++){
            JSONObject surtidor=surtidores.getJSONObject(i);
            int id=surtidor.getInt("id");
            int litrosDisponibles=surtidor.getInt("litrosDisponibles");
            JSONObject combustible=surtidor.getJSONObject("combustible");
            String nombre=combustible.getString("nombre");
            double precioLitro=combustible.getDouble("precioLitro");
            Combustible combustible1=new Combustible(nombre,precioLitro);
            surtidoresArrayList.add(new Surtidores(combustible1,litrosDisponibles,id));
        }
        JSONArray empleados=json.getJSONArray("empleados");
        ArrayList<Empleados>empleadosArrayList=new ArrayList<>();
        for(int j=0;j<empleados.length();j++){
            JSONObject empleado=empleados.getJSONObject(j);
            int dni=empleado.getInt("dni");
            String nombre=empleado.getString("nombre");
            String puesto=empleado.getString("puesto");
            String turno=empleado.getString("turno");
            Empleados e=new Empleados(dni,nombre,puesto,turno);
            empleadosArrayList.add(e);
        }
        contenido=new ContenidoArchivo(empleadosArrayList,surtidoresArrayList);
        return contenido;
    }

}
