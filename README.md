# Hotel Reservation System (A00442283 - Maria Alex Kuzhippallil)


## API Details
Base URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com

### API Call 1 - GET Hotel List
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/hotelsList

### API Call 2 - POST Hotel Reservation
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/reservation

![image](https://user-images.githubusercontent.com/77292688/124045797-d5f15300-d9e6-11eb-9474-df5af07ea3d1.png)


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

![image](https://user-images.githubusercontent.com/77292688/124045690-90348a80-d9e6-11eb-8ecc-2129b4dfece9.png)



### API Call 3 - POST Hotel 
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/addHotels

#### Sample Request Body
```
{
    "hotel_name":"Meridian",
    "availability":false,
    "price":300
}
```

### API Call 4 - GET Reservations
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/reservationList





