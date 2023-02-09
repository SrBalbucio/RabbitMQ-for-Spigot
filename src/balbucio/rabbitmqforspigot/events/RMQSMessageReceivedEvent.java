package balbucio.rabbitmqforspigot.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class RMQSMessageReceivedEvent extends Event{
	
	private String message;
	private Channel channel;
	private Connection connection;

	public RMQSMessageReceivedEvent(String message, Channel channel, Connection connection) {
		this.message = message;
		this.channel = channel;
		this.connection = connection;
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
