package selenium_web.framework;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import selenium_web.tests.GroupData;
import utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public List<GroupData> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf(
          		(List<GroupData>) session.createQuery("from GroupData").list());
		} finally {
          trans.commit();
		}
	}
}
