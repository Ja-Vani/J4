
public class Start {
	public static void main(String[] args) {
		Person puh = new Person(Persons.Vinni);
		Person robbin = new Person(Persons.Robin);
		Person.Place forest = new Person.Place("Лес");
		Person.Place porog = new Person.Place("порога");
		Song shum = new Song("Шумелка");
		Time hour = new Time() {

			@Override
			public void pore() {
				System.out.println("Час другой пролетит, и настанет пора подкрепиться.");
			}
		};
		hour.pore();
		puh.like(shum, "со словами");
		puh.walk(forest);
		puh.sing(shum, "без слов");
		robbin.sit(porog);
		robbin.wear("Походные сапоги");

		try {
			puh.see(robbin);
		} catch (PersonException e) {
			System.out.println(e.getMessage());
		} catch (BootException e) {
			System.out.println(e.getMessage());
		}

		try {
			puh.jointly(robbin);
		} catch (PersonException e) {
			System.out.println(e.getMessage());
		} catch (BootException e) {
			System.out.println(e.getMessage());
		}
	}
}