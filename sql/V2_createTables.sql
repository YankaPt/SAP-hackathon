USE hakaton;

CREATE TABLE IF NOT EXISTS user (
  login VARCHAR(50) NOT NULL UNIQUE ,
  password VARCHAR(30),
  role VARCHAR(30),
  PRIMARY KEY(login)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS worker (
  login VARCHAR(50) NOT NULL UNIQUE ,
  password VARCHAR(30),
  role VARCHAR(30),
  status VARCHAR(30),
  PRIMARY KEY(login)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS request_work (
  login VARCHAR(50) NOT NULL UNIQUE,
  longitude DOUBLE,
  latitude DOUBLE,
  descritption VARCHAR(300) NOT NULL,
  rait DOUBLE,
  status VARCHAR(30),
  PRIMARY KEY (login)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS worker_request (
  worker_id VARCHAR(50) NOT NULL,
  request_id VARCHAR(50) NOT NULL,
  PRIMARY KEY(worker_id, request_id),
  FOREIGN KEY (worker_id) REFERENCES worker (login),
  FOREIGN KEY (request_id) REFERENCES request_work (login)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;
