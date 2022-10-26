package add.cass.management;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ad.cass.session.TestBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * The <code><b>EJBInitialization</b></code> is a <b>Singleton</b> class which performs initialization tasks
 * for the cass-core module.
 *
 * @author Victor da Silva
 */
@Singleton
@Startup
public class EJBInitialization {
    private static final Log _log = LogFactory.getLog(EJBInitialization.class);
    @EJB TestBean testService;

    @PostConstruct
    public void initialize() {
        _log.info("EJBInitialization -- STARTED");
        String propFileName;
        FileInputStream fis = null;
        try {
            
            // LOAD PROPERTIES INFORMATION
			/*
			 * Properties props = new Properties(); propFileName =
			 * System.getProperty("jboss.server.config.dir") +
			 * "/properties/config.properties"; _log.info("Loading properties from file: " +
			 * propFileName); fis = new FileInputStream(new File(propFileName));
			 * props.load(new InputStreamReader(fis, Charset.forName("UTF-8")));
			 */
            // ADD PROPS TO SYSTEM PROPS
			/*
			 * for (String name : props.stringPropertyNames()) System.setProperty(name,
			 * props.getProperty(name)); _log.info("Properties load succeded");
			 */
        } catch (Exception ex) {
            _log.error(ExceptionUtils.getStackTrace(ex));
            throw new RuntimeException("Error in EJBInitialization");
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                _log.error(ExceptionUtils.getStackTrace(ex));
                throw new RuntimeException("Error in EJBInitialization");
            }
        }
    }
}
