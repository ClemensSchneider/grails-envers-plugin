/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.lucasward.grails.plugin

import org.hibernate.envers.query.AuditQuery

/**
 * @author Lucas Ward
 */
class PaginationHandler {

    def addPagination(AuditQuery query, Map parameters) {
        def maxResults = parameters["max"]
        def offset = parameters["offset"]
        handleMaxResults(query,maxResults)
        handleOffset(query,offset)
    }

    def handleMaxResults(AuditQuery query, maxResults){
        if(!maxResults){
            return
        }
        query.setMaxResults(maxResults as int)
    }

    def handleOffset(AuditQuery query, offset){
        if(!offset){
            return
        }
        query.setFirstResult(offset as int)
    }
}
