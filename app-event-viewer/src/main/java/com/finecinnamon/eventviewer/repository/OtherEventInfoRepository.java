package com.finecinnamon.eventviewer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.finecinnamon.eventviewer.domain.Event;
import com.finecinnamon.eventviewer.domain.OtherEventInfo;

@Repository
public interface OtherEventInfoRepository extends JpaSpecificationExecutor<OtherEventInfo>, JpaRepository<OtherEventInfo, Long> {

	List<OtherEventInfo> findByEventId(Event event);
}
