package neu.edu.cs5200.hotelnet.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String email;

	private String password;

	@Temporal(TemporalType.DATE)
	private Date regDate;

	private String telephone;

	private String username;

	//bi-directional many-to-one association to Commentary
	@OneToMany(mappedBy="customer")
	private List<Commentary> commentaries;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="customer")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Follow
	@OneToMany(mappedBy="customer1")
	private List<Follow> follows1;

	//bi-directional many-to-one association to Follow
	@OneToMany(mappedBy="customer2")
	private List<Follow> follows2;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="customer")
	private List<Reservation> reservations;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public Commentary addCommentary(Commentary commentary) {
		getCommentaries().add(commentary);
		commentary.setCustomer(this);

		return commentary;
	}

	public Commentary removeCommentary(Commentary commentary) {
		getCommentaries().remove(commentary);
		commentary.setCustomer(null);

		return commentary;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setCustomer(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setCustomer(null);

		return favorite;
	}

	public List<Follow> getFollows1() {
		return this.follows1;
	}

	public void setFollows1(List<Follow> follows1) {
		this.follows1 = follows1;
	}

	public Follow addFollows1(Follow follows1) {
		getFollows1().add(follows1);
		follows1.setCustomer1(this);

		return follows1;
	}

	public Follow removeFollows1(Follow follows1) {
		getFollows1().remove(follows1);
		follows1.setCustomer1(null);

		return follows1;
	}

	public List<Follow> getFollows2() {
		return this.follows2;
	}

	public void setFollows2(List<Follow> follows2) {
		this.follows2 = follows2;
	}

	public Follow addFollows2(Follow follows2) {
		getFollows2().add(follows2);
		follows2.setCustomer2(this);

		return follows2;
	}

	public Follow removeFollows2(Follow follows2) {
		getFollows2().remove(follows2);
		follows2.setCustomer2(null);

		return follows2;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setCustomer(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setCustomer(null);

		return reservation;
	}

}