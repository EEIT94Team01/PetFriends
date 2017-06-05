package petfriends.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import petfriends.configuration.HibernateConfiguration;
import petfriends.model.AdoptBean;
import petfriends.model.AdoptDAO;
@Service
public class AdoptService {
	@Autowired
	private AdoptDAO adoptDAO;
	public AdoptService(AdoptDAO adoptDAO){
		this.adoptDAO=adoptDAO;
	}
	
	public List<AdoptBean> select(AdoptBean bean) {
		List<AdoptBean> result = null;
		if(bean!=null && bean.getAId()!=0) {
			AdoptBean temp = adoptDAO.select(bean.getAId());
			if(temp!=null) {
				result = new ArrayList<AdoptBean>();
				result.add(temp);
			}
		} else {
			result = adoptDAO.select(); 
		}
		return result;
	}
	public AdoptBean insert(AdoptBean bean) {
		AdoptBean result = null;
		if(bean!=null) {
			result = adoptDAO.insert(bean);
		}
		return result;
	}
	public AdoptBean update(AdoptBean bean) {
		AdoptBean result = null;
		if(bean!=null) {
			result = adoptDAO.update(bean);
		}
		return result;
	}
	public boolean delete(AdoptBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = adoptDAO.delete(bean.getAId());
		}
		return result;
	}	
}
