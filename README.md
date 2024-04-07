In this project, we will build a Spring Boot application to establish a REST service for the 'Athlete Directory' application. Through the 'Athlete Directory' application, users can access information about athletes and the countries they represent. 

For the implementation of this application, we need to structure two entities: `Athlete` and `Country`. The `Athlete` entity holds a Many-to-One relationship with the `Country` entity.

Use these files to complete the implementation:

- `AthleteJpaService.java`
- `CountryJpaService.java`

Given a database that contains two tables `athlete` and `country` using the given database schema.

#### Database Schema

#### Country Table

|   Columns    |                 Type                  |
| :----------: | :-----------------------------------: |
|      id      | INTEGER (Primary Key, Auto Increment) |
|     name     |                 TEXT                  |
| flagImageUrl |                 TEXT                  |

#### Athlete Table

|  Columns  |                 Type                  |
| :-------: | :-----------------------------------: |
|    id     | INTEGER (Primary Key, Auto Increment) |
|   name    |                 TEXT                  |
|   sport   |                 TEXT                  |
| countryId |         INTEGER (Foreign Key)         |

<MultiLineNote>

Use only `athlete` and `country` as the table names in your code.

</MultiLineNote>

### Completion Instructions

Given, implementation for the few APIs using the entities `Athlete` and `Country`. Add the service logic for the following APIs in the existing application,

### API 1

---

#### Path: `/countries/{countryId}`

#### Method: `DELETE`

#### Description:

Deletes a country from the `country` table based on the `countryId` and returns the status code `204`(raise `ResponseStatusException` with `HttpStatus.NO_CONTENT`). Also, remove the association with the athletes by keeping a _null_ value in the `athlete` table. 

If the given `countryId` is not found in the `country` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`. 

#### Sample Athlete object when its corresponding Country is deleted

```json
{
    "athleteId": 1,
    "athleteName": "Michael Phelps",
    "sport": "Swimming",
    "country": null
}
```

### API 2

---

#### Path: `/countries/athletes/{athleteId}`

#### Method: `DELETE`

#### Description:

Deletes an athlete from the `athlete` table based on the `athleteId` and returns the status code `204`(raise `ResponseStatusException` with `HttpStatus.NO_CONTENT`). If the given `athleteId` is not found in the `athlete` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

### API 3

---

#### Path: `/countries/{countryId}/athletes`

#### Method: `GET`

#### Description:

Returns all athletes associated with the country based on the `countryId`. If the given `countryId` is not found in the `country` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Success Response:

```json
[
    {
        "athleteId": 1,
        "athleteName": "Michael Phelps",
        "sport": "Swimming",
        "country": {
            "countryId": 1,
            "countryName": "United States",
            "flagImageUrl": "https://example.com/us-flag.png"
        }
    },
    {
        "athleteId": 2,
        "athleteName": "Serena Williams",
        "sport": "Tennis",
        "country": {
            "countryId": 1,
            "countryName": "United States",
            "flagImageUrl": "https://example.com/us-flag.png"
        }
    }
]
```

### API 4

---

#### Path: `/athletes/{athleteId}/country`

#### Method: `GET`

#### Description:

Returns the country associated with the athlete based on the `athleteId`. If the given `athleteId` is not found in the `athlete` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Success Response:

```json
{
    "countryId": 1,
    "countryName": "United States",
    "flagImageUrl": "https://example.com/us-flag.png"
}
```

---

**Do not modify the existing codes in all the files**