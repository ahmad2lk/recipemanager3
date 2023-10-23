

export interface Instruction{

  type?: string;
  id?: number;
  description? : string;
  step: {
    id : number
  }
}
