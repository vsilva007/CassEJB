package ad.cass.session;

import javax.ejb.Remote;

import ad.cass.entity.Test;
import ad.cass.exception.CassException;

@Remote
public interface TestBeanRemote {

	 long getTimeStamp();

	 void addTest(Test test) throws CassException;
	 
	 Test[] getTests() throws CassException;

	 Test getTest(long testId) throws CassException;

	 void updateTest(Test test) throws CassException;

	 void deleteTest(Test test) throws CassException;
}
