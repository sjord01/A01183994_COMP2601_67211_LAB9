import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainDriver {
	private static final String FILEPATH_ALBUM = "src//beatles_vinyl.csv";
	private static final String DELIMETER_ALBUM = ",";
	
	private static final int POSITION_ID = 0;
	private static final int POSITION_TITLE = 1;
	private static final int POSITION_ACQUIRED = 2;
	private static final int POSITION_LABEL = 3;
	private static final int POSITION_PRESSING = 4;
	private static final int POSITION_SOUND = 5;
	private static final int POSITION_CATNO = 6;

	public static void main(final String[] args) {
		MainDriver beatleAlbumParse01 = new MainDriver();
		beatleAlbumParse01.init();

	}

	public void init() {
		List<BeatleAlbum> albums = new ArrayList<>();
		String filePathCSV = FILEPATH_ALBUM;
		String line;
		String delimeter = DELIMETER_ALBUM;

		try (BufferedReader br = new BufferedReader(new FileReader(filePathCSV))) {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(delimeter);
				try {
					if (validateArray(data)) {
						BeatleAlbum album = new BeatleAlbum(data[POSITION_ID], data[POSITION_TITLE], 
								Boolean.parseBoolean(data[POSITION_ACQUIRED]), data[POSITION_LABEL],
								data[POSITION_PRESSING], data[POSITION_SOUND], data[POSITION_CATNO]);
						albums.add(album);
					}
				} catch (IllegalBeatlesException e) {
					System.err.println("Invalid album data: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Searches
		displayAlbumsByTitle(albums, "Abbey Road");
		displayAlbumsByLabel(albums, "rainbow no brackets");
		displayAlbumsNotAcquired(albums);
		displayAlbumsByTitleLabelAcquired(albums, "The Beatles", "Apple", true);
		displayAlbumsByPressingAndSound(albums, "RCA", "Mono");

	}

	private static void displayAlbumsByTitle(List<BeatleAlbum> albums, final String title) {
		if ((validateList(albums)) && BeatleAlbum.validateString(title)) {
			List<BeatleAlbum> result = albums.stream().filter(album -> album.getTitle().equalsIgnoreCase(title))
					.collect(Collectors.toList());

			System.out.println("Displaying all versions of " + title + "--------------");
			result.forEach(System.out::println);
		}
	}

	private static void displayAlbumsByLabel(List<BeatleAlbum> albums, final String label) {
		if ((validateList(albums)) && BeatleAlbum.validateString(label)) {
			List<BeatleAlbum> result = albums.stream().filter(album -> album.getLabel().equalsIgnoreCase(label))
					.collect(Collectors.toList());

			System.out.println("Displaying all albums on the label " + label + "--------------");
			result.forEach(System.out::println);
		}
	}

	private static void displayAlbumsNotAcquired(List<BeatleAlbum> albums) {
		if (validateList(albums)) {
			List<BeatleAlbum> result = albums.stream().filter(album -> !album.isAcquired())
					.collect(Collectors.toList());

			System.out.println("Displaying all albums that have not been acquired--------------");
			result.forEach(System.out::println);
		}
	}

	private static void displayAlbumsByTitleLabelAcquired(List<BeatleAlbum> albums, String title, String label,
			boolean acquired) {
		if (validateList(albums) && BeatleAlbum.validateString(title) && BeatleAlbum.validateString(label)) {
			List<BeatleAlbum> result = albums.stream()
					.filter(album -> album.getTitle().equalsIgnoreCase(title)
							&& album.getLabel().equalsIgnoreCase(label) && album.isAcquired() == acquired)
					.collect(Collectors.toList());

			System.out.println("Displaying " + title + " (White Album) on " + label + ", where acquired is " + acquired
					+ "--------------");
			result.forEach(System.out::println);
		}
	}

	private static void displayAlbumsByPressingAndSound(List<BeatleAlbum> albums, String pressing, String sound) {
		List<BeatleAlbum> result = albums.stream().filter(
				album -> album.getPressing().equalsIgnoreCase(pressing) && album.getSound().equalsIgnoreCase(sound))
				.collect(Collectors.toList());

		System.out
				.println("Displaying all albums with pressing " + pressing + " and sound " + sound + "--------------");
		result.forEach(System.out::println);
	}

	/**
	 * Validates if the given list is neither null nor empty.
	 *
	 * @param list the list to validate
	 * @return true if the list is valid, otherwise false
	 */
	protected static boolean validateList(List<?> list) {
		if (list == null || list.isEmpty()) {
			System.err.println("Invalid list: The list is null or empty.");
			return false;
		}
		return true;
	}

	/**
	 * Validates if all elements in the given array are valid strings.
	 *
	 * @param data the array to validate
	 * @return true if all elements are valid strings, otherwise false
	 */
	protected static boolean validateArray(String[] data) {
		for (String value : data) {
			if (!BeatleAlbum.validateString(value)) {
				return false;
			}
		}
		return true;
	}
}
