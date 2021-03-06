/*
 * Copyright 2006-2009 the original author or authors.
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
 */
package org.springframework.osgi.context.support.internal.security;

import java.security.AccessControlContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author Costin Leau
 */
public abstract class SecurityUtils {

	public static AccessControlContext getAccFrom(BeanFactory beanFactory) {
		AccessControlContext acc = null;
		if (beanFactory != null) {
			if (beanFactory instanceof ConfigurableBeanFactory) {
				return ((ConfigurableBeanFactory) beanFactory).getAccessControlContext();
			}
		}
		return acc;
	}

	public static AccessControlContext getAccFrom(ApplicationContext ac) {
		return (ac != null ? getAccFrom(ac.getAutowireCapableBeanFactory()) : null);
	}
}
