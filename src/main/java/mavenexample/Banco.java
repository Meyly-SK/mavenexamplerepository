package mavenexample;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the banco database table.
 * 
 */
@Entity
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="banco_id")
	private int bancoId;

	@Column(name="banco_nombre")
	private String bancoNombre;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="banco")
	private List<Cuenta> cuentas;

	public Banco() {
	}

	public int getBancoId() {
		return this.bancoId;
	}

	public void setBancoId(int bancoId) {
		this.bancoId = bancoId;
	}

	public String getBancoNombre() {
		return this.bancoNombre;
	}

	public void setBancoNombre(String bancoNombre) {
		this.bancoNombre = bancoNombre;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setBanco(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setBanco(null);

		return cuenta;
	}

}