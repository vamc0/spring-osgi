/*
 * Copyright 2006-2008 the original author or authors.
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

package org.springframework.osgi.iandt.jdkproxy.internal;;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Simple private class that dispatches a method.
 * 
 * @author Costin Leau
 * 
 */
public class PrivateExecutor {

	/** logger */
	private static final Log log = LogFactory.getLog(PrivateInvocationHandler.class);


	Object dispatchMethod(Method method) {
		log.info("about to invoke " + method);
		return "method invoked by a private class at " + new Date();
	}
}