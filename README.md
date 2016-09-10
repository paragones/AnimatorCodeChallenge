# DojoCodeChallenge
An Android Source Code for the Dojo Madness Code Challenge

-- Code Design and Architectural Solution

The Framework made for this challenge was initially made with the MVC framework in mind. 
Creating Model Objects, Views, and Controllers to create the whole project. 

Models :

                - Overall - handles the overall attributes for the first component
                - Item - handles each status and time_difference attributes for the second component

Views :

                - MainActivity – handles the activity for the first component. 
                - OverallView – custom view that supports Main Activity and transfer the data from overall object to the activity screen
                - SecondActivity – handles the activity for the second component
                - ItemView - custom view that supports Second Activity and transfer the data from item object to the activity screen
                - ItemViewSet – custom view that handles a list of ItemViews

Controller :

    FirebaseService – handles all the Firebase call to get the data and transfer them to the Model classes. 


-- Usage of Libraries 
  
    Firebase – used to simulate real backend data acquisition from the internet
    EventBus – used as a service handler to transfer objects quickly from the backend to the activity classes 



Requirements Fullfilled:


First Component
  
    •	Percentage of the bigger value – Done. Created CircleProgress Object that extends View to handle the filling of the percentage of the current value against total value 
    
    •	Ring filling color should be customized by parameter – Done. CircleProgress can handle the fill color change thru the attributes or by code
    
    •	The parameters should be passed within the layout xml or within the code - Done. CircleProgress can handle the fill color change thru the attributes or by code
    
    •	The component should support a bottom image passed as a parameter – Done. Used ImageView
    
    •	Component should support multiple devices resolution – can be supported. Although small devices might have a some issues as the minimum height and width is 200 dp.
    
    •	Based in the json trend attribute (“down” or “up”) you will have a down or up arrow on the right side of the bigger number. - Done

Second Component

    •	It should have 3 level of progression bars – Done. Used ItemList adapters to line up the ItemViews horizontally
    
    •	It should have a dotted line in the middle of the component – Done. Used dotted.xml to create a dotted middle line. 
    
    •	Based on the json response the progression indicator should be painted as green, yellow or red (good, ok and bad) – Done. Picked the color for each indicator from the given pdf form. 
    
    •	Draw the progress from the center to the calculated point.

Other Notes:
        -	colors were copied to match the images on the pdf

