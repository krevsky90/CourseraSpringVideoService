How to start:
    go to krevsky/coursera/videoservice/VideoServiceApplication.java and start it
How to test:
    use src/test/rest/RestVideoServiceSpringTests.http
    execute
        addVideo
        getAllVideos
        getVideoByTitle
        getVideoByDurationLessThan

==============
The idea:
to remove VideoController and just use @RepositoryRestResource

==============
My position:
Pros:
RepositoryRestResource allows us to use ready REST-structure that is applied to our resource ("video").
So we don't need to invent the paths for our resource to perform CRUD operation or find smth.
Cons:
We cannot our own URIs => for example, I don't know how to addAll videos using RepositoryRestResource

==============

NOTE:
    I had to remove addAllVideos POST reuest and rewrite getVideoBy... REST queries since we use @RepositoryRestResource =>
    " 1. List all videos by sending a GET request to /video
      2. Add a video by sending a POST request to /video with the JSON for a video
      3. Get a specific video by sending a GET request to /video/{videoId}
         (e.g., /video/1 would return the JSON for the video with id=1)
      4. Send search requests to our findByXYZ methods to /video/search/findByXYZ
         (e.g., /video/search/findByName?title=Foo)"


============= Additional knowledge =============
To test this we use h2 DB that stores data to project directory (i.e. not in-memory option):
info https://www.baeldung.com/h2-embedded-db-data-storage
NOTE: to have ability to look at h2 DB directly via SQL-queries, we have to use 'Databases' tab in Idea IDE,
create DataSource using option 'DataSource from URL'