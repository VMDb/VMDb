import { Human } from "./human";
import { Country } from "./country";

export class Producer extends Human{
  constructor(public name: string, public country: Country, public dateOfBirth: Date, public careerStart: Date){
    super(name, country, dateOfBirth, careerStart);
  }
}
