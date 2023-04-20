package mavenexample;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cuenta_id")
	private int cuentaId;

	@Column(name="cuenta_codigo")
	private String cuentaCodigo;

	@Column(name="cuenta_titular")
	private String cuentaTitular;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="cuenta_banco")
	private Banco banco;

	//bi-directional many-to-one association to Moneda
	@ManyToOne
	@JoinColumn(name="cuenta_moneda")
	private Moneda moneda;

	public Cuenta() {
	}

	public int getCuentaId() {
		return this.cuentaId;
	}

	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String getCuentaCodigo() {
		return this.cuentaCodigo;
	}

	public void setCuentaCodigo(String cuentaCodigo) {
		this.cuentaCodigo = cuentaCodigo;
	}

	public String getCuentaTitular() {
		return this.cuentaTitular;
	}

	public void setCuentaTitular(String cuentaTitular) {
		this.cuentaTitular = cuentaTitular;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

}