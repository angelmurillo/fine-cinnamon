package com.finecinnamon.eventviewer.service;

import java.util.List;

import com.finecinnamon.eventviewer.domain.Event;
import com.finecinnamon.eventviewer.domain.OtherEventInfo;

public interface OtherEventInfoService {

	public abstract long countAllOtherEventInfoes();

	public abstract void deleteOtherEventInfo(OtherEventInfo otherEventInfo);

	public abstract void saveOtherEventInfo(OtherEventInfo otherEventInfo);

	public abstract OtherEventInfo findOtherEventInfo(Long id);

	public abstract OtherEventInfo updateOtherEventInfo(OtherEventInfo otherEventInfo);

	public abstract List<OtherEventInfo> findAllOtherEventInfoes();

	public abstract List<OtherEventInfo> findOtherEventInfoEntries(int firstResult, int maxResults);

	public abstract List<OtherEventInfo> findOtherEventInfoByEventId(Event event);

}
