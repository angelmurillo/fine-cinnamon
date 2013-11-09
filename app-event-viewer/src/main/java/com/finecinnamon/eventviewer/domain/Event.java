package com.finecinnamon.eventviewer.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
@Configurable
public class Event {

    @Column(name = "APP_NAME")
    @Size(max = 50)
    private String appName;

    @Column(name = "EVENT_NAME")
    @Size(max = 50)
    private String eventName;

    @Column(name = "NODE_NAME")
    @Size(max = 50)
    private String nodeName;

    @Column(name = "SESSION_ID")
    @Size(max = 50)
    private String sessionId;

    @Column(name = "REQUEST_ID")
    @Size(max = 50)
    private String requestId;

    @Column(name = "USER_NAME")
    @Size(max = 50)
    private String userName;

    @Column(name = "EVENT_DATE")
    private Long eventDate;
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Event().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countEvents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Event o", Long.class).getSingleResult();
    }

	public static List<Event> findAllEvents() {
		System.out.println("Entra");
        return entityManager().createQuery("SELECT o FROM Event o", Event.class).getResultList();
    }

	public static Event findEvent(Long id) {
        if (id == null) return null;
        return entityManager().find(Event.class, id);
    }

	public static List<Event> findEventEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Event o", Event.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Event attached = Event.findEvent(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public Event merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Event merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getAppName() {
        return this.appName;
    }

	public void setAppName(String appName) {
        this.appName = appName;
    }

	public String getEventName() {
        return this.eventName;
    }

	public void setEventName(String eventName) {
        this.eventName = eventName;
    }

	public String getNodeName() {
        return this.nodeName;
    }

	public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

	public String getSessionId() {
        return this.sessionId;
    }

	public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

	public String getRequestId() {
        return this.requestId;
    }

	public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

	public String getUserName() {
        return this.userName;
    }

	public void setUserName(String userName) {
        this.userName = userName;
    }

	public Long getEventDate() {
        return this.eventDate;
    }

	public void setEventDate(Long eventDate) {
        this.eventDate = eventDate;
    }

	public static Event convertJsonToEvent(String json) {
		return new JSONDeserializer<Event>().use(null, Event.class).deserialize(json);
	}
	
	public static String fromStringArraytoJson(List<String> stringList) {
		return new JSONSerializer().exclude("*.class").deepSerialize(stringList);
	}
}
