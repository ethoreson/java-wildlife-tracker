## Wildlife Tracker

An app for the forest service to track animals for an environmental impact study.

### Description

The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. This application was developed to allow Rangers to track wildlife sightings in the area.

### Setup

To create the necessary databases, launch postgres, then psql, and run the following commands:

* `CREATE DATABASE wildlife_tracker;`
* `\c wildlife_tracker;`
* `CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, endangered boolean);`
* `CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar, sighting_time timestamp);`
* `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`


# Changes Made

- Changed 'false' to 'true' for two Animal tests.
- Inheritance: Animal became parent class to EndangeredAnimal.
- added getter Method for endangered boolean attribute.
- Added health and age constants
- added #if blocks in index.vtl to only display endangered or not endangered animals (based off getEndangered())
- Implemented single table inheritance (see setup instructions above)
- Added timestamps for sightings


### License

Copyright (c) 2017 **_MIT License_**
