var currentMoviePoster = null;
if (window.innerWidth > 767) {
    document.getElementsByClassName('poster')[0].onclick()
}

window.addEventListener('resize', function(event){
  if (window.innerWidth > 767 && currentMoviePoster === null) {
      document.getElementsByClassName('poster')[0].onclick()
  }
  if (window.innerWidth < 767) {
      returnSelectedMovie(currentMoviePoster)
      currentMoviePoster = null
  }
});

function displaySelectedMovie(index, movie) {
    if (window.innerWidth > 767) {
        var moviePoster = document.getElementsByClassName('poster')[index];
        if (moviePoster === currentMoviePoster) {
            return
        }
        returnSelectedMovie(currentMoviePoster)
        currentMoviePoster = moviePoster
        moviePoster.style.opacity = "0.2"
        moviePoster.style.cursor = "default"
        moviePoster.classList.add("selected")
        currentMoviePoster = moviePoster
        document.getElementsByClassName('selected-movie')[0].style.opacity = "0"
        setTimeout(function () {
            document.getElementsByClassName('selected-movie-image')[0].src = movie.poster
            document.getElementsByClassName('selected-movie-title')[0].textContent = movie.title
            document.getElementsByClassName('selected-movie-genres')[0].textContent = movie.genres;
            document.getElementsByClassName('selected-movie-year')[0].textContent = movie.releaseYear
            document.getElementsByClassName('selected-movie-duration')[0].textContent = "Duration: " + movie.duration
            document.getElementsByClassName('selected-movie-rating')[0].textContent = movie.rating ? movie.rating + " / 10" : "Not rated"
            document.getElementsByClassName('selected-movie-plot')[0].textContent = movie.plot
            document.getElementsByClassName('selected-movie')[0].style.opacity = "1"
            document.getElementsByClassName('movie-form')[0].action = "/movies/" + movie.id
        }, 200)
    } else {
        window.location.href = "/movies/" + movie.id
    }
}

function returnSelectedMovie(moviePoster) {
    if (moviePoster === null) {
        return
    }
    moviePoster.style.opacity = "1"
    moviePoster.style.cursor = "pointer"
    moviePoster.classList.remove("selected")
}
