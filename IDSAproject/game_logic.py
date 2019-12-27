from UI import *


def value(history, mode, x, y, a, b):  # Redraw the matrix according to mode

    if mode == 1:
        while a not in {'c', 'r'} or (a in {'c'} and b > x) or (a in {'r'} and b > y):
            a, b = choice_1()
        change = 'Choice: '

    elif mode == 2:
        a = choice(['c', 'r'])

        if a == 'r':
            b = randint(1, y)
        elif a == 'c':
            b = randint(1, x)

        print('\n\nComputer choice: ', str(a) + str(b))
        change = 'Computer choice: '
    commend = str(a), str(b)

    history.extend(['\n\n', change, commend, '\n\n'])

    return history, a, b


def choice_1():  # Ask for input of the row and column for the customised matrix
    commend = str(
        input('\n\nEnter the row / column number with the following format \n(eg. r1 for row 1)\n\nChoice: '))
    a = str(''.join(filter(str.isalpha, commend)))
    b = int(''.join(filter(str.isdigit, commend)))
    return a, b


def matrix_1(matrix, x, y):  # Generate the original matrix
    for i in range(y):

        matrix.append([])

        for j in range(x):
            matrix[i].append(randint(-50, 50))

    return matrix


def matrix_2(matrix, x, y, a, b):  # Redefine the column and row
    if 'c' in a:

        for i in range(y):
            matrix[i][b - 1] = -matrix[i][b - 1]

    elif 'r' in a:

        for j in range(x):
            matrix[b - 1][j] = -matrix[b - 1][j]

    return matrix


def draw(history, matrix, x, y):  # Draw the matrix with row and column sum
    all_sum = []
    print('\n')

    for i in matrix:

        print(i, end='')

        if len(i) == x:
            print(sum(i), '\n')
            word = str(str(i) + str(sum(i)))
            history.extend(['\n', word, '\n'])

    for j in range(x):

        y_sum = 0

        for k in range(y):
            y_sum += int(matrix[k][j])

        print("{:5}".format(str(y_sum)), end='')
        all_sum.append("{:5}".format(str(y_sum)))
    history.extend(['\n', all_sum, '\n'])
