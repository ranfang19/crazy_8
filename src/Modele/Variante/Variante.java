package Modele.Variante;

/**
 * Variante
 * @see Variante
 *
 */
public class Variante {
	private String nom;
	private String numero;
	private String regle;
	/**
	 * Creation d'un type de variante
	 * @see Variante#Variante()
	 */
	public Variante() {

	}

	/**
	 * Get le nom de la variante
	 * @see Variante#getNom()
	 * @return le nom de la variante
	 */

	public String getNom() {
		return nom;
	}
	/**
	 * Set le nom de la variante
	 * @see Variante#setNom()
	 * @param nom le nom de la variante
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Get le numero de la variante
	 * @see Variante#getNumero
	 * @return le nomero de la variante
	 */

	public String getNumero() {
		return numero;
	}
	/**
	 * Set le numero de la variante
	 * @see Variante#setNumero
	 * @param numero le nomero de la variante
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * Set le regle de la variante
	 * @see Variante#setRegle
	 * @param regle le regle de la variante
	 */
	public void setRegle(String regle) {
		this.regle = regle;
	}
	/**
	 * Get le regle de la variante
	 * @see Variante#getRegle
	 * @return le regle de la variante
	 */
	public String getRegle() {
		return regle;
	}

}
