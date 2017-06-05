package petfriends.model;

import java.util.List;

public interface AdoptPhotosDAO {
	public List<AdoptPhotosBean> select();

	public AdoptPhotosBean select(int APID);

	public AdoptPhotosBean insert(AdoptPhotosBean bean);

	public AdoptPhotosBean update(AdoptPhotosBean bean);
	
	public boolean delete(int APID);
}
