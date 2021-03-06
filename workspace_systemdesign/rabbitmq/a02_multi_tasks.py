#!/usr/bin/env python

import pika
import sys

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

message = ' '.join(sys.argv[1:]) or "Hello World!"

for i in range(20):
    task = message + str(i)
    channel.basic_publish(exchange='',
                          routing_key='hello',
                          body=task)
                      
    print(" [x] Sent %r" % task)
