package com.hf.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AfterHandler implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Person person = (Person)bean;
		if (person.getSex().equals("男")) {
			person.setName("张宇");
		}else {
			person.setName("刘晓燕");
		}
		return person;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	

}
