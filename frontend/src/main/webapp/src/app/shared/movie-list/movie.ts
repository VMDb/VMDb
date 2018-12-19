export class Movie {

  // TODO: there is a shrot syntax for having fields but declaraing them in the constructor. For example constructor(public id: number...)
  // TODO: Remove the fields.
  public id: number

  public title: string

  public releaseYear: number

  public duration: number

  public plot: string

  public genres: string

  public rating: number

  public poster: string

  constructor(id: number, title: string, releaseYear: number, duration: number, plot: string, genres: string, rating: number, poster: string) {
    this.id = id
    this.title = title
    this.releaseYear = releaseYear
    this.duration = duration
    this.plot = plot
    this.genres = genres
    this.rating = rating
    this.poster = poster
  }


}
