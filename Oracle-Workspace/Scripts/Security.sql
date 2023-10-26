create table authority ( -- AUTHORITYxpdl테이블(사용자가 가지게될 권한 목록)
    USER_ID varchar2(20) not null,                               -- 회원아이디
    authority varchar2(20) not null,                    -- 권한
    constraint pk_authority primary key (USER_ID, authority),
    constraint fk_authority_member_id foreign key(USER_ID) references member(USER_ID)
);

INSERT INTO AUTHORITY VALUES('dhckdwjd' , 'ROLE_USER');
INSERT INTO AUTHORITY VALUES('admin' , 'ROLE_USER');
INSERT INTO AUTHORITY VALUES('admin' , 'ROLE_ADMIN');


create table persistent_logins (
    username varchar2(64) not null,
    series varchar2(64) primary key,
    token varchar2(64) not null, -- username, password, expiry time에 대한  hashing값
    last_used timestamp not null
);