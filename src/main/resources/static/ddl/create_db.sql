-- DB名：ISDashBoard
-- ユーザー名：root
-- パスワード：tkznemou19
-- テーブル：USER, INFO, SCDL, PFMC, STNG


-- 旧テーブル削除
DROP TABLE USER;
DROP TABLE INFO;
DROP TABLE SCDL;
DROP TABLE PFMC;
DROP TABLE STNG;


-- USERテーブル
CREATE TABLE USER(
    USERNU int          AUTO_INCREMENT PRIMARY KEY COMMENT "ユーザー番号",
    USERID varchar(32)  NOT NULL UNIQUE            COMMENT "ユーザーID",
    PASSWD varchar(32)  NOT NULL                   COMMENT "パスワード",
    EMLADR varchar(100) NOT NULL UNIQUE            COMMENT "メールアドレス",
    NUMBER varchar(13)  NOT NULL UNIQUE            COMMENT "携帯電話番号",
    ETDTTM timestamp    DEFAULT CURRENT_TIMESTAMP  COMMENT "入力日時"
);

INSERT INTO USER(USERID,PASSWD,EMLADR,NUMBER) VALUE('a','a','bsuser@b-stage.co.jp','090-1234-5678');

-- INFOテーブル
CREATE TABLE INFO(
    INFOID int           AUTO_INCREMENT PRIMARY KEY COMMENT "連絡ID",
    SENDER varchar(32)   NOT NULL                   COMMENT "発信者名",
    INFOCT varchar(8000) NOT NULL                   COMMENT "連絡内容",
    ETDTTM timestamp(0)  DEFAULT CURRENT_TIMESTAMP  COMMENT "入力日時",
    UDDTTM timestamp(0)  DEFAULT CURRENT_TIMESTAMP  COMMENT "更新日時"
);

-- SCDLテーブル
CREATE TABLE SCDL(
    SCDLID int           AUTO_INCREMENT PRIMARY KEY COMMENT "予定ID",
    DATETM varchar(100)  NOT NULL                   COMMENT "予定時間",
    SENDER varchar(32)   NOT NULL                   COMMENT "発信者名",
    SCDLCT varchar(8000) NOT NULL                   COMMENT "予定内容",
    ETDTTM timestamp(0)  DEFAULT CURRENT_TIMESTAMP  COMMENT "入力日時",
    UDDTTM timestamp(0)  DEFAULT CURRENT_TIMESTAMP  COMMENT "更新日時"
);

-- PFMCテーブル
CREATE TABLE PFMC(
    PFMCID int           AUTO_INCREMENT PRIMARY KEY COMMENT "実績ID",
    TASKID int           NOT NULL                   COMMENT "タスクID",
    DATETM varchar(100)  NOT NULL                   COMMENT "実績日付",
    PRDTCT varchar(100)  NOT NULL                   COMMENT "工数(時間)",
    SENDER varchar(32)   NOT NULL                   COMMENT "発信者名",
    PFMCCT varchar(8000) NOT NULL                   COMMENT "実績内容",
    ETDTTM timestamp(0)  DEFAULT CURRENT_TIMESTAMP  COMMENT "入力日時",
    UDDTTM timestamp(0)  DEFAULT CURRENT_TIMESTAMP  COMMENT "更新日時"
);

-- STNGテーブル
CREATE TABLE STNG(
    USERNU int          PRIMARY KEY                COMMENT "ユーザー番号",
    INFORO int          NOT NULL                   COMMENT "連絡事項表示行数",
    SCDLRO int          NOT NULL                   COMMENT "予定表示行数",
    TASKRO int          NOT NULL                   COMMENT "タスク表示行数",
    ETDTTM timestamp(0) DEFAULT CURRENT_TIMESTAMP  COMMENT "入力日時",
    UDDTTM timestamp(0) DEFAULT CURRENT_TIMESTAMP  COMMENT "更新日時"
);
