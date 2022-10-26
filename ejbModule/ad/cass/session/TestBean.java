package ad.cass.session;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ad.cass.entity.Test;
import ad.cass.exception.CassException;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
@Remote(TestBeanRemote.class)
@LocalBean
public class TestBean implements TestBeanRemote {
	private static final Log _log = LogFactory.getLog(TestBean.class);
    @PersistenceContext(unitName = "cassPU") private EntityManager em;
    
    /**
     * Default constructor. 
     */
    public TestBean() {
    
    }

	@Override
	public long getTimeStamp() {
		 return new Date().getTime();
	}

	@Override
	public void addTest(Test test) throws CassException {
		if (test == null)
            throw new CassException("Invalid test instance");
        try {
            em.persist(test);
            _log.info("Test [" + test.getId() + " | " + test.getName()  + "] added");
        } catch (Exception ex) {
            _log.error(ExceptionUtils.getStackTrace(ex));
            throw new CassException("Error adding test to the persistence layer. Error: " + ex.getMessage());
        }
		
	}
	
	@Override
	public Test[] getTests() throws CassException {
		try {
            Query query = em.createNamedQuery("allTest");
            List<Test> testList;
            testList = (List<Test>) query.getResultList();
            _log.info("Found [" + testList.size() + " Test");
            return testList.toArray(new Test[testList.size()]);
        } catch (Exception ex) {
            _log.error(ExceptionUtils.getStackTrace(ex));
            throw new CassException("Error getting tests. Error: " + ex.getMessage());
        }
	}

	@Override
	public Test getTest(long testId) throws CassException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTest(Test test) throws CassException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTest(Test test) throws CassException {
		// TODO Auto-generated method stub
		
	}

}
