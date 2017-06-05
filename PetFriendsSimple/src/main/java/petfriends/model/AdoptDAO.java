package petfriends.model;

import java.util.List;

public interface AdoptDAO {
	public List<AdoptBean> select();

	public AdoptBean select(int AID);

	public AdoptBean insert(AdoptBean bean);

	public AdoptBean update(AdoptBean bean);
	
	public boolean delete(int AID);
}
