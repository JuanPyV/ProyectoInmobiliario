
import java.io.*;

import java.util.Scanner;

public class LecturaCSV {

	private MyHashTable<String, datosInmobiliaria> lista;
	private int size;

	public LecturaCSV() {
		this.lista = new MyHashTable<String, datosInmobiliaria>();
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public MyHashTable<String, datosInmobiliaria> getLista() {
		return lista;
	}

	public void lecturaDatos() {
		int j;
		FileOutputStream fs;
		ObjectOutputStream os;
		try {
			fs = new FileOutputStream("datosInmueble.bin");
			os = new ObjectOutputStream(fs);
			for (int i = 0; i < this.lista.getTabla().length; i++) {
				j = 0;
				if (this.lista.getTabla()[i].size() > 0) {
					for (int l = 0; l < this.lista.getTabla()[i].size(); l++) {
						datosInmobiliaria datitos = this.lista.getTabla()[i].getEn(j).valor;
						j++;
						os.writeObject(datitos);
					}
				}
			}
			os.close();
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarDatos(File datos) {
		try {
			Scanner inputStream = new Scanner(datos);
			String data = inputStream.next();
			while (inputStream.hasNext()) {
				data = inputStream.next();
				String[] values = data.split(",");
				datosInmobiliaria objto = new datosInmobiliaria(values[0], values[1], values[2], values[3], values[4],
						values[5], values[6], values[7]);
				this.lista.put(objto.getRef(), objto);

			}
			this.size = this.lista.getSize();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public datosInmobiliaria encontrar(String ref) {
		return this.lista.get(ref);
	}
	
/* busca por tipo */
	public MiListaEnlazada<datosInmobiliaria> encontrarPorTipo(String tipo) {
		MiListaEnlazada<datosInmobiliaria> arreglo = new MiListaEnlazada<datosInmobiliaria>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].getEn(j).valor.getTipo().equals(tipo)) {
						arreglo.insertarFin(this.lista.getTabla()[i].getEn(j).valor);
					}
				}
			}
		}
		return arreglo;
	}
	
/* busca por vendedor */
	public MiListaEnlazada<datosInmobiliaria> encontrarPorVendedor(String vendedor) {
		MiListaEnlazada<datosInmobiliaria> arreglo = new MiListaEnlazada<datosInmobiliaria>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].getEn(j).valor.getVendedor().equals(vendedor)) {
						arreglo.insertarFin(this.lista.getTabla()[i].getEn(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

/* busca por tipo y provincia */
	public MiListaEnlazada<datosInmobiliaria> encontrarPorTipoProv(String tipo, String provincia) {
		MiListaEnlazada<datosInmobiliaria> arreglo = new MiListaEnlazada<datosInmobiliaria>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].getEn(j).valor.getTipo().equals(tipo)
							&& this.lista.getTabla()[i].getEn(j).valor.getProvincia().equals(provincia)) {
						arreglo.insertarFin(this.lista.getTabla()[i].getEn(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	/* busca por tipo y operacion */
	public MiListaEnlazada<datosInmobiliaria> encontrarPorTipoOpe(String tipo, String operacion) {
		MiListaEnlazada<datosInmobiliaria> arreglo = new MiListaEnlazada<datosInmobiliaria>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].getEn(j).valor.getTipo().equals(tipo)
							&& this.lista.getTabla()[i].getEn(j).valor.getOperacion().equals(operacion)) {
						arreglo.insertarFin(this.lista.getTabla()[i].getEn(j).valor);
					}
				}
			}
		}
		return arreglo;
	}
	
	/* bucar precio mayor */
	public MiListaEnlazada<datosInmobiliaria> encontrarPorPrecio(int precio) {
        MiListaEnlazada<datosInmobiliaria> arreglo = new MiListaEnlazada<datosInmobiliaria>();
        for (int i = 0; i < this.lista.getTabla().length; i++) {
            if (this.lista.getTabla()[i].size() > 0) {
                for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
                    int precioString = Integer.parseInt(this.lista.getTabla()[i].getEn(j).valor.getPrecio());
                    if (precio <= precioString) {
                        arreglo.insertarFin(this.lista.getTabla()[i].getEn(j).valor);
                    }
                }
            }
        }
        return arreglo;
    }
	
	/* bucar superficie mayor */
	public MiListaEnlazada<datosInmobiliaria> encontrarPorSuperficie(int superficie) {
        MiListaEnlazada<datosInmobiliaria> arreglo = new MiListaEnlazada<datosInmobiliaria>();
        for (int i = 0; i < this.lista.getTabla().length; i++) {
            if (this.lista.getTabla()[i].size() > 0) {
                for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
                    int supString = Integer.parseInt(this.lista.getTabla()[i].getEn(j).valor.getSuperficie());
                    if (superficie <= supString) {
                        arreglo.insertarFin(this.lista.getTabla()[i].getEn(j).valor);
                    }
                }
            }
        }
        return arreglo;
    }

	public void meterATabla(datosInmobiliaria dato) {
		this.lista.put(dato.getRef(), dato);
	}

	public static LecturaCSV cargarListaDatos(File datos) {
		try {
			FileInputStream fs = new FileInputStream(datos);
			ObjectInputStream os = new ObjectInputStream(fs);
			LecturaCSV inmobiliaria = new LecturaCSV();
			while (fs.available() > 0) {
				Object objeto = os.readObject();
				datosInmobiliaria inmueble = (datosInmobiliaria) objeto;
				inmobiliaria.meterATabla(inmueble);
			}
			os.close();
			return inmobiliaria;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {

		LecturaCSV lista = new LecturaCSV();
		lista.insertarDatos(new File("src/Inmuebles.csv"));
		lista.lecturaDatos();
		
		MiListaEnlazada<datosInmobiliaria> lista3 = lista.encontrarPorSuperficie(300);
        for (int i = 0; i < lista3.size(); i++) {
            datosInmobiliaria objeto = lista3.getEn(i);
            String datos = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() 
                            + ", " + objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio()
                            + ", " + objeto.getFechaV() + ", " + objeto.getVendedor();
            System.out.println(datos);
        }		
		
	}

}
