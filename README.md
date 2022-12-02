# mc3
МС3 принимает сообщение от МС2,  
записывает в поле сообщения “МС3_timestamp” текущее время  
и отправляет сообщение в МС1 посредством отправки http запроса POST с телом, содержащим сообщение;

# project

packages
- kafka
  - KafkaConfig setups configuration for kafka consumer
  - KafkaConsumer kafka listener to consume the message, update and send to mc1
  - Message the object being sent
  - MessageService updates the message time stamp 
- post
  - SendPost Spring RestTemplate generates POST request with the message and sends it to mc1