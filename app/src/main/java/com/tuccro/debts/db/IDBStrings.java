package com.tuccro.debts.db;

import com.tuccro.debts.R;

public interface IDBStrings {

    String DB_TABLE_PEOPLE = "people";
    String DB_TABLE_MONEY = "money";
    String DB_TABLE_CURRENCY = "currency";
    String DB_TABLE_STATUS = "status";

    String DB_TABLE_ID = "_id";

    String DB_CREATE_TABLE_PEOPLE = "CREATE TABLE `people` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE,\n" +
            "\t`phone`\tTEXT,\n" +
            "\t`date_of_create`\tTEXT NOT NULL\n" +
            "\t`visible`\tINTEGER NOT NULL,\n" +
            ");";

    String DB_CREATE_TABLE_MONEY = "CREATE TABLE `money` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`people_id`\tINTEGER NOT NULL,\n" +
            "\t`currency_id`\tINTEGER NOT NULL,\n" +
            "\t`sum`\tREAL NOT NULL,\n" +
            "\t`note`\tTEXT,\n" +
            "\t`date_add`\tTEXT NOT NULL,\n" +
            "\t`date_begin`\tTEXT,\n" +
            "\t`date_end`\tTEXT,\n" +
            "\t`status_id`\tINTEGER NOT NULL,\n" +
            "\t`visible`\tINTEGER NOT NULL,\n" +
            "\tFOREIGN KEY (people_id) REFERENCES people(_id) ON DELETE CASCADE,\n" +
            "\tFOREIGN KEY (currency_id) REFERENCES currency(_id) ON DELETE CASCADE,\n" +
            "\tFOREIGN KEY (status_id`) REFERENCES status(_id)\n" +
            ");";

    String DB_CREATE_TABLE_CURRENCY = "CREATE TABLE `currency` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE\n" +
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

}
