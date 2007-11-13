/*
 * Copyright 2002-2006 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created on 23-Jan-2006 by Adrian Colyer
 */
package org.springframework.osgi.context.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.osgi.context.BundleContextAware;

/**
 * {@link BeanPostProcessor} dealing with classes that implement
 * BundleContextAware interface.
 * 
 * @author Adrian Colyer
 * @author Costin Leau
 */
public class BundleContextAwareProcessor implements BeanPostProcessor {

	private final BundleContext bundleContext;

	protected final Log logger = LogFactory.getLog(getClass());

	public BundleContextAwareProcessor(BundleContext aContext) {
		this.bundleContext = aContext;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof BundleContextAware) {
			((BundleContextAware) bean).setBundleContext(this.bundleContext);
		}
		return bean;
	}

}