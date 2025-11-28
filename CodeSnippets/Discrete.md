# Required imports

```Python
import math
```


## Find count of derangements
```Python
# Variables:
upToDerangement = 20

# Code:
for i in range(1, upToDerangement):
    fracResult = 1
    
    for j in range(1, i+1):
        if j%2 == 0:
            fracResult += 1/math.factorial(j)
        else:
            fracResult -= 1/math.factorial(j)
        
    value = math.floor(math.factorial(i) * fracResult)
    
    print("D_", i, ": ", value, sep="")
```


Notes:
GCD
Chinese Remainder
Inclusion-Exclusion