package modelo;

public class ClienteDTO 
{
	//atributos, se accede por el get y set
	private String cedula_cliente;
	private String telefono_cliente;
	private String nombre_cliente;
	private String email_cliente;
	private String direccion_cliente;
	
	public ClienteDTO(String cedula_cliente, String telefono_cliente, String nombre_cliente, String email_cliente,
			String direccion_cliente)
	{
		super();
		this.cedula_cliente = cedula_cliente;
		this.telefono_cliente = telefono_cliente;
		this.nombre_cliente = nombre_cliente;
		this.email_cliente = email_cliente;
		this.direccion_cliente = direccion_cliente;
	}

	public String getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	
	
}
