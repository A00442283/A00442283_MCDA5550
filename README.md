# Hotel Reservation System (A00442283 - Maria Alex Kuzhippallil)

## ANDROID Screenshots

![image](https://user-images.githubusercontent.com/77292688/126405549-594681b5-0b3a-42ad-82e5-28df536ace00.png) 
![image](https://user-images.githubusercontent.com/77292688/126405559-259dbe23-2b29-4a2b-9dc8-d0a36f76f2d5.png) 
![image](https://user-images.githubusercontent.com/77292688/126405573-a9d43173-8d2c-4ea9-ac81-6281f5f5ca70.png) 
![image](https://user-images.githubusercontent.com/77292688/126405593-37d78189-ed66-46ae-8084-a28574e86f57.png) 



## API Details
Base URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com

### API Call 1 - GET Hotel List
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/hotelsList

##### Description 
Displays the List of Hotels 

![image](https://user-images.githubusercontent.com/77292688/124045797-d5f15300-d9e6-11eb-9474-df5af07ea3d1.png)

### API Call 2 - POST Hotel Reservation
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/reservation

##### Description 
Post the reservation details which includes Hotel Name, Reservation, Check In, Check Out and Guest List.

#### Sample Request Body
```
{ 

  "hotel_name":"Meridian",
  "reservation":{
    "checkin":"26/08/2021",
    "checkout":"21/08/2021",
    "guests_list":[
           {
              "guest_name":"Maria",
              "gender":"Female"
            },    
            {
              "guest_name":"Alex",
              "gender":"Male"
            }
        ]
    } 
    
}
```

![image](https://user-images.githubusercontent.com/77292688/124338362-e7209800-db7d-11eb-87ca-3b0d7547dcf7.png)



### API Call 3 - POST Hotel 
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/addHotels

##### Description 
Adds Hotel details with Hotel Name, Availability and Price

#### Sample Request Body
```
{
    "hotel_name":"Meridian",
    "availability":false,
    "price":300
}
```

![image](https://user-images.githubusercontent.com/77292688/124046027-662f9800-d9e7-11eb-9f36-9c145ae1b136.png)


### API Call 4 - GET Reservations
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/reservationList

##### Description 
Obtains all the reservations

![image](https://user-images.githubusercontent.com/77292688/124046234-d63e1e00-d9e7-11eb-87ea-d4e326e74a3a.png)


## Used JPA Presistance

![image](https://user-images.githubusercontent.com/77292688/124046585-a5121d80-d9e8-11eb-87c8-845d4febc3ba.png)







