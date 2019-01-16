import { Genre } from "./genre";
import { Writer } from "./writer";
import { Director } from "./director";
import { Producer } from "./producer";
import { Country } from "./country";
import { Actor } from "./actor";

export class MovieForm{

    constructor(public title: string, public releaseDate: Date, public duration: number, public actors: Actor[],public genres: Genre[], public writers: Writer[], public directors: Director[], public producers: Producer[], public country: Country, public plot: string, public posterUrl: string, public ratingCombined: number, public ratings: number){}
}