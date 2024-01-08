package vn.com.bvb.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import vn.com.bvb.repository.RecruitmentUserTaskRepository;

@Component("startRecruitmentListener")
@AllArgsConstructor
public class StartRecruitmentListener implements TaskListener {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private RecruitmentUserTaskRepository recruitmentUserTaskRepository;

	@Override
	public void notify(DelegateTask delegateTask) {
		String processInstanceId = delegateTask.getProcessInstanceId();
		String businessKey = delegateTask.getExecution().getProcessInstance().getBusinessKey();

		logger.info("processInstanceId = {}, businessKey = {}", processInstanceId, businessKey);
		
	}

}
