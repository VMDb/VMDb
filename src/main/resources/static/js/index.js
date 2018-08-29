var currentMoviePoster = null;

function displaySelectedMovie(index, movie) {
    console.log(movie)
    var moviePoster = document.getElementsByClassName('poster')[index];
    if (moviePoster === currentMoviePoster) {
        return
    }
    returnSelectedMovie(currentMoviePoster)
    currentMoviePoster = moviePoster
    moviePoster.style.opacity = "0"
    moviePoster.style.cursor = "default"
    currentMoviePoster = moviePoster
    document.getElementsByClassName('selected-movie')[0].style.opacity = "0"
    setTimeout(function () {
        document.getElementsByClassName('selected-movie-image')[0].src = movie.poster
        document.getElementsByClassName('selected-movie-title')[0].textContent = movie.title
        document.getElementsByClassName('selected-movie-year')[0].textContent = movie.releaseYear
        document.getElementsByClassName('selected-movie-duration')[0].textContent = "Duration: " + movie.duration
        document.getElementsByClassName('selected-movie-rating')[0].textContent = movie.rating + " / 10"
        document.getElementsByClassName('selected-movie-plot')[0].textContent = movie.plot
        document.getElementsByClassName('selected-movie')[0].style.opacity = "1"
    }, 200)

}

function returnSelectedMovie(moviePoster) {
    if (moviePoster === null) {
        return
    }
    moviePoster.style.opacity = "1"
    moviePoster.style.cursor = "pointer"
}
