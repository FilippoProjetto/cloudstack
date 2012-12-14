/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cloudstack.engine.entity.api;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

/**
 * All entities returned by the Cloud Orchestration Platform must implement
 * this interface.  CloudValueEntity is an immutable representation of 
 * an entity exposed by Cloud Orchestration Platform.  For each object, it
 * defines two ids:  uuid, generated by CloudStack Orchestration Platform, and 
 * an external id that is set by the caller when the entity is created.  All 
 * ids must be unique for that entity.  CloudValueEntity also can be converted 
 * to a CloudActionableEntity which contains actions the object can perform.
 */
public interface CloudStackEntity {
    /**
     * @return the uuid of the object.
     */
    @GET
    String getUuid();

    /**
     * @return the id which is often the database id.
     */
    long getId();

    /**
     * @return current state for the entity
     */
    @GET
    String getCurrentState();

    /**
     * @return desired state for the entity
     */
    @GET
    String getDesiredState();

    /**
     * Get the time the entity was created
     */
    @GET
    Date getCreatedTime();

    /**
     * Get the time the entity was last updated
     */
    @GET
    Date getLastUpdatedTime();

    /**
     * @return reference to the owner of this entity
     */
    @GET
    String getOwner();

    /**
     * @return details stored for this entity when created.
     */
    Map<String, String> getDetails();

    void addDetail(String name, String value);

    void delDetail(String name, String value);

    void updateDetail(String name, String value);

    /**
     * @return list of actions that can be performed on the object in its current state
     */
    List<Method> getApplicableActions();
}
