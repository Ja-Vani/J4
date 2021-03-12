
public abstract class APlace {
	private String namePlace;

	APlace(String namePlace) {
		this.namePlace = namePlace;
	}

	public String getName() {
		return namePlace;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.namePlace.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		return obj.toString() == this.toString() ? true : false;
	}

	@Override
	public String toString() {
		return namePlace;
	}
}
