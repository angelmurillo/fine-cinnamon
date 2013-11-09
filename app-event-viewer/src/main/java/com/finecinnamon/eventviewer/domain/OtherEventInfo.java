package com.finecinnamon.eventviewer.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import flexjson.JSONSerializer;

@Entity
@Configurable
public class OtherEventInfo {

    @Column(name = "PARAM_NAME")
    @Size(max = 50)
    private String paramName;

    @Column(name = "PARAM_VALUE")
    @Lob
    private String paramValue;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Event eventId;

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

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
        EntityManager em = new OtherEventInfo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countOtherEventInfoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM OtherEventInfo o", Long.class).getSingleResult();
    }

	public static List<OtherEventInfo> findAllOtherEventInfoes() {
        return entityManager().createQuery("SELECT o FROM OtherEventInfo o", OtherEventInfo.class).getResultList();
    }

	public static OtherEventInfo findOtherEventInfo(Long id) {
        if (id == null) return null;
        return entityManager().find(OtherEventInfo.class, id);
    }

	public static List<OtherEventInfo> findOtherEventInfoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM OtherEventInfo o", OtherEventInfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            OtherEventInfo attached = OtherEventInfo.findOtherEventInfo(this.id);
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
    public OtherEventInfo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        OtherEventInfo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String getParamName() {
        return this.paramName;
    }

	public void setParamName(String paramName) {
        this.paramName = paramName;
    }

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	

	public Event getEventId() {
        return this.eventId;
    }

	public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

	public static String toJsonArray(List<OtherEventInfo> listOtherEventInfo) {
		return new JSONSerializer().exclude("*.class").deepSerialize(listOtherEventInfo);
	}
	
}
