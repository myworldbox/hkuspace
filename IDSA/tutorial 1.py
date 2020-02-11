numbers = []
finish = 0

while(finish == 0):
    
    number = int(input("\nPlease input a positive integer to [0] to stop: "))
    
    if (number != 0):
        
        numbers.append(number)
                
        print("\nThe smallest number is: "+str(min(numbers)))

    else:
    
        finish = 1

