# ZeroToJuniorMapBravo

The aim of the project is to create a simple application that shows on the map where Z2J participants live.

![Where are you from?](https://user-images.githubusercontent.com/36161561/217615692-4bbf41a1-3e2e-4ee7-94bd-da205ec4b340.png)

Input: Form -> discord nickname, place of residence (initially - city, zip code, country).
Output: Map with dots representing where Z2J participants live.
Optional -> Find the closest people from Z2J to arrange a coffee or coding together.

Initial backend stack:
Java 17, JDBC, PostgreSQL database, connecting to the frontend via REST API.

Initial plan/task list:

    1. Create database
    2. Create all model classes
    3. Connect db to the project using JDBC
    4. Map objects from java to records in db
