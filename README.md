# motorcycleapp-dilshad
## Title: Motorcycle app ##
### Description: ###
 The objective of this web application is to showcase rich collection of used motorcycles of all models that are in good condition.  It helps people to select and purchase the requried motorcycle based on their choice.
- - - -
#### This app has the following features ####

  ##### Feature 1 - Display current bikes. #####
   This feature displays the specificationS of available bikes in the show room. 
    It is shown in the form of table.  
    
 ##### Feature 2 - Add bike. #####
   When bike is sold by someone, the complete details of the bike has to stored in the database.
   
 ##### Feature 3 - Remove bike ##### 
   When the bike got sold, the details of the corresponding bike has to be removed from the database.
   
   ##### Feature 4 - Update bike details #####
   With respect to time the **odometer reading** and the **price** of the bike changes. 
   It has to be updated periodically.
   
  ##### Feature 5 - Admin Login & Registration #####
   Only admin has the priviledge access to modify the database such as adding, removing and updating bikes.  
   
   ##### Feature 6 -  Search bike by plate number #####
   Plate number being unique is used as a primary key.  It is used to identify the bike which gives the 
   complete specification.
    
   ##### Feature 7: Sort bikes by model #####
   This feature enables to group bikes based on bike model or bike manufacturer.  It helps user to 
   shortlist the bikes and choose the right one as they wish.
      
  ##### Feature 8: Shortlist bikes based on price #####
   This feature enables user to specify the upper and lower price limits.  The list of bike will be displayed in ascending order for the specified price limit. Customer can plan for the budget quickly.
   
   ##### Feature 9: Verify Bike status #####
   This feature is ment for admin and brokers. Once the bike is added by admin, the same or other admin has to go to the site and verify the bike details, conditions etc.  Only if it mets the standard requirement, admin can switch the status of bike from NOT_VERIFIED to VERIFIED, then only it is visible to public, else it is visible only to admins.  If the entered details is not fine, then admin has the right to remove bike & owner details from the database.

----
 ## Bike specification fields ##
      String bikeManufacturer - 2 to 20 character, only alphabets
      
      String bikeModel - 2 to 20 characters, only alphabets and number
      
      String bikeColor - 2 to 20 characters, only alphabets
      
      Integer bikePrice - Rs.[0 - 3L]  Rs.0/- represents if any Jackpot price and 3 lakhs is the maximum price.
      
      Integer km - (odometer reading) - [0 - 2L]Kilometers
      
      Integer manufactureYear - year of manufacture of motorcycle - limit [1970 - current year]
      
      Boolean status - '0' - NOT VERIFIED  '1' - VERIFIED
      
      Hash map <String, String> engineDetails
        fuelType - Petrol/Diesel/Electric/Gas
        
        VIN (Vehicle Identification Number) - strictly 17 alphanumeric characters (e.g. DFG65HJ6543FT9NJ7), 
        only capital letters, pattern [A-Z0-9]{17}
        
        Plate number - e.g. TN34D3454, TN23GR4567, TN32TGF3496 (3 possibilities), only in capital letter, 
        pattern [A-Z]{2}[0-9]{2}[A-Z]{1,3}[0-9]{4}, strictly 9 to 11 alphanumeric characters.
        
        
   ## Admin Details ##
    String name - 2 to 20 characters, alphabets only

    String ID - 15 characters, numbers & alphabets only

    String password - 4 to 20 characters, alphabets, numbers & all special characters.   

## Owner Details
```
String bikePlateNo - strictly 17 alphanumeric characters (e.g. DFG65HJ6543FT9NJ7), only capital letters, pattern [A-Z0-9]{17}. 
                       Links bike details and owner details.

String ownerName - 2 to 20 characters

String ownerAddress - 5 to 200 characters

Long ownerPhoneNo - Strictly 10 digits. Should start with 9,8,7 or 6.
```
----

 ## Benefits ##
* People who migrate can purchase used bikes for temporary usage.
* Situation in which you may use vehicle only weekly or monthly etc.
* Used bikes may costs only half of the new bike price.
* Useful for people who wants to own vehicle at low budget.
* Additional features could be included based on the requirement.

----
