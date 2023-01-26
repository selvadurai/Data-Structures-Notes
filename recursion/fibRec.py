def fib(n):
    if n<=1:
        return n
    return fib(n-1)+fib(n-2)

#print(fib(6))        



def fibM(n,memo):
    print(memo)
    if n<=1:
         return memo[n]

    if  n not in memo:
        memo[n]=fibM(n-1,memo)+fibM(n-2,memo)
        return memo[n] 
    else:
        return memo[n]       

memo={0:0,1:1}
print(fibM(6,memo)) 
