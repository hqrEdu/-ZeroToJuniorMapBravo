
If you dont have PostgresSQL on device install it via link: https://www.youtube.com/watch?v=7zsRpTRsSs0

A. Run script using pg admin

Run the script

1. Opnen pg admin panel
2. Create db -> mapa-bravo
3. Go to query tool
4. Select script file
5. Execute

B. Run using console

1. Add PostgresSQL to the path variable via this link: https://sqlbackupandftp.com/blog/setting-windows-path-for-postgres-tools
2. Open cmd
3. Login as a psql user -> psql -U postgres
4. Create database -> CREATE DATABASE "mapa-bravo";
5. Connect to database -> \c mapa-bravo
6. Ensure that the script stops running if it encounters an error -> \set ON_ERROR_STOP on
7. Run the script -> \i 'path/db_script.sql' where 'path' is a path to the script, 
IMPORTANT -> Remember to replace backslashes in the file path with forward slashes.