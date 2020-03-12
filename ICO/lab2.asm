#--------------------------------
    # name: Leung Cheuk Hei
    # student ID: 20089762
     
.data
#--------------------------------
    #define variables
    
     input1: .space 20
     input2: .space 20
     question1: .asciiz"Please enter your nickname: "
     question2: .asciiz"Please enter your surname: "
     question3: .asciiz"How old are you? "
     str1: .asciiz "You are "
     str2: .asciiz" years old."
     
.text
#--------------------------------
    #print out question 1 and store input
    
        li $v0, 4
        la $a0, question1
        syscall
     
        li $v0, 8   
        la $a0, input1
        li $a1, 20  
        syscall
       
#--------------------------------
    #print out question 2 and store input
    
        li $v0, 4
        la $a0, question2  
        syscall
        
        li $v0, 8
        la $a0, input2   
        li $a1, 20      
        syscall
                
#--------------------------------
    #print out input 1
    
        li $v0, 4
        la $a0, input1
        syscall
        
#--------------------------------
    #print out input 2
        
        li $v0, 4
        la $a0, input2
        syscall
        
#--------------------------------
    #print out question 3 and store input

        li $v0, 4
        la $a0, question3 
        
        syscall
 
        li $v0, 5
        syscall
     
        move $t0, $v0
 
#--------------------------------
    #print out str 1, str2 and answer
    
        li $v0, 4
        la $a0, str1
        syscall

        li $v0, 1
        move $a0, $t0
        syscall

        li $v0, 4
        la $a0, str2
        syscall

#--------------------------------
    #exit the program
        li $v0, 10
        syscall
