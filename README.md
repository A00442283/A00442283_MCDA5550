# Hotel Reservation System (A00442283 - Maria Alex Kuzhippallil)


## API Details
Base URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com

### API Call 1 - GET Hotel List
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/hotelsList

### API Call 2 - POST Hotel Reservation
URL -> http://hotelreservation-env.eba-y5iiasyg.us-east-1.elasticbeanstalk.com/reservation

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
              "gender":"FEMALE"
            },    
            {
              "guest_name":"Alex",
              "gender":"MALE"
            }
        ]
    } 
    
}
```


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





