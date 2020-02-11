from operation import *

decision = 1

while (decision == 1):

    choice = int(input(
        "\n1.addition\n2.subtraction\n3.Multiplication\n4.Power operation\n\nEnter the corresponding operation you want to undergo with your complex number: "))

    a, b = fent()

    if (choice == 4):
        e, f = cpower(a, b)

    if (choice != 4):

        c, d = sent()

        if (choice == 1):
            e, f = cadd(a, b, c, d)

        if (choice == 2):
            e, f = csub(a, b, c, d)

        if (choice == 3):
            e, f = ctimes(a, b, c, d)

    cdis(e, f)

    decision = int(input("\nEnter 1 to continue or anything to quit: "))
