package cn.dgkj.condition;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author mawt
 */
public class CustomSpringBootCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean isMatch = false;
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(CustomCondition.class.getName());
        Object value = annotationAttributes.get("value");
        isMatch = value != null && value.toString().equals("abc");
        ConditionOutcome outcome = new ConditionOutcome(isMatch, "");
        return outcome;
    }

}
