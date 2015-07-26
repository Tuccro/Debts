package com.tuccro.debts.db;

public interface IDBStrings {

    String DB_NAME = "debts.db";
    int DB_VERSION = 1;

    String DB_TABLE_PEOPLE = "people";
    String DB_TABLE_MONEY = "money";
    String DB_TABLE_CURRENCY = "currency";
    String DB_TABLE_STATUS = "status";

    String DB_TABLE_ID = "_id";

    String DB_PEOPLE_ID = DB_TABLE_ID;
    String DB_PEOPLE_NAME = "name";
    String DB_PEOPLE_PHONE = "phone";
    String DB_PEOPLE_DATE_OF_CREATE = "date_of_create";

    String DB_MONEY_ID = DB_TABLE_ID;
    String DB_MONEY_HUMAN_ID = "people_id";
    String DB_MONEY_CURRENCY_ID = "currency_id";
    String DB_MONEY_SUM = "sum";
    String DB_MONEY_NOTE = "note";
    String DB_MONEY_DATE_ADD = "date_add";
    String DB_MONEY_DATE_BEGIN = "date_begin";
    String DB_MONEY_DATE_END = "date_end";


    String DB_CREATE_TABLE_PEOPLE = "CREATE TABLE `people` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE,\n" +
            "\t`phone`\tTEXT,\n" +
            "\t`date_of_create`\tINTEGER NOT NULL,\n" +
            "\t`visible`\tINTEGER NOT NULL\n" +
            ");";

    String DB_CREATE_TABLE_MONEY = "CREATE TABLE `money` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`people_id`\tINTEGER NOT NULL,\n" +
            "\t`currency_id`\tINTEGER NOT NULL,\n" +
            "\t`sum`\tREAL NOT NULL,\n" +
            "\t`note`\tTEXT,\n" +
            "\t`date_add`\tINTEGER NOT NULL,\n" +
            "\t`date_begin`\tINTEGER,\n" +
            "\t`date_end`\tINTEGER,\n" +
            "\t`visible`\tINTEGER NOT NULL,\n" +
            "\tFOREIGN KEY (people_id) REFERENCES people(_id) ON DELETE CASCADE,\n" +
            "\tFOREIGN KEY (currency_id) REFERENCES currency(_id) ON DELETE CASCADE,\n" +
            ");";

    String DB_CREATE_TABLE_CURRENCY = "CREATE TABLE `currency` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE,\n" +
            "\t`visible`\tINTEGER NOT NULL\n" +
            ");";

    String DB_CREATE_TABLE_STATUS = "CREATE TABLE `status` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tINTEGER\n" +
            ");";

    String DB_INSERT_CURRENCY_VALUES = "INSERT INTO `currency`(`name`,`visible`) \n" +
            "VALUES ('UAH',1), ('USD',1), ('EUR',1), ('RUB',1), ('GBP',1), ('BYR',1);";

    String DB_INSERT_STATUS_VALUES = "INSERT INTO `status`(`name`) \n" +
            "VALUES ('new'), ('active'), ('archive'), ('deleted');";

    String DB_INSERT_PEOPLE = "INSERT INTO `people`(`name`,`phone`,`date_of_create`,`visible`) " +
            "VALUES ('Alex',380504445521,'15.05.15',1)," +
            "('Max',380674445521,'14.05.15',1);";
}
