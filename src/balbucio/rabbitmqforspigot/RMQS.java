package balbucio.rabbitmqforspigot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import balbucio.rabbitmqforspigot.events.RMQSMessageReceivedEvent;

public class RMQS {
	
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private String queue;
	
	public RMQS(String host, int port) throws Exception{
		factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		connection = factory.newConnection();
		channel = connection.createChannel();

	}
	
	private List<String> queues = new ArrayList<>();
	
	public void registerQueue(String queue) throws IOException {
		queues.add(queue);
	    channel.queueDeclare(queue, false, false, false, null);
	    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	        String message = new String(delivery.getBody(), "UTF-8");
	        Bukkit.getPluginManager().callEvent(new RMQSMessageReceivedEvent(message, channel, connection));
	    };
	    channel.basicConsume(queue, true, deliverCallback, consumerTag -> {});
	}
	
	public void sendMessage(String message) throws IOException {
		channel.basicPublish("", queue, null, message.getBytes());
	}
	
	public List<String> getQueues(){
		return queues;
	}

}
