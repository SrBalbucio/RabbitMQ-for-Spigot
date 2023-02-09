package balbucio.rabbitmqforspigot.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class RMQSMessageSentEvent extends Event {
	
	private String message;
	private Channel channel;
	private Connection connection;
	private String queue;
	

	public RMQSMessageSentEvent(String message, String queue, Channel channel, Connection connection) {
		this.message = message;
		this.channel = channel;
		this.connection = connection;
	}


	

	public String getQueue() {
		return queue;
	}

	public String getMessage() {
		return message;
	}


	public Channel getChannel() {
		return channel;
	}


	public Connection getConnection() {
		return connection;
	}


	@Override
	public HandlerList getHandlers() {
		return new HandlerList();
	}

}
