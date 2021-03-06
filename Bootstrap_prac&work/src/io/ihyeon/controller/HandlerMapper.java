package io.ihyeon.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.management.InstanceNotFoundException;

import io.ihyeon.context.ApplicationContext;
import io.ihyeon.handler.Handler;

public class HandlerMapper {

	private Map<String, Handler> commandMap = new HashMap<String, Handler>();

	public HandlerMapper() throws Exception {
		String path = "io/ihyeon/properties/handler";

		ResourceBundle rbHome = ResourceBundle.getBundle(path);

		Set<String> actionSetHome = rbHome.keySet();

		Iterator<String> it = actionSetHome.iterator();

		while (it.hasNext()) {

			String command = it.next();

			String actionClassName = rbHome.getString(command);

			System.out.println(actionClassName);
			try {
				Class<?> actionClass = Class.forName(actionClassName);
				Handler commandAction = (Handler) actionClass.newInstance();

				Method[] methods = actionClass.getMethods();
				for (Method method : methods) {
					if (method.getName().contains("set")) {
						String paramType = method.getParameterTypes()[0].getName();
						paramType = paramType.substring(paramType.lastIndexOf(".") + 1);

						paramType = (paramType.charAt(0) + "").toLowerCase() + paramType.substring(1);
						try {

							method.invoke(commandAction, ApplicationContext.getApplicationContext().get(paramType));
							System.out.println("[HandlerMapper:invoke"
									+ ApplicationContext.getApplicationContext().get(paramType));

						} catch (Exception e) {
							e.printStackTrace();
							throw e;
						}
					}
				}

				commandMap.put(command, commandAction);
				System.out.println("[HandlerMapper]" + command + ":" + commandAction + "가 준비되었습니다.");

			} catch (ClassNotFoundException e) {
				System.out.println("[HandlerMapper]" + actionClassName + "가 준비되었습니다.");
				throw e;
			} catch (InstantiationException e) {
				System.out.println("[HandlerMapper]" +actionClassName + "가 준비되었습니다.");
				throw e;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw e;
			}

		}

	}
	
	public Handler getHandler(String url) {
		Handler handler = commandMap.get(url);
		return handler;
	}



}
