# RabbitMQ for Spigot
Use esta API para criar e receber mensagens usando RabbitMQ no Spigot, basta registrar uma fila, enviar uma mensagem e receber a mensagem em um evento Spigot.

## Como usar
Todas as funções do RabbitMQ for Spigot ficam na classe RMQS.
Portanto, crie uma instância da classe RMQS como feito abaixo:
```java 
//Crie o RMQS usando IP e porta
RMQS rmqs = new RMQS(<host>, <port>);
```

## Registre uma fila
Para começar a enviar mensagens você precisa registrar a fila na qual a mensagem deve ir e vir:
```java
rmqs.registerQueue("fila");
rmqs.getQueues(); // Pega todas as filas registradas
```
## Envie uma mensagem
Com  a fila criada, vamos enviar uma mensagem:
```java
//Adicione a mensagem e a fila no qual deve ser enviado
rmqs.sendMessage(<mensagem>, <fila>); 
```

## Receba mensagens em eventos
Os eventos que o RMQS proporciona são:
```java
  // Quando uma mensagem foi enviada
	@EventHandler
	public void onSent(RMQSMessageSentEvent evt) {}
  
  // Quando uma mensagem é recebida
	@EventHandler
	public void onReceived(RMQSMessageReceivedEvent evt) {}
```
