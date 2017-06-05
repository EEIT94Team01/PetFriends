package petfriends.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import petfriends.configuration.HibernateConfiguration;
import petfriends.model.AdoptPhotosBean;
import petfriends.model.AdoptPhotosDAO;

@Repository
public class AdoptPhotosDAOHibernate implements AdoptPhotosDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public AdoptPhotosDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/*測試程式
	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		sessionFactory.getCurrentSession().beginTransaction();

		File file = new File("C:/Users/Student/Desktop/001.jpg");
		byte[] imageData = new byte[(int) file.length()];

		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(imageData);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		AdoptPhotosDAO adoptPhotosDAO = (AdoptPhotosDAO) context.getBean("adoptPhotosDAOHibernate");
		AdoptPhotosBean bean=new AdoptPhotosBean();
		bean.setPhoto(imageData);
		bean.setAId(1);
		bean.setPhotoList(1);
		adoptPhotosDAO.insert(bean);
		
		sessionFactory.getCurrentSession().getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}*/

	
	@Override
	public List<AdoptPhotosBean> select() {
		return this.getSession().createQuery("FROM AdoptPhotosBean", AdoptPhotosBean.class).getResultList();
	}

	@Override
	public AdoptPhotosBean select(int ApId) {
		return getSession().get(AdoptPhotosBean.class, ApId);
	}

	@Override
	public AdoptPhotosBean insert(AdoptPhotosBean bean) {
		if (bean != null) {
			AdoptPhotosBean select = this.select(bean.getApId());
			if (select == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public AdoptPhotosBean update(AdoptPhotosBean bean) {
		getSession().saveOrUpdate(bean);
		return null;
	}

	@Override
	public boolean delete(int ApId) {
		AdoptPhotosBean bean = this.select(ApId);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
