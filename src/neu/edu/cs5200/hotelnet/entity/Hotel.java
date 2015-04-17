package neu.edu.cs5200.hotelnet.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HOTEL database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String countryCode;

	private int hotelId;

	private String hotelRating;

	private String imageURL;

	private String locationDescription;

	private String name;

	private String postalCode;

	private String shortDescription;

	//bi-directional many-to-one association to Commentary
	@OneToMany(mappedBy="hotel")
	private List<Commentary> commentaries;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="hotel")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="hotel")
	private List<Reservation> reservations;

	public Hotel() {
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

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelRating() {
		return this.hotelRating;
	}

	public void setHotelRating(String hotelRating) {
		this.hotelRating = hotelRating;
	}

	public String getImageURL() {
		return this.imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getLocationDescription() {
		return this.locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public List<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public Commentary addCommentary(Commentary commentary) {
		getCommentaries().add(commentary);
		commentary.setHotel(this);

		return commentary;
	}

	public Commentary removeCommentary(Commentary commentary) {
		getCommentaries().remove(commentary);
		commentary.setHotel(null);

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
		favorite.setHotel(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setHotel(null);

		return favorite;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setHotel(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setHotel(null);

		return reservation;
	}

}