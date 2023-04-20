package mavenexample;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the moneda database table.
 * 
 */
@Entity
@NamedQuery(name="Moneda.findAll", query="SELECT m FROM Moneda m")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="moneda_id")
	private int monedaId;

	@Column(name="moneda_nombre")
	private String monedaNombre;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="moneda")
	private List<Cuenta> cuentas;

	public Moneda() {
	}

	public int getMonedaId() {
		return this.monedaId;
	}

	public void setMonedaId(int monedaId) {
		this.monedaId = monedaId;
	}

	public String getMonedaNombre() {
		return this.monedaNombre;
	}

	public void setMonedaNombre(String monedaNombre) {
		this.monedaNombre = monedaNombre;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setMoneda(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setMoneda(null);

		return cuenta;
	}

}