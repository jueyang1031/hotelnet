package neu.edu.cs5200.hotelnet.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FOLLOW database table.
 * 
 */
@Entity
@NamedQuery(name="Follow.findAll", query="SELECT f FROM Follow f")
public class Follow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="myCId")
	private Customer customer1;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="friendCId")
	private Customer customer2;

	public Follow() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer1() {
		return this.customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}

	public Customer getCustomer2() {
		return this.customer2;
	}

	public void setCustomer2(Customer customer2) {
		this.customer2 = customer2;
	}

}