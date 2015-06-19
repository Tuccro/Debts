package com.tuccro.debts.db;

public interface IDBStrings {

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
            ");";

    String DB_CREATE_TABLE_STATUS = "CREATE TABLE `status` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tINTEGER\n" +
            ");";
}
