package modelo;

public class Propietario {

    private int codigoPropietario;
    private String nombre;
    private String telefono;

    public Propietario() {
    }

    public Propietario(int codigoPropietario, String nombre, String telefono) {
        this.codigoPropietario = codigoPropietario;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getCodigoPropietario() {
        return codigoPropietario;
    }

    public void setCodigoPropietario(int codigoPropietario) {
        this.codigoPropietario = codigoPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Propietario{" + 
                "codigoPropietario=" + codigoPropietario + 
                ", nombre='" + nombre + '\'' + 
                ", telefono='" + telefono + '\'' + 
                '}';
    }
}
