import org.bukkit.event.EventHandler;

import balbucio.rabbitmqforspigot.events.RMQSMessageReceivedEvent;
import balbucio.rabbitmqforspigot.events.RMQSMessageSentEvent;

public class Listener implements org.bukkit.event.Listener{
	
	@EventHandler
	public void onSent(RMQSMessageSentEvent evt) {}

	@EventHandler
	public void onSent(RMQSMessageReceivedEvent evt) {}

}
