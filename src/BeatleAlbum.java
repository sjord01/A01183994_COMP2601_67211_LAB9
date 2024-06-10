/**
 * This class represents a Beatle Album with various attributes. It contains
 * information such as the album's ID, title, acquisition status, label,
 * pressing, sound quality, and catalog number. This class also includes methods
 * for validation and for setting and getting the values of these attributes.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */
public class BeatleAlbum {

	private String id;
	private String title;
	private boolean acquired;
	private String label;
	private String pressing;
	private String sound;
	private String catNo; //catNo = catalog number

	public BeatleAlbum() {
		super();
	}

	/**
	 * Constructor for BeatleAlbum.
	 *
	 * @param id       the ID of the album
	 * @param title    the title of the album
	 * @param acquired whether the album is acquired
	 * @param label    the label of the album
	 * @param pressing the pressing of the album
	 * @param sound    the sound quality of the album
	 * @param catNo    the catalog number of the album
	 * @throws IllegalBeatlesException if any parameter is invalid
	 */
	public BeatleAlbum(String id, String title, boolean acquired, String label, String pressing, String sound,
			String catNo) throws IllegalBeatlesException {
		if (!validateString(id) || !validateString(title) || !validateString(label) || !validateString(pressing)
				|| !validateString(sound) || !validateString(catNo)) {
			throw new IllegalBeatlesException("Invalid parameter(s) provided");
		}
		this.id = id;
		this.title = title;
		this.acquired = acquired;
		this.label = label;
		this.pressing = pressing;
		this.sound = sound;
		this.catNo = catNo;
	}

	/**
	 * Validates a given string parameter.
	 *
	 * @param param the parameter to validate
	 * @return true if the parameter is valid, otherwise false
	 */
	public static boolean validateString(String param) {
		return param != null && !param.isEmpty();
	}

	/**
	 * Gets the ID of the album.
	 *
	 * @return the ID of the album
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the title of the album.
	 *
	 * @return the title of the album
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the acquisition status of the album.
	 *
	 * @return true if the album is acquired, otherwise false
	 */
	public boolean isAcquired() {
		return acquired;
	}

	/**
	 * Gets the label of the album.
	 *
	 * @return the label of the album
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the pressing of the album.
	 *
	 * @return the pressing of the album
	 */
	public String getPressing() {
		return pressing;
	}

	/**
	 * Gets the sound quality of the album.
	 *
	 * @return the sound quality of the album
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * Gets the catalog number of the album.
	 *
	 * @return the catalog number of the album
	 */
	public String getCatNo() {
		return catNo;
	}

	/**
	 * Sets the acquisition status of the album.
	 *
	 * @param acquired the acquisition status to set
	 */
	public void setAcquired(boolean acquired) {
		this.acquired = acquired;
	}

	/**
	 * Returns a string representation of the BeatleAlbum object.
	 *
	 * @return a string representation of the BeatleAlbum object
	 */
	@Override
	public String toString() {
		return "BeatleAlbum [id=" + id + ", title=" + title + ", acquired=" + acquired + ", label=" + label
				+ ", pressing=" + pressing + ", sound=" + sound + ", catNo=" + catNo + "]";
	}
}
