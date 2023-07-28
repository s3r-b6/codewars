Today I found out that Codewars does not allow a random user to see your
solutions to a kata. Part of the point of doing them and uploading them was to
show them so I wrote a small program that reads the solutions from the HTML and
writes it to files after formatting them. 

Kind of messy but I put it together in a few hours and it does work, maybe I
will make this better sometime... but I honestly just want to have it working. 

The sol.html file is just the html portion (formatted) from the page that
starts at:
``` 
<div class="items-list w-full md:w-2/3 md:pl-4 md:border-l md:grow"> 
```
Which should contain the full list of solutions if the page has been scrolled
to the bottom.

NOTE: Biggest number is actually the oldest solution, not the newest.
