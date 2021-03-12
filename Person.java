
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
		System.out.println(this.toString() + " ����������� " + song.toString() + ",��� �� " + status + " � ");
		status += " " + song.toString();
	}

	@Override
	public void walk(APlace place) {
		status = "����� �� " + place.getName();
		System.out.println(status);
	}

	@Override
	public void sing(ISong song, String how) {
		status = song.sing(how) + " " + song.toString();
		System.out.println(status + how);
	}

	@Override
	public void sit(APlace place) {
		status = "����� � " + place.getName();
		System.out.println(this.toString() + status);
	}

	public void wear(String boot) {
		this.boot = new Boot(boot);
		System.out.println("��������� ���� " + this.boot.getBoot());
	}

	public void swipe() {

		class Honey {
			private boolean exist = true;

			public String swipe() {
				if (exist) {
					exist = false;
					return "������� ��";
				} else {
					return "��� ���";
				}
			}
		}

		Honey honey = new Honey();

		System.out.println(this.toString() + honey.swipe());
	}

	public void see(Person person) throws BootException, PersonException {
		if (person == null) {
			throw new PersonException("���� ������� �����");
		}
		if (person.getBoot() == null) {
			throw new BootException("��� �����");
		}
		System.out.println(this.toString() + " ������ " + person.getBoot().getBoot());
		this.swipe();
		status = "����� � �����������";
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
			return "���";
		} else {
			return "��������� �����";
		}
	}

	public void jointly(Person person) throws BootException, PersonException {
		if (person == null) {
			throw new PersonException("���� ������� �����");
		}
		if (person.getBoot() == null) {
			throw new BootException("��� �����");
		}
		status = " ��� � ������, ��� ���� ���, ������ ������� � �����, � ������ ��� ���� ��� ������ � �����";
		person.setStatus(" ��� ���� ��� ������ � ����� � ���� ������ � ������ ���� " + person.getBoot().getBoot());
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
