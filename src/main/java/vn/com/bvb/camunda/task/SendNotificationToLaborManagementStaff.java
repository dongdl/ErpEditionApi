package vn.com.bvb.camunda.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendNotificationToLaborManagementStaff implements JavaDelegate {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
    	logger.info("Send Notification To Labor Management Staff");
    }
}

