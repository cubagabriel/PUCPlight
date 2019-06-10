/**
 *    Copyright 2015, PONTIFICIA UNIVERSIDAD CATOLICA DEL PERU
 *    @author Gabriel Cuba
 *   
 *    Licensed under the Apache License, Version 2.0 (the "License"); you may 
 *    not use this file except in compliance with the License. You may obtain
 *    a copy of the License at
 *    
 *         http://www.apache.org/licenses/LICENSE-2.0 
 *    
 *    Unless required by applicable law or agreed to in writing, software 
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *    License for the specific language governing permissions and limitations
 *    under the License.
 **/

package net.floodlightcontroller.circuittree.web;

import net.floodlightcontroller.restserver.RestletRoutable;

import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class CircuitTreeWebRoutable implements RestletRoutable {


    /**
     * Create the Restlet router and bind to the proper resources.
     */
	@Override
	public Restlet getRestlet(Context context) {
        Router router = new Router(context);
        router.attach("/mice", CircuitTreeResource.class); // POST
        return router;
	}

    /**
     * Set the base path for the ACL
     */
	@Override
	public String basePath() {
        return "/trafficManager";
	}

}
