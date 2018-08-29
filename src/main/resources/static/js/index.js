var currentMoviePoster = null;



function displaySelectedMovie(index, movie) {
    console.log(movie)
    var moviePoster = document.getElementsByClassName('poster')[index];
    returnSelectedMovie(currentMoviePoster)
    currentMoviePoster = moviePoster
    moviePoster.style.transition = "1s all"
    moviePoster.style.opacity = "0"
    //returnSelectedMovie(currentMoviePoster)
    currentMoviePoster = moviePoster
    document.getElementsByClassName('selected-movie-image')[0].src = movie.poster
}

function displaySelectedMovie2(index, movie) {
    console.log(movie)
    var moviePoster = document.getElementsByClassName('poster')[index];
    returnSelectedMovie(currentMoviePoster)
    currentMoviePoster = moviePoster
    moviePoster.style['padding-top'] = "0"
    moviePoster.style.right = window.innerWidth - moviePoster.getBoundingClientRect().right + "px"
    moviePoster.style.width = moviePoster.clientWidth + "px"
    moviePoster.style.height = moviePoster.clientHeight + "px"
    moviePoster.style.transition = "1s all"
    moviePoster.style.position = "absolute"
    moviePoster.style['z-index'] = "5"
    setTimeout(() => {
        moviePoster.style.width = "300px"
        moviePoster.style.height = "444px"
        moviePoster.style.right = "100px"
    }, 5)
}

function returnSelectedMovie(moviePoster) {
    if (moviePoster === null) {
        return
    }
    moviePoster.style['padding-top'] = "148%"
    moviePoster.style.right = "0"
    moviePoster.style.width = "initial"
    moviePoster.style.height = "initial"
    moviePoster.style.position = "relative"
    moviePoster.style['z-index'] = "0"
    moviePoster.style.transition = "none"
}
