import org.json.JSONObject;

public class Carga {
    private int idSurtidor;
    private int dniEmpleado;
    private Cliente cliente;
    private int ltsCargados;
    private double totalVenta;

    public Carga(Cliente cliente, int dniEmpleado, int idSurtidor, int ltsCargados, double totalVenta) {
        this.cliente = cliente;
        this.dniEmpleado = dniEmpleado;
        this.idSurtidor = idSurtidor;
        this.ltsCargados = ltsCargados;
        this.totalVenta = totalVenta;
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("idSurtidor", idSurtidor);
        json.put("dniEmpleado", dniEmpleado);
        json.put("cliente", cliente.toJSON());
        json.put("ltsCargados", ltsCargados);
        json.put("totalVenta", totalVenta);
        return json;
    }
    public double recaudacionTotal(double aux){
        double total = 0;
        total=aux+getTotalVenta();
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getLtsCargados() {
        return ltsCargados;
    }

    public void setLtsCargados(int ltsCargados) {
        this.ltsCargados = ltsCargados;
    }

    public int getIdSurtidor() {
        return idSurtidor;
    }

    public void setIdSurtidor(int idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public int getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(int dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    @Override
    public String toString() {
        return "Carga{" +
                "cliente=" + cliente +
                ", idSurtidor=" + idSurtidor +
                ", dniEmpleado=" + dniEmpleado +
                ", ltsCargados=" + ltsCargados +
                ", totalVenta=" + totalVenta +
                '}';
    }
}
