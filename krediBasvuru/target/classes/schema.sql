DROP TABLE IF EXISTS credit_person_info;
 
CREATE TABLE credit_person_info (
  id VARCHAR(11) not null,   
  name VARCHAR(250),            
  phone_number number,          
  salary number,
  credit_score varchar2(4) not null,           
  credit_limit  number,      
  error varchar2(1000),  
  sys_date date default sysdate 
);

