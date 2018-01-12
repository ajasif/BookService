package book;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookDao {

    protected static Logger logger = LogManager.getLogger(BookDao.class);

    @PersistenceContext
    EntityManager em;
    
    @PostConstruct
    public void init() {

    }
    
    public List<BookData> getBookTitles() {
    	Query q = em.createNativeQuery("SELECT * FROM book b", BookData.class);
    	@SuppressWarnings("unchecked")
		List<BookData> bookIds = q.getResultList();
    	return bookIds;
    }

//    public void save(Weather_OWM_Current weatherData) {
//    	if (weatherData == null) return;
//    	try {
//    		em.merge(weatherData);
//    	} catch (Exception e) {
//    		if (containsSqlConstraint(e.getCause())) {
//    			logger.info("Record violates SQL Constraint");
//    		} else {
//    			logger.error("An exception was thrown while persisting to the database", e);
//    		}
//    	}
//    }
    
//    public void save(Weather_OWM_City weatherCity) {
//    	if (weatherCity == null) return;
//    	try {
//    		em.persist(weatherCity);
//    	} catch (Exception e) {
//    		logger.error("An exception was thrown while adding a city from the rest service", e);
//    	}
//    }
//    
//    public Query notInDatabase(String id) {
//    	return em.createNativeQuery("SELECT woc.id FROM Weather_OWM_Cities woc WHERE " + id + " = woc.id");
//    }
//    
//    public void enableId(String id) {
//		Query q = em.createNativeQuery("UPDATE Weather_OWM_Cities woc SET woc.isEnabled = '1' WHERE woc.id = " + id);    	
//		q.executeUpdate();
//    }
//    
//    public void disableId(String id) {
//		Query q = em.createNativeQuery("UPDATE Weather_OWM_Cities woc SET woc.isEnabled = '0' WHERE woc.id = " + id);    
//		q.executeUpdate();
//    }
//    
//    public boolean conditionExists(String condition) {
//    	Query q =  em.createNativeQuery("SELECT wod.id FROM Weather_OWM_Description wod WHERE id = " + condition);
//    	return q.getResultList().size() > 0;
//    }
//    
//    public void saveDescription(Weather_OWM_Description weatherDescription) {
//    	em.persist(weatherDescription);
//    }
//    
//    public boolean containsSqlConstraint(Throwable e) {
//    	if (e == null) {
//    		return false;
//    	} else if (e instanceof SQLIntegrityConstraintViolationException) {
//    		return true;
//    	} else {
//    		return containsSqlConstraint(e.getCause());
//    	}
//    }
//   
    @PreDestroy
    public void exitThread() {
    	logger.info("Destroying Dao");
    }
}
