/**
 *    Copyright 2013, Big Switch Networks, Inc.
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

package net.floodlightcontroller.virtualnetwork;

import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import net.floodlightcontroller.restserver.RestletRoutable;

public class VirtualNetworkWebRoutable implements RestletRoutable {

    @Override
    public Router getRestlet(Context context) {
        Router router = new Router(context);
        router.attach("/tenants/{tenant}/networks", NetworkResource.class); // GET
        router.attach("/tenants/{tenant}/networks/{network}", NetworkResource.class); // PUT, DELETE
        router.attach("/tenants/{tenant}/networks", NetworkResource.class); // POST
        router.attach("/tenants/{tenant}/rules/type/{type}/network/{vnid}", RuleResource.class);
        router.attach("/tenants/{tenant}/rules/type/{type}/network/{vnid}", RuleResource.class);
        router.attach("/tenants/{tenant}/networks/filter/{network}", IsolatingResource.class);
        router.attachDefault(NoOp.class);
        return router;
    }

    @Override
    public String basePath() {
        return "/networkService/v1.1";
    }
}