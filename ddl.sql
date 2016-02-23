select * from sys.systables;

CREATE TABLE APP.UserMaster (
    id varchar(10) not null,
    name varchar(50),
    constraint P_User primary key(id)
);

select * from app.usermaster


CREATE TABLE APP.HOTELAVAILABILITY
     (HOTEL_ID INT NOT NULL, BOOKING_DATE DATE NOT NULL,
    ROOMS_TAKEN INT DEFAULT 0, PRIMARY KEY (HOTEL_ID, BOOKING_DATE));