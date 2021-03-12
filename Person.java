
public class Person implements IPerson {
	private Persons namePerson;
	private Boot boot;
	private String status;

	Person(Persons namePerson) {
		this.namePerson = namePerson;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public Boot getBoot() {
		return boot;
	}

	@Override
	public void like(ISong song, String how) {
		status = song.sing(how);
		System.out.println(this.toString() + " понравилась " + song.toString() + ",что он " + status + " её ");
		status += " " + song.toString();
	}

	@Override
	public void walk(APlace place) {
		status = "шагая по " + place.getName();
		System.out.println(status);
	}

	@Override
	public void sing(ISong song, String how) {
		status = song.sing(how) + " " + song.toString();
		System.out.println(status + how);
	}

	@Override
	public void sit(APlace place) {
		status = "сидел у " + place.getName();
		System.out.println(this.toString() + status);
	}

	public void wear(String boot) {
		this.boot = new Boot(boot);
		System.out.println("натягивая свои " + this.boot.getBoot());
	}

	public void swipe() {

		class Honey {
			private boolean exist = true;

			public String swipe() {
				if (exist) {
					exist = false;
					return "смахнул мёд";
				} else {
					return "нет мёда";
				}
			}
		}

		Honey honey = new Honey();

		System.out.println(this.toString() + honey.swipe());
	}

	public void see(Person person) throws BootException, PersonException {
		if (person == null) {
			throw new PersonException("Нету второго героя");
		}
		if (person.getBoot() == null) {
			throw new BootException("Нет сапог");
		}
		System.out.println(this.toString() + " увидел " + person.getBoot().getBoot());
		this.swipe();
		status = "готов к приключению";
		System.out.println(this.toString() + " " + status);
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.namePerson.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		return obj.toString() == this.toString() ? true : false;
	}

	@Override
	public String toString() {
		if (namePerson == Persons.Vinni) {
			return "Пух";
		} else {
			return "Кристофер Робин";
		}
	}

	public void jointly(Person person) throws BootException, PersonException {
		if (person == null) {
			throw new PersonException("Нету второго героя");
		}
		if (person.getBoot() == null) {
			throw new BootException("Нет сапог");
		}
		status = " сел и крепко, изо всех сил, уперся лапками в землю, а спиной изо всех сил уперся в спину";
		person.setStatus(" изо всех сил уперся в спину и стал тащить и тянуть свои " + person.getBoot().getBoot());
		System.out.println(this.toString() + status + ". " + person.toString() + person.getStatus());
	}

	public class Boot {
		private String boot;

		Boot(String boot) {
			this.boot = boot;
		}

		public String getBoot() {
			return boot;
		}

		@Override
		public int hashCode() {
			return super.hashCode() + this.boot.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != this.getClass())
				return false;

			return obj.toString() == this.toString() ? true : false;
		}

		@Override
		public String toString() {
			return boot;
		}

	}

	public static class Place extends APlace {

		Place(String namePlace) {
			super(namePlace);
		}

		@Override
		public String getName() {
			return toString();
		}
	}

}
