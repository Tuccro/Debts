package com.tuccro.debts.db;


public interface IDBStrings {

    String DB_CREATE_TABLE_PEOPLE = "CREATE TABLE `people` (\n" +
            "\t`_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE,\n" +
            "\t`phone`\tTEXT,\n" +
            "\t`date_of_create`\tTEXT NOT NULL\n" +
            ");";

}
