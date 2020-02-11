from listm import *
from studentm import *

history = []
student1 = Student('001', 'Jack', 'M', 'P001')
student2 = Student('002', 'Sally', 'F', 'P002')
student3 = Student('003', 'Amy', 'F', 'P002')
student4 = Student('004', 'Mary', 'F', 'P002')
student5 = Student('005', 'Jerry', 'M', 'P003')
student6 = Student('006', 'Terry', 'M', 'P003')
student7 = Student('007', 'Tom', 'M', 'P003')
student8 = Student('008', 'Ann', 'F', 'P004')
student9 = Student('009', 'Dick', 'M', 'P004')

students = [student1, student2, student3, student4, student5, student6, student7, student8, student9]
# students = List()

while password() != True:
    password()

choice = menu()

while (choice != 0):
    if (choice == 1):
        listlen = length(students)
        print(f"The size of the student list is {listlen}.")
        print("Press enter to continue.")
        input('')
    elif (choice == 2):
        student = inputstinfo()
        students.append(student)
        print("The appending function is done.")
        print("Press enter to continue.")
        input('')
    elif (choice == 3):
        print("Please input the position:", end='')
        position = int(input())
        student = inputstinfo()
        students.insert(position-1, student)
        print("The insertion function is done.")
        print("Press enter to continue.")
        input('')
    elif (choice == 4):
        print("Please input the position:", end='')
        position = int(input())
        students.remove(students[position - 1])
        print("The deletion function is done.")
        print("Press enter to continue.")
        input('')
    elif (choice == 5):
        print("Please input the student id:", end='')
        sid = input()
        position = locatebyid(students, sid)
        if position < 0:
            print(f"Student with {sid} does not exist.")
        else:
            print(f"Student with {sid} is at position {position}")
            history.insert(0,students[position - 1])
            if len(history) == 6:
                del students[0]

        print("The locate function is done.")
        print("Press enter to continue.")
        input('')
    elif (choice == 6):
        print("Please input the position:", end='')
        position = int(input())
        student = get(students, position)
        if student != -1:
            displaystinfo(student)
        else:
            print(f"There is no student at position {position}")
        print("The get function is done.")
        print("Press enter to continue.")
        input('')
    elif (choice == 7):

        for i in range(len(students)):
            print('id: ', students[i].id, '\nprogram id: ', students[i].pid, '\nsex: ', students[i].gender, '\nname: ',
                  students[i].name, '\n\n')

        print("The display function is done.")

        print("Press enter to continue.")
        input('')
    elif (choice == 8):
        print("choice 8")
        locatebypid(students)
        print("The locate function is done.")
        print("Press enter to continue.")
        K = input('')
    elif (choice == 9):
        print("choice 9")
        x = 0
        for obj in history:
            if x < 5:
                print('\nid: ', obj.id, '\nname: ', obj.name, '\n')
            x = x +1

        if len(history) < 5 :
            print('no five search!')
        print("Press enter to continue.")
        input('')
    elif (choice == 10):
        print("Now quit, thank you!")
    elif (choice == 11):
        chagne_pw()
    choice = menu()
