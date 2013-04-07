/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketTutorial.websocket;

import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.XmlAjaxResponse;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.ILogData;
import org.apache.wicket.request.IRequestCycle;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * 
 * @author andrea
 *
 */
public class WebsocketRequestTarget implements AjaxRequestTarget {
	
	private final Page page;
	private final XmlAjaxResponse ajaxResponse;
	private final Response response;	
	
	public WebsocketRequestTarget(Page page, Response response) {
		super();
		this.page = page;
		this.response = response;
		this.ajaxResponse = new XmlAjaxResponse(page)
		{
			@Override
			protected void fireOnAfterRespondListeners(Response response)
			{
			}

			@Override
			protected void fireOnBeforeRespondListeners()
			{
			}
		};
	}

	@Override
	public Integer getPageId() {
		return page.getPageId();
	}

	@Override
	public boolean isPageInstanceCreated() {
		return true;
	}

	@Override
	public Integer getRenderCount() {
		return page.getRenderCount();
	}

	@Override
	public Class<? extends IRequestablePage> getPageClass() {
		return page.getPageClass();
	}

	@Override
	public PageParameters getPageParameters() {
		return page.getPageParameters();
	}

	@Override
	public void respond(IRequestCycle requestCycle) {		
	}

	@Override
	public void detach(IRequestCycle requestCycle) {
	}

	@Override
	public ILogData getLogData() {
		return null;
	}

	public void add(Component component) {
		add(component, component.getMarkupId());
	}
	
	@Override
	public void add(Component component, String markupId) {
		ajaxResponse.add(component, markupId);
	}

	@Override
	public void add(Component... components) {
		for (Component component : components) {
			add(component);
		}
	}

	@Override
	public void addChildren(MarkupContainer parent, Class<?> childCriteria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(IListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendJavaScript(CharSequence javascript) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prependJavaScript(CharSequence javascript) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerRespondListener(ITargetRespondListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<? extends Component> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void focusComponent(Component component) {
		// TODO Auto-generated method stub

	}

	@Override
	public IHeaderResponse getHeaderResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastFocusedElementId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getPage() {
		return page;
	}
	
	public void writeToResponse(){		
		ajaxResponse.writeTo(response, "UTF-8");				
	}
}