export interface Root {
  sId: number
  name: string
  nickname: string
  email: string
  mobile: string
  work: string
  user: User
}

export interface User {
  userId: number
  contacts: any[]
}
