package org.example;

public final class SqlQueries {

    public static final String USERS_YOUNGER_18 = """
             SELECT * FROM users
             WHERE age < 18
            """;

    public static final String FIRST_NAME_FINISHED_WITH_O = """
            SELECT * FROM users
            WHERE first_name LIKE "%o"
            """;

    public static final String USERS_BETWEEN_18_AND_60 = """
             SELECT * FROM users
             WHERE age BETWEEN 18 AND 60
            """;

    public static final String COUNT_FIRST_NAME_CONSIST_O = """
            SELECT COUNT(*) AS UsersCount FROM users
            WHERE first_name LIKE "%a%" OR first_name LIKE "a%" OR first_name LIKE "%a"
            """;

    public static final String USERS_OLDER_THEN_18 = """
             SELECT COUNT(*) AS AdultUsers FROM users
             WHERE age >= 18
            """;
}

