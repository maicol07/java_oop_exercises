package it.unibo.oop.lab.lambda.ex02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public final class MusicGroupImpl implements MusicGroup {

	private final Map<String, Integer> albums = new HashMap<>();
	private final Set<Song> songs = new HashSet<>();

	@Override
	public void addAlbum(final String albumName, final int year) {
		this.albums.put(albumName, year);
	}

	@Override
	public void addSong(final String songName, final Optional<String> albumName, final double duration) {
		if (albumName.isPresent() && !this.albums.containsKey(albumName.get())) {
			throw new IllegalArgumentException("invalid album name");
		}
		this.songs.add(new MusicGroupImpl.Song(songName, albumName, duration));
	}

	@Override
	public Stream<String> orderedSongNames() {
		return this.songs.stream().sorted((Song song1, Song song2) -> {
			return song1.getSongName().compareTo(song2.getSongName());
		}).map(Song::getSongName);
	}

	@Override
	public Stream<String> albumNames() {
		return this.albums.keySet().stream();
	}

	@Override
	public Stream<String> albumInYear(final int year) {
		return this.albums.entrySet().stream().filter(entry -> entry.getValue() == year).map(Entry::getKey);
	}

	@Override
	public int countSongs(final String albumName) {
		return (int) this.songs.stream().filter(song -> Objects.equals(song.getAlbumName().orElse(""), albumName))
				.count();
	}

	@Override
	public int countSongsInNoAlbum() {
		return (int) this.songs.stream().filter(song -> song.getAlbumName().isEmpty()).count();
	}

	@Override
	public OptionalDouble averageDurationOfSongs(final String albumName) {
		var albumSongs = this.songs.stream().filter(song -> Objects.equals(song.getAlbumName().orElse(""), albumName));
		var duration = albumSongs.mapToDouble(Song::getDuration).sum();
		var count = this.countSongs(albumName);
		return OptionalDouble.of(duration / count);
	}

	@Override
	public Optional<String> longestSong() {
		var song = this.songs.stream()
				.max((song1, song2) -> Double.compare(song1.getDuration(), song2.getDuration()));
		if (song.isPresent()) {
			return Optional.of(song.get().getSongName());
		}
		return Optional.of("");
	}

	@Override
	public Optional<String> longestAlbum() {
		/*Map<String, Integer> albums = new HashMap<>();
		this.albumNames().forEach(
			album -> albums.put(album, this.countSongs(album))
		);

		return Optional.of(albums.entrySet().stream()
			.max((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()))
			.orElse(Map.entry("", 0)).getKey()
		);*/
		return this.songs.stream().filter(a -> a.getAlbumName().isPresent())
                .collect(Collectors.groupingBy(Song::getAlbumName, Collectors.summingDouble(Song::getDuration)))
                .entrySet().stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Entry::getValue)))
                .flatMap(Entry::getKey);
	}

	private static final class Song {

		private final String songName;
		private final Optional<String> albumName;
		private final double duration;
		private int hash;

		Song(final String name, final Optional<String> album, final double len) {
			super();
			this.songName = name;
			this.albumName = album;
			this.duration = len;
		}

		public String getSongName() {
			return songName;
		}

		public Optional<String> getAlbumName() {
			return albumName;
		}

		public double getDuration() {
			return duration;
		}

		@Override
		public int hashCode() {
			if (hash == 0) {
				hash = songName.hashCode() ^ albumName.hashCode() ^ Double.hashCode(duration);
			}
			return hash;
		}

		@Override
		public boolean equals(final Object obj) {
			if (obj instanceof Song) {
				final Song other = (Song) obj;
				return albumName.equals(other.albumName) && songName.equals(other.songName)
						&& duration == other.duration;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Song [songName=" + songName + ", albumName=" + albumName + ", duration=" + duration + "]";
		}

	}

}
