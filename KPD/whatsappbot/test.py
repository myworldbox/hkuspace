# Download the helper library from https://www.twilio.com/docs/python/install
from twilio.rest import Client
from set_up import *


# Your Account Sid and Auth Token from twilio.com/console
# DANGER! This is insecure. See http://twil.io/secure

client = Client(account_sid, auth_token)

message = client.messages \
    .create(
    body=word,
    from_=sender,
    to=receiver
     )

print(message.sid)
