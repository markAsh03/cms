/**
 * 
 */
package com.markash.cms.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.markash.cms.exception.BusException;

/**
 * 
 * 数据校验器
 * @author muanan
 *
 */
public class ValidatorUtil {

	// 校验器
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	/**
	 * 实体校验
	 * @param t
	 * @param groups
	 */
	public static <T> void validateEntity(T t, Class<?>... groups) {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);
        if (!constraintViolations.isEmpty()) {
        	ConstraintViolation<T> constraint = constraintViolations.iterator().next();
            throw new BusException(constraint.getMessage());
        }
	}
}
