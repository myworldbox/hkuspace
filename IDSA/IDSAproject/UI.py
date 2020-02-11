from random import *


def input_1():  # Ask for choice
    choice = int(input(
        '\n\n【Menu】\n\n1. Start\n2. Read file\n3. Save new file\n4. Quit\n\nChoice: '))
    return choice


def input_2():  # Ask for input of the row and column for matrix generation
    x = int(input('\n\nMaximum column: '))
    y = int(input('Maximum row: '))
    return x, y


def input_3():  # Ask for game mode
    mode = int(input('\n\n\n1. Game mode\n2. Computer mode\n3. Menu\n\nChoice: '))
    return mode


def record(history):  # Open file with password
    cipher = ''
    file = str(input('\n\nFile name: '))
    password = str(input('Password: '))
    txt = open(file + '.txt', 'r')

    for i in txt:
        for j in i:
            cipher = cipher + str(chr(ord(j) - int(password)))
    print('\n\n【History】\n▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼\n', cipher,
          '▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲')


def output(history):  # Save file with password
    cipher = ''
    file = str(input('\n\nNew file name: '))
    password = str(input('New numerical password: '))
    with open(file + '.txt', 'w') as txt:

        for i in history:
            for j in i:

                for k in j:
                    cipher = cipher + str(chr(ord(k) + int(password)))
        txt.write(cipher)
    txt.close()
    print('\n[Done!]')
