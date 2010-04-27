/*
 * NOTE: This copyright does *not* cover user programs that use HQ
 * program services by normal system calls through the application
 * program interfaces provided as part of the Hyperic Plug-in Development
 * Kit or the Hyperic Client Development Kit - this is merely considered
 * normal use of the program, and does *not* fall under the heading of
 * "derived work".
 *
 * Copyright (C) [2004-2008], Hyperic, Inc.
 * This file is part of HQ.
 *
 * HQ is free software; you can redistribute it and/or modify
 * it under the terms version 2 of the GNU General Public License as
 * published by the Free Software Foundation. This program is distributed
 * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */

package org.hyperic.hq.agent.client;

import org.hyperic.hq.appdef.Agent;
import org.hyperic.hq.bizapp.agent.client.SecureAgentConnection;
import org.hyperic.hq.transport.AgentProxyFactory;
import org.hyperic.hq.transport.ServerTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A factory for returning Agent Commands clients depending on if the agent uses
 * the legacy or new transport.
 */
@Component
public class AgentCommandsClientFactory {

    private ServerTransport serverTransport;

    @Autowired
    public AgentCommandsClientFactory(ServerTransport serverTransport) {
        this.serverTransport = serverTransport;
    }

    public AgentCommandsClient getClient(Agent agent) {
        if (agent.isNewTransportAgent()) {
            AgentProxyFactory factory = serverTransport.getAgentProxyFactory();

            return new AgentCommandsClientImpl(agent, factory);
        } else {
            return new LegacyAgentCommandsClientImpl(new SecureAgentConnection(agent.getAddress(),
                agent.getPort(), agent.getAuthToken()));
        }
    }

    public AgentCommandsClient getClient(String agentAddress, int agentPort, String authToken,
                                         boolean isNewTransportAgent, boolean unidirectional) {
        if (isNewTransportAgent) {
            AgentProxyFactory factory = serverTransport.getAgentProxyFactory();

            return new AgentCommandsClientImpl(factory, agentAddress, agentPort, unidirectional);
        } else {
            return new LegacyAgentCommandsClientImpl(new SecureAgentConnection(agentAddress,
                agentPort, authToken));
        }
    }

}