from game_logic import *

choice = 1
history = []

while choice != 4:  # Quit for choice 4

    matrix = []
    a = b = ''
    x = y = mode = 0

    choice = input_1()

    if choice == 1:  # Start the game

        while x not in range(1, 11) or y not in range(1, 11):  # Prevention for invalid input of row or column
            x, y = input_2()

        matrix = matrix_1(matrix, x, y)
        draw(history, matrix, x, y)

        while mode != 3:  # Check for operation
            a = b = ''
            mode = input_3()
            if mode != 3:  # Avoid invalid drawing
                history, a, b = value(history, mode, x, y, a, b)
                matrix = matrix_2(matrix, x, y, a, b)
                draw(history, matrix, x, y)

    elif choice == 2:  # Let user open file with password
        record(history)

    elif choice == 3:  # Let user save file with password
        output(history)
