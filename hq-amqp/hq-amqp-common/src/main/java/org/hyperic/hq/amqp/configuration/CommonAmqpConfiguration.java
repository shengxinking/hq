package org.hyperic.hq.amqp.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.SingleConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simple config for prototype.
 * @author Helena Edelson
 */
@Configuration
public class CommonAmqpConfiguration {

    /** to consume from the agent */
    protected final String agentQueueName = "queues.agentToServer";

    /** to consume from the server */
    protected final String serverQueueName = "queues.serverToAgent";

    /** to send to a server */
    protected final String serverDirectExchangeName = "exchanges.direct.agentToServer";

    /** to send to an agent */
    protected final String agentExchangeName = "exchanges.direct.serverToAgent";

    protected final String fanoutExchangeName = "exchanges.fanout";    
    protected final String agentSubscriptionName = "exchanges.topic.agentToServer";

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        return new SingleConnectionFactory();
    }

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(rabbitConnectionFactory());
    }

    /**
     * To route to the Server.
     */
    @Bean
    public DirectExchange serverExchange() {
        DirectExchange e = new DirectExchange(serverDirectExchangeName, true, false);
        amqpAdmin().declareExchange(e);
        return e;
    }
 
    /**
     * To consume from the server
     */
    @Bean
    public Queue serverQueue() { 
        return amqpAdmin().declareQueue();
    }

    @Bean
    public DirectExchange agentExchange() {
        DirectExchange e = new DirectExchange(agentExchangeName, true, false);
        amqpAdmin().declareExchange(e);
        amqpAdmin().declareBinding(BindingBuilder.from(agentQueue()).to(e).with(agentQueueName));
        return e;
    }

    /**
     * Server listens on this Queue
     * @return
     */
    @Bean
    public Queue agentQueue() {
        Queue queue = new Queue(agentQueueName);
        amqpAdmin().declareQueue(queue);
        amqpAdmin().declareBinding(BindingBuilder.from(queue).to(serverExchange()).with(serverQueueName));
        return queue;
    }

    /* Specific Queues/Exchanges - these and their creation/binding
       will be pulled out of Spring and done dynamically. */

    @Bean
    public Queue directQueue() {
        return amqpAdmin().declareQueue();
    }


    @Bean
    public Queue fanoutQueue() {
        return amqpAdmin().declareQueue();
    }

    @Bean
    public Queue topicQueue() {
        return amqpAdmin().declareQueue();
    }
 
    @Bean
    public FanoutExchange fanoutExchange() {
        FanoutExchange e = new FanoutExchange(fanoutExchangeName, true, false);
        amqpAdmin().declareExchange(e);
        return e;
    }

    @Bean
    public TopicExchange topicExchange() {
        TopicExchange e = new TopicExchange(agentSubscriptionName, true, false);
        amqpAdmin().declareExchange(e);
        return e;
    }
}