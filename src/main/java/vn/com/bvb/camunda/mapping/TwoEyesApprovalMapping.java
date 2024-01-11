package vn.com.bvb.camunda.mapping;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.impl.value.PrimitiveTypeValueImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TwoEyesApprovalMapping implements DelegateVariableMapping {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void mapInputVariables(DelegateExecution superExecution, VariableMap subVariables) {
		PrimitiveTypeValueImpl<String> directManagerVarObj = superExecution.getVariableLocalTyped("directManagerVar", true);
		String directManager = directManagerVarObj.getValue();
		
		logger.info("directManagerVar = {}", directManager);
		
		subVariables.putValue("directManager", directManager);
	}

	@Override
	public void mapOutputVariables(DelegateExecution superExecution, VariableScope subInstance) {

	}

}
