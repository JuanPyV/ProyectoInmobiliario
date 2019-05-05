import java.util.NoSuchElementException;

public class MyHashTable<K, V> {
	
	private MiListaEnlazada<MyNodoHash<K, V>>[] tabla;
	private int size;
	private static final double LOAD_FACTOR = 0.75;
	
	@SuppressWarnings("unchecked")
	public MyHashTable() {
		this.tabla = (MiListaEnlazada<MyNodoHash<K, V>>[]) new MiListaEnlazada[11];
		for(int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new MiListaEnlazada<>();
		}
		this.size = 0;
	}
	
	public void put(K llave, V valor) {
		int pos = llave.hashCode() % this.tabla.length;
		if (pos < 0) {
			pos = pos * -1;
		}
		this.tabla[pos].insertarFin(new MyNodoHash<>(llave, valor));
		this.size++;
		if (((double) this.size) / this.tabla.length > MyHashTable.LOAD_FACTOR) {
			rehashing();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void rehashing() {
		MiListaEnlazada<MyNodoHash<K, V>>[] temporal = this.tabla;
		this.tabla = (MiListaEnlazada<MyNodoHash<K, V>>[]) new MiListaEnlazada[this.tabla.length * 2 + 1];
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new MiListaEnlazada<>();
		}
		for (int i = 0; i < temporal.length; i++) {
			if (temporal[i].size() > 0) {
				for (int j = 0; j < temporal[i].size(); j++) {
					int pos = temporal[i].getEn(j).llave.hashCode() % this.tabla.length;
					if (pos < 0) {
						pos = pos * -1;
					}
					this.tabla[pos].insertarFin(temporal[i].getEn(j));
				}
			}
		}
	}
	
	public V get(K llave) {
		int pos = llave.hashCode() % this.tabla.length;
		if (pos < 0) {
			pos = pos * -1;
		}
		for (int i = 0; i < this.tabla[pos].size(); i++) {
			if (this.tabla[pos].getEn(i).llave.equals(llave)) {
				return this.tabla[pos].getEn(i).valor;
			} 
		}
		throw new NoSuchElementException("No se encontró un valor que contenga esa llave");
		
	}
	
	public V delete(K llave) {

		int pos = llave.hashCode() % this.tabla.length;
		if (pos < 0) {
			pos = pos * -1;
		}
		for (int i = 0; i < tabla[pos].size(); i++) {
			if (tabla[pos].getEn(i).llave.equals(llave)) {
				this.size--;
				return tabla[pos].borrarEn(i).getValor();
			}
		}
		throw new NoSuchElementException("No hay un elemento que borrar con esa llave");
	}
	
	public boolean containsKey(K llave) {

		int pos = llave.hashCode() % this.tabla.length;
		if (pos < 0) {
			pos = pos * -1;
		}
		for (int i = 0; i < this.tabla[pos].size(); i++) {
			if (tabla[pos].getEn(i).llave.equals(llave)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {

		this.tabla = (MiListaEnlazada<MyNodoHash<K, V>>[]) new MiListaEnlazada[11];
		for (int i = 0; i < this.tabla.length; i++) {
			this.tabla[i] = new MiListaEnlazada<>();
		}
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public V deleteQueue(K llave) { //metodo nuevo, actua como una queue para borrar el último elemento que tenemos
		int pos = llave.hashCode() % this.tabla.length;
		if (tabla[pos].size() > 0) {
			return tabla[pos].borrarInicio().getValor();
		} else {
			throw new NoSuchElementException("No existe o no se encuentra en inventario dicho carro.");
		}
		
	}

	public MiListaEnlazada<MyNodoHash<K, V>>[] getTabla() {
		return tabla;
	}
	
	
}

class MyNodoHash<K, V>{
	K llave;
	V valor;
	public MyNodoHash(K llave, V valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	public K getLlave() {
		return llave;
	}
	public V getValor() {
		return valor;
	}
	
}
