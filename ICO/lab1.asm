# NAME:
# CCIT4026 Computer Organizatoin
# Lab1
# My first assembly program

.data
Msg1: .asciiz"CCIT 4026 Computer Organization"
NewLine: .asciiz "\n"
Msg2: .byte 65

.text
.globa1_start
_start:

# Print message 1
la $a0, Msg1
li $v0, 4
syscall

# Print NewLine
la $a0, NewLine
li $v0, 4
syscall

# Print message 2
li $v0, 4
la $a0, Msg2
syscall

# Exit from the program
li $v0, 10
syscall