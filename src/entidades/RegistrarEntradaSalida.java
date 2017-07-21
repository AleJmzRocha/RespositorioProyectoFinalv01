package entidades;

public class RegistrarEntradaSalida{
        Integer idEmpleado;
	String registrarDia, registrarEntrada, registrarSalida;

	public RegistrarEntradaSalida(Integer idEmpleado, String registrarEntrada, String registrarSalida, String registrarDia) {
		this.idEmpleado = idEmpleado;
		this.registrarDia = registrarDia;
		this.registrarEntrada = registrarEntrada;
		this.registrarSalida = registrarSalida;
	}

        public RegistrarEntradaSalida(Integer idEmpleado, String registrarSalida){
            this.idEmpleado = idEmpleado;
            this.registrarSalida = registrarSalida;
        }
        
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getRegistrarDia() {
		return registrarDia;
	}

	public void setRegistrarDia(String registrarDia) {
		this.registrarDia = registrarDia;
	}

	public String getRegistrarEntrada() {
		return registrarEntrada;
	}

	public void setRegistrarEntrada(String registrarEntrada) {
		this.registrarEntrada = registrarEntrada;
	}

	public String getRegistrarSalida() {
		return registrarSalida;
	}

	public void setRegistrarSalida(String registrarSalida) {
		this.registrarSalida = registrarSalida;
	}
}
