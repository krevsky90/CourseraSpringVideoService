How to start:
    go to krevsky/coursera/videoservice/VideoServiceApplication.java and start it
How to test:
    use src/test/rest/RestVideoServiceSpringTests.http
    execute
        addVideo
        addAllVideos
        getAllVideos
        getVideoByName

The idea:
to remove VideoController and to use @Repository

============= Additional knowledge =============
To test this we use h2 DB that stores data to project directory (i.e. not in-memory option):
info https://www.baeldung.com/h2-embedded-db-data-storage
NOTE: to have ability to look at h2 DB directly via SQL-queries, we have to use 'Databases' tab in Idea IDE,
create DataSource using option 'DataSource from URL'