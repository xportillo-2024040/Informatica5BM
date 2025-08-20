package modelo;

public class Propiedad {

    private int codigoPropiedad;
    private String tipo; 
    private String direccion;
    private int numeroHabitaciones;
    private String precio;
    private int codigoPropietario; 

    public Propiedad() {
    }

    public Propiedad(int codigoPropiedad, String tipo, String direccion, int numeroHabitaciones, String precio, int codigoPropietario) {
        this.codigoPropiedad = codigoPropiedad;
        this.tipo = tipo;
        this.direccion = direccion;
        this.numeroHabitaciones = numeroHabitaciones;
        this.precio = precio;
        this.codigoPropietario = codigoPropietario;
    }

    public int getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(int codigoPropiedad) {
        this.codigoPropiedad = codigoPropiedad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCodigoPropietario() {
        return codigoPropietario;
    }

    public void setCodigoPropietario(int codigoPropietario) {
        this.codigoPropietario = codigoPropietario;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "codigoPropiedad=" + codigoPropiedad +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numeroHabitaciones=" + numeroHabitaciones +
                ", precio=" + precio +
                ", codigoPropietario=" + codigoPropietario +
                '}';
    }
}
