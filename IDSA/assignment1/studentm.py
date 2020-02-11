class Student:
    def __init__(self, sid=None, name=None, gender=None, pid=None):
        if sid is None:
            self.id = ""
        else:
            self.id = sid
        if name is None:
            self.name = ""
        else:
            self.name = name
        if gender is None:
            self.gender = ""
        else:
            self.gender = gender
        if pid is None:
            self.pid = ""
        else:
            self.pid = pid


def menu():
    print("\n")
    print("\n")
    print("\n")
    print("	Please type 1-8 for student record action")
    print("	1 - Return the size of the list")
    print("	2 - Append a new record at the end")
    print("	3 - Insert a new record at position i")
    print("	4 - Delete the record at position i")
    print("	5 - Locate a record based on student ID")
    print("	6 - Display the record at position i")
    print("	7 - Display all the records")
    print("	8 - Search by programme")
    print("	9 - Search history")
    print("	10 - Quit")
    print("	11 - Enter the new password")
    print("\n")
    choice = int(input("	Your choice: "))
    print("\n")
    print("\n")
    print("\n")
    return choice


def inputstinfo():
    sid = input("Please input the student's id: ")
    name = input("Please input the student's name: ")
    gender = input("Please input the student's gender: ")
    pid = input("Please input the student's program id: ")
    tmps = Student(sid, name, gender, pid)
    return tmps


def displaystinfo(student):
    print(f"The student's info are: {student.id}, {student.name}, {student.gender}, {student.pid}.")


def password():
    f = open('password.txt', 'r')
    pw = input('Please enter the password to continue: ')
    if f.read() == pw:
        print(pw, f.read())
        return True
    else:
        return False


def chagne_pw():
    f = open('password.txt', 'w')
    pw = input('Please enter the new password: ')
    f.write(pw)
    f.close()
