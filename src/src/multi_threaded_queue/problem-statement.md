# ******Message Queue******

**We have to design a message queue supporting publisher-subscriber model. It should support following operations:**

It should support multiple topics where messages can be published.

Publisher should be able to publish a message to a particular topic.

Subscribers should be able to subscribe to a topic.

Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, should receive the message.

We should be able to reset the offset for a subscriber. This means subscriber will start reading again from offset.
 - Like replaying the messages

Subscribers should be able to run in parallel