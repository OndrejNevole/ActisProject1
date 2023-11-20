export interface DbData {
  apiAddress : string;
  dbAddress : string;
  username : string;
  password : string;
}

export const DbData = [{
  apiAddress: 'localhost:8080/TrialDb/',
  dbAddress: 'jdbc:postgresql://localhost:5432/TrialDB',
  username: 'postgres',
  password: '000'
}];
