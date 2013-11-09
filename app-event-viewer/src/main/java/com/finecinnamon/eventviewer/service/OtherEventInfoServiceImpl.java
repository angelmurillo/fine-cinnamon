package com.finecinnamon.eventviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finecinnamon.eventviewer.domain.Event;
import com.finecinnamon.eventviewer.domain.OtherEventInfo;
import com.finecinnamon.eventviewer.repository.OtherEventInfoRepository;

@Service
@Transactional
public class OtherEventInfoServiceImpl implements OtherEventInfoService {

	@Autowired
	OtherEventInfoRepository otherEventInfoRepository;

	public long countAllOtherEventInfoes() {
		return otherEventInfoRepository.count();
	}

	public void deleteOtherEventInfo(OtherEventInfo otherEventInfo) {
		otherEventInfoRepository.delete(otherEventInfo);
	}

	public OtherEventInfo findOtherEventInfo(Long id) {
		return otherEventInfoRepository.findOne(id);
	}

	public List<OtherEventInfo> findAllOtherEventInfoes() {
		return otherEventInfoRepository.findAll();
	}

	public List<OtherEventInfo> findOtherEventInfoEntries(int firstResult, int maxResults) {
		return otherEventInfoRepository.findAll(
				new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
	}

	public void saveOtherEventInfo(OtherEventInfo otherEventInfo) {
		otherEventInfoRepository.save(otherEventInfo);
	}

	public OtherEventInfo updateOtherEventInfo(OtherEventInfo otherEventInfo) {
		return otherEventInfoRepository.save(otherEventInfo);
	}

	public List<OtherEventInfo> findOtherEventInfoByEventId(Event event) {
		return otherEventInfoRepository.findByEventId(event);
	}
}
