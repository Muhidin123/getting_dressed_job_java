# getting_dressed_job_java

Problem Description

Problem
You are currently in your house wearing your PJ’s. You must get fully dressed and leave the house.
Your challenge is to programmatically process a list of getting dressed commands, 
enforce related rules, and display appropriate output.




Inputs:

1.  Temperature type(one of the following)

    - HOT
    - COLD


2. Comma separated list of numeric commands

![Alt text](get.dressed/commands.png?raw=true "Commands")


Rules:

You start in the house with your PJ’s on
- Pajamas must be taken off before anything else can be put on
- Only 1 piece of each type of clothing may be put on
- You cannot put on socks when it is hot
- You cannot put on a jacket when it is hot
- Socks must be put on before footwear
- Pants must be put on before footwear
- The shirt must be put on before the headwear or jacket
  
- You cannot leave the house until all items of clothing are on  (except socks and a jacket when it’s hot)
- If an invalid command is issued, respond with “fail” and stop processing commands



Examples Success

Input: HOT 8, 6, 4, 2, 1, 7
Output:Removing PJs, shorts, shirt, sunglasses, sandals, leaving house

Input: COLD 8, 6, 3, 4, 2, 5, 1, 7
Output:Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house

Failure

Input: 	HOT 8, 6, 6
Output:	Removing PJs, shorts, fail

Input:	HOT 8, 6, 3
Output:	Removing PJs, shorts, fail

Input:	COLD 8, 6, 3, 4, 2, 5, 7
Output:	Removing PJs, pants, socks, shirt, hat, jacket, fail
Input:	COLD 6
Output:	fail


To run this program navigate to `get.dressed/src`
run `javac Main.java`
run `java Main.java`
