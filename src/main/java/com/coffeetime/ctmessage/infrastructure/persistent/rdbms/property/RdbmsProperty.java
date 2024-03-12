package com.coffeetime.ctmessage.infrastructure.persistent.rdbms.property;

public record RdbmsProperty (
        String url,
        String username,
        String password,
        String driverClassName
) {}
