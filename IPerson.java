
public interface IPerson {
	public String getStatus();

	void setStatus(String status);

	void like(ISong song, String how);

	void walk(APlace place);

	void sing(ISong song, String how);

	void sit(APlace place);
}
