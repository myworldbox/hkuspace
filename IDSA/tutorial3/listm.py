class List:
    def __init__(self, lst=None):
        if lst is None:
                    self.lst = []
        else:
            self.lst = lst

def length(l):
    return len(l.lst)

def isempty(l):
    if len(l.lst)==0:
        return True
    else:
        return False

def get(l, i):
    if isempty(l):
        print("The get() is unsuccessful!")
        print("The list is empty!")
        return -1
    elif (i<1) or (i>length(l)):
        print("The get() is unsuccessful!")
        print("The index given is out of range!")
        return -1
    else:
        return(l.lst[i-1])

def locatebyvalue(l, x):
    position = 1
    for item in l.lst:
        if x == item:
            return position
        else:
            position = position+1
    return -1        

def locatebyid(l, idd):
    position = 1
    for item in l.lst:
        if item.id == idd:
            return position
        else:
            position = position+1
    return -1        

def insert(l, i, x):
    if (i<1) or (i>length(l)+1):
        print("The insert() is unsuccessful!")
        print("The index given is out of range!")
        
    else: 
        l.lst.insert(i-1, x)

def delete(l, i):
    if isempty(l):
        print("The delete() is unsuccessful!")
        print("The list is empty!")
        return
    elif (i<1) or (i>length(l)):
        print("The delete() is unsuccessful!")
        print("The index given is out of range!")
        return
    else: 
        del l.lst[i-1]

def display(l):
    print(l.lst)

def un(setA, setB):
    n = length(setA)
    for i in range(length(setB)):
        x = get(setB, i+1)
        k = locatebyvalue(setA, x)
        if (k==-1):
            insert(setA, n+1, x)
            n = n+1


def inte(setA, setB):
    print(list(set(setA.lst).intersection(setB.lst)))

    
