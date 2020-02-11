def cadd(a, b, c, d):
    e = a + c
    f = b + d
    return e, f


def csub(a, b, c, d):
    e = a - c
    f = b - d
    return e, f


def ctimes(a, b, c, d):
    e = (a * c - b * d)
    f = (a * d + b * c)
    return e, f


def cpower(a, b):
    c = (a * a - b * b)
    d = (a * b + b * a)
    return c, d


def cdis(e, f):
    print("\nThe result: " + str(e) + " + " + str(f) + "i")


def fent():
    a = int(input("\nPlease enter the real part of the first number: "))
    b = int(input("Please enter the imaginary part of the first number: "))
    return a, b


def sent():
    c = int(input("Please enter the real part of the second number: "))
    d = int(input("Please enter the imaginary part of the second number: "))
    return c, d
