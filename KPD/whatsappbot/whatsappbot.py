ACCOUNT_SID = 'AC7c6afda537283490a6b85d071c4f985d'
AUTH_TOKEN = '1d5fad25d369e3b5d00478c0d8d792b5'
sender = 'whatsapp:+14155238886'
receiver = 'whatsapp:+85269917180'

from time import sleep
from random import randint
from twilio.rest import Client

text = ['FuCk', 'YoU', 'BiTcH', 'LoL', 'DiCkY', 'AsShOlE']

client = Client(ACCOUNT_SID, AUTH_TOKEN)

for i in range(0, 2):
    word = 'myworldbox [' + str(i) + ']: ' + str(text[randint(0, len(text) - 1)])
    print(word)
    message = client.messages.create(
        body=word,
        from_=sender,
        to=receiver
    )

    sleep(0.8)
