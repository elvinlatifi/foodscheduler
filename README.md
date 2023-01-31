This is a small program I made for myself which can generate a balanced meal plan for the week and provide a shopping list of necessary ingredients. 

In order to use it, you must create a text file called "dishdata.txt" and fill in the various dishes you prefer to eat in the following format:

Put the name of the dish on the first line  
List the ingredients in the following manner: ingredient1;ingredient2;ingredient3  
Put the "dish type", either "c", "m", "v" or "f", where c is for chicken, m is for meat, v is for vegetarian, and f is for fish.   
Continue with the next dish in the same manner 

An example:  
Hamburger  
hamburger meat;hamburger bread;cheese;bacon;tomatoes etc.  
m 

Once you've filled in your dishes, you can run the program and it will first load in the dishes from the file "dishdata.txt" and then
generate a food schedule in a text file called: "foodschedule.txt". 
Currently it is calibrated so that it wont put two dishes of the same type two days in a row. It also won't put more than 3 meat dishes or 3 chicken dishes in a week, 
or 5 meat/chicken dishes in a week. So if you put in enough dishes, it should produce a fairly varied schedule, with for example 3 chicken dishes, 2 meat dishes, 
1 fish dish, and 1 vegetarian dish. 

The program will also generate a shopping list of ingredients to buy, with no duplicates, in a file called "shoppinglist.txt".
