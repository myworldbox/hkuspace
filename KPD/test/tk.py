from tkinter import *

height = 500
width = 500
root = Tk()

canvas = Canvas(root, height=height, width=width)
canvas.pack()

frame = Frame(root, bg='blue')
frame.place(relx=0.1, rely=0.1, relheight=1, relwidth=1)

button = Button(frame, text='fuck you', bg='white')
button.pack()

label = Label(frame,text='bitch',bg='red')
label.pack()

entry = Entry(frame)
entry.pack()

root.mainloop()
