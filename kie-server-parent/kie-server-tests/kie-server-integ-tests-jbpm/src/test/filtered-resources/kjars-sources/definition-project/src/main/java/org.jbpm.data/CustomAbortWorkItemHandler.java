/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.jbpm.data;

import java.util.Map;
import java.util.HashMap;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomAbortWorkItemHandler implements WorkItemHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAbortWorkItemHandler.class);
    private Map<String, Object> results = new HashMap();

    public CustomAbortWorkItemHandler() {
    }
    
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        logger.info("CustomAbortWorkItemHandler.executeWorkItem do nothing");
    }


    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
    	logger.info("CustomAbortWorkItemHandler.abortWorkItem");
        results.put("aborted", true);
        manager.completeWorkItem(workItem.getId(), results);
        manager.abortWorkItem(workItem.getId());
    }
}