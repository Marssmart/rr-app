package org.rapes.rr.app.core.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.rapes.rr.app.core.controller.dto.input.notification.NotificationInputDTO;
import org.rapes.rr.app.core.controller.dto.input.notification.NotificationSaveInputDTO;
import org.rapes.rr.app.core.controller.dto.output.notification.NotificationOutputDTO;
import org.rapes.rr.app.core.controller.dto.output.notification.NotificationSesUUIDOutputDTO;
import org.rapes.rr.app.core.controller.params.RequestParams;
import org.rapes.rr.app.core.controller.params.RequestPaths;
import org.rapes.rr.app.core.dao.NotificationRepository;
import org.rapes.rr.app.core.dao.NotificationSessionRepository;
import org.rapes.rr.app.core.dom.Notification;
import org.rapes.rr.app.core.dom.NotificationSession;
import org.rapes.rr.app.core.dom.enums.NotificationSeverity;
import org.rapes.rr.app.core.dom.enums.NotificationType;
import org.rapes.rr.app.core.dom.functions.NotificationToSessionConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.FluentIterable;

@RestController
public class NotificationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private NotificationSessionRepository notificationSessionRepository;
	
	/*@Scheduled(fixedRate = 60000)
	@Transactional
	public void scheduledCleanup(){
		LocalDateTime stamp = LocalDateTime.now().minusMinutes(1);
		
		LOGGER.info("Cleanup task fired for Notifications older that {}",stamp);
		notificationSessionRepository.cleanup(stamp);
		notificationRepository.cleanup(stamp);
		LOGGER.info("Cleanup task finished");
	}*/
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.NOTIFICATIONS_SES_UUID,
			method=RequestMethod.GET)
	public NotificationSesUUIDOutputDTO getNotificationSessionUUID(){
		
		NotificationSesUUIDOutputDTO dto = new NotificationSesUUIDOutputDTO();
		
		dto.setUuid(UUID.randomUUID().toString());
		
		return dto;
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.NOTIFICATIONS,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	@ResponseBody
	public NotificationOutputDTO loadNotifications(@RequestBody NotificationInputDTO dto){
		
		if(dto == null || StringUtils.isEmpty(dto.getUuid())){
			return NotificationOutputDTO.asInvalid();
		}
		
		List<Notification> relevantNotifications = notificationRepository.getRelevantNotifications(dto.getUuid());
		
		List<NotificationSession> seenNotifications = FluentIterable.from(relevantNotifications)
																	.transform(new NotificationToSessionConverter(dto.getUuid()))
																	.toList();
		notificationSessionRepository.save(seenNotifications);
		
		if(relevantNotifications.isEmpty()){
			return NotificationOutputDTO.asEmpty();
		}else{
			return NotificationOutputDTO.from(relevantNotifications);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value=RequestPaths.NOTIFICATION_SAVE,
			method=RequestMethod.POST,
			produces=RequestParams.PRODUCES_JSON,
			consumes=RequestParams.CONSUMES_JSON)
	public void saveNotification(@RequestBody NotificationSaveInputDTO dto){
		
		if( dto == null ||
			StringUtils.isEmpty(dto.getTitle()) ||
			StringUtils.isEmpty(dto.getText()) ||
			StringUtils.isEmpty(dto.getType()) ||
			StringUtils.isEmpty(dto.getSeverity())){
			
			LOGGER.error("Bad data came,ignoring notification save request");
			return;
		}
			
		NotificationType notificationType = NotificationType.valueOf(dto.getType());
		NotificationSeverity notificationSeverity = NotificationSeverity.valueOf(dto.getSeverity());
		
		if(notificationType == null || notificationSeverity == null){
			LOGGER.error("Enum values not found,ignoring notification save request");
			return;
		}
		
		LOGGER.info("Processing notification...");
		
		Notification notification = new Notification();
		notification.setTitle(dto.getTitle());
		notification.setText(dto.getText());
		notification.setNotificationType(notificationType);
		notification.setNotificationSeverity(notificationSeverity);
		notification.setCreatedAt(LocalDateTime.now());
		
		notificationRepository.save(notification);
		
		LOGGER.info("Notification saved");
	}
	
}
