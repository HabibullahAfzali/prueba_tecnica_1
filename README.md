# NewONG HUB Service

## Overview
Welcome to the NewONG HUB Service. This project is a part of Self Project,  dedicated to combating hunger and malnutrition worldwide. The HUB Service is designed to connect the headquarters (HQs) of different countries and aggregate mission data into a unified response.

## Features

- **Centralized Search**: The HUB receives a search request in a common format and translates it to requests for various HQs.
- **Integration with HQs**: Currently integrates with a Country(France), with plans for more.
- **Data Aggregation**: Aggregates responses from multiple HQs into a single, unified format.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Jackson for JSON parsing**
- **Lombok for reducing boilerplate code**

## Project Structure
src/
└── main/
├── java/
│ └── com/
│ └── newong/
│ └── hub/
│ ├── controller/
│ │ └── HubController.java
│ ├── model/
│ │ ├── HubMission.java
│ │ ├── HubRequest.java
│ │ ├── HubResponse.java
│ │ ├── HubVolunteer.java
│ │ ├── NewONGFranceResponse.java
│ │ └── NewONGFranceResult.java
│ ├── service/
│ │ ├── IHeadquarterAPI.java
│ │ └── NewONG_France.java
│ └── HubApplication.java
└── resources/
└── application.properties



## How to Run

1. **Clone the Repository**:
   ```sh
   git clone <repository-url>
   cd newong-hub

## Make sure your have the environment ready/ I used InteliJ Idea Community Edition
1. Run the application
2. try the bellow URI to test the application
http://localhost:8080/api/hub/search

### Examples

# Post method
{
    "missionCountry": "XX"
}


# Response should be
{
    "country": [
        {
            "missionId": 1,
            "volunteers": [
                {
                    "name": "Gerard",
                    "age": 28,
                    "hq": "NewONG_France"
                }
            ]
        },
        {
            "missionId": 2,
            "volunteers": [
                {
                    "name": "Gerard",
                    "age": 28,
                    "hq": "NewONG_France"
                }
            ]
        }
    ]
}

