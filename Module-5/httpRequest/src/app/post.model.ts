export class Post {
  private _id: number | undefined;
  private _title: string | undefined;
  private _content: string | undefined;


  constructor(id: number, title: string | undefined, content: string | undefined) {
    this._id = id;
    this._title = title;
    this._content = content;
  }


  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  get title(): string | undefined {
    return this._title;
  }

  set title(value: string | undefined) {
    this._title = value;
  }

  get content(): string | undefined {
    return this._content;
  }

  set content(value: string | undefined) {
    this._content = value;
  }
}
