package entidades;

public class Empleado {

    Integer idEmpleado, telefonoCelular, numeroEmergencia, idDepartamento;
    String nombrePila, apellidoPaterno, apellidoMaterno, direccion, estado;

    public Empleado(Integer idEmpleado, String nombrePila, String apellidoPaterno, String apellidoMaterno,
            String direccion, Integer telefonoCelular, Integer numeroEmergencia, Integer idDepartamento,
            String estado) {
        this.idEmpleado = idEmpleado;
        this.telefonoCelular = telefonoCelular;
        this.numeroEmergencia = numeroEmergencia;
        this.nombrePila = nombrePila;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.estado = estado;
        this.idDepartamento = idDepartamento;
    }
//
//    public Empleado(String nombrePila, String apellidoPaterno, String apellidoMaterno,
//            String direccion, Integer telefonoCelular, Integer numeroEmergencia) {
//        this.telefonoCelular = telefonoCelular;
//        this.numeroEmergencia = numeroEmergencia;
//        this.nombrePila = nombrePila;
//        this.apellidoPaterno = apellidoPaterno;
//        this.apellidoMaterno = apellidoMaterno;
//        this.direccion = direccion;
//    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(Integer telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public Integer getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(Integer numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
