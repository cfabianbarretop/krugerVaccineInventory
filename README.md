# Kruger Corporation Employee Vaccination Inventory

This is an REST-API Rest to keep track of employee vaccination status inventory.

## Description

This REST-API has two roles: ADMIN and EMPLOYEE.
Admin can register, edit, list and delete employees; get employees list, and filter by vaccine status, vaccine type and dates.
As EMPLOYEE, you can access to your own information and edit it.

## Data model

To provide a solution for this challenge, the following data model is provided:

  [![data-Model.png](https://i.postimg.cc/0jk8PQS0/data-Model.png)](https://postimg.cc/1ndxKyJ8)

* role table contains role's information (ADMIN, EMPLOYEE)
* person table stores person's information
* users table contains user's information and its relationships (role, person)
* vaccine_status table contains status information (VACCINATED, NOT/VACCINATED)
* vaccine_type table stores vaccine types (Sputnik, AstraZeneca, Pfizer, and Jhonson&Jhonson)
* vaccine table stores vaccine's information and its relationships (person, vaccine_type)

## Installation

* Clone this repository.

``` bash
git clone https://github.com/cfabianbarretop/krugerVaccineInventory.git

```

* Prepare database: backup_db_postgres.dump file contains the database backup.

``` bash
psql -h localhost -p 5432 -U postgres -f backup_db_postgres.dump new_db

```

## Usage

A Swagger API Documentation is provided to test this API. You can access it in: http://localhost:8089/swagger-ui/index.html
