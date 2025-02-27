import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class crudTest {
	crud database = new crud();

	@Test
	void testAdd() {
		database.add("Planets", "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		Assertions.assertEquals(database.read("Planets"), "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		database.clear();
	}
	
	@Test
	void testRemove() {
		database.add("Planets", "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		database.add("States of Matter", "Solid, Liquid, Gas, Plasma");
		database.remove("Planets");
		Assertions.assertEquals(database.length(), 1);
		Assertions.assertEquals(database.read("States of Matter"), "Solid, Liquid, Gas, Plasma");
		database.clear();
	}
	
	@Test
	void testReadAll() {
		database.add("Planets", "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		database.add("States of Matter", "Solid, Liquid, Gas, Plasma");
		Assertions.assertEquals(database.readAll(), "DATA: States of Matter : Solid, Liquid, Gas, Plasma\n"
													+ "DATA: Planets : Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus\n");
		database.clear();
	}
	
	@Test
	void testUpdate() {
		database.add("Planets", "Earth, Mercury, Venus, Mars");
		database.add("Planets", "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		Assertions.assertEquals(database.read("Planets"), "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		database.clear();
	}
	
	@Test
	void readKeyNotFound() {
		database.add("States of Matter", "Solid, Liquid, Gas, Plasma");
		Assertions.assertEquals(database.read("Planets"), "Key not found");
		database.clear();
	}
	
	@Test
	void testClear() {
		database.add("Planets", "Earth, Mercury, Venus, Mars");
		database.add("Planets", "Earth, Mercury, Venus, Mars, Jupiter, Saturn, Neptune, Uranus");
		database.clear();
		Assertions.assertEquals(database.length(), 0);
	}
}
