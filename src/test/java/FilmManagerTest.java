import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {


    @Test
    public void shouldAddFilm() {
        FilmManager manager = new FilmManager();

        manager.add("Film 1");
        // manager.add("Film 2");
        // manager.add("Film 3");
        // manager.add("Film 4");

        String[] expected = {"Film 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLimit1() {

        FilmManager manager = new FilmManager(4);
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        String[] expected = {"Film 5", "Film 4", "Film 3", "Film 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLimit2() {

        FilmManager manager = new FilmManager(4);
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithoutLimit() {

        // тут проверил что при лимите по умолчанию 5, при заведение 6 фильмов выдает массив из 5 последних

        FilmManager manager = new FilmManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
