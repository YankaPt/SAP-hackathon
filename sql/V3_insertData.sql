INSERT INTO user(login, password, role) VALUE
  ('Egerag', '1234qwer', 'Role'),
  ('Yan', '5678qwer', 'Role'),
  ('Vlad', '7541', 'Role');

INSERT INTO worker(login, password, role, status) VALUE
  ('Gavrilenko', '1234qwer', 'Role', 'free'),
  ('Poluektov', '5678qwer', 'Role', 'free');

INSERT INTO request_work(login, longitude, latitude, descritption, rait, status) VALUE
  ('1', 123.32, 43.23, 'description kekek', 10.3, 'nothing'),
  ('2', 156.64, 345.23, 'description 2', 23.3, 'nothing');
