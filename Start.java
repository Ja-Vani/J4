
public class Start {
	public static void main(String[] args) {
		Person puh = new Person(Persons.Vinni);
		Person robbin = new Person(Persons.Robin);
		Person.Place forest = new Person.Place("���");
		Person.Place porog = new Person.Place("������");
		Song shum = new Song("�������");
		Time hour = new Time() {

			@Override
			public void pore() {
				System.out.println("��� ������ ��������, � �������� ���� ������������.");
			}
		};
		hour.pore();
		puh.like(shum, "�� �������");
		puh.walk(forest);
		puh.sing(shum, "��� ����");
		robbin.sit(porog);
		robbin.wear("�������� ������");

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