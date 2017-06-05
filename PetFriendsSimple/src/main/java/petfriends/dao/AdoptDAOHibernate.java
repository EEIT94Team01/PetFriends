package petfriends.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import petfriends.configuration.HibernateConfiguration;
import petfriends.model.AdoptBean;
import petfriends.model.AdoptDAO;
import petfriends.model.AdoptPhotosBean;

import org.hibernate.Query;
@Repository
public class AdoptDAOHibernate implements AdoptDAO {
	/*
	 * PetType FindCity FindDate
	 */
	@Autowired
	private SessionFactory sessionFactory;
	public AdoptDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	//測試程式
	/*
	public static void main(String[] args){
		
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		sessionFactory.getCurrentSession().beginTransaction();
		AdoptDAO adoptDAO=(AdoptDAO) context.getBean("adoptDAOHibernate");
		AdoptBean bean=new AdoptBean();
		bean.setPetForm(1);
		bean.setUserName("Mr.Hsu");
		bean.setUserEmail("sksly789@gmail.com");
		bean.setUserPhone("0989739908");
		bean.setPetName("rabbit");
		bean.setPetType("兔子");
		bean.setPetFeature("White mix Gray hear");
		bean.setFindCity("新北市");
		bean.setFindDistrict("中和區");
		bean.setFindRoad("民德路");
		bean.setFindDate(new java.util.Date());
		bean.setPetGender(2);
		bean.setPetPhotos(1);
		bean.setPetNotes("She is so cute.");
		
		adoptDAO.insert(bean);
		sessionFactory.getCurrentSession().getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
}*/
	
	@Override
	public List<AdoptBean> select() {
		return this.getSession().createQuery("FROM AdoptBean", AdoptBean.class).getResultList();
	}

	@Override
	public AdoptBean select(int AId) {
		return getSession().get(AdoptBean.class, AId);
	}

	@Override
	public AdoptBean insert(AdoptBean bean) {
		if (bean != null) {
			AdoptBean select = this.select(bean.getAId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public AdoptBean update(AdoptBean bean) {
		getSession().saveOrUpdate(bean);
		return null;
	}

	@Override
	public boolean delete(int AId) {
		AdoptBean bean = this.select(AId);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
}