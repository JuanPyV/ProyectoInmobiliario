
public class datosInmobiliaria {

	private String ref, fechaA, tipo, operacion, provincia, superficie, precio, fechaV, vendedor;

	public datosInmobiliaria(String ref, String fechaA, String tipo, String operacion, String provincia,
			String superficie, String precio, String fechaV, String vendedor) {
		super();
		this.ref = ref;
		this.fechaA = fechaA;
		this.tipo = tipo;
		this.operacion = operacion;
		this.provincia = provincia;
		this.superficie = superficie;
		this.precio = precio;
		this.fechaV = fechaV;
		this.vendedor = vendedor;
	}

	public String getRef() {
		return ref;
	}

	public String getFechaA() {
		return fechaA;
	}

	public String getTipo() {
		return tipo;
	}

	public String getOperacion() {
		return operacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getSuperficie() {
		return superficie;
	}

	public String getPrecio() {
		return precio;
	}

	public String getFechaV() {
		return fechaV;
	}

	public String getVendedor() {
		return vendedor;
	}
	
		
}
