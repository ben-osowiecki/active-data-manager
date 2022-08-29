package com.benosowiecki.activedatamanager.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnixSecondsDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String unixTimestamp = jsonParser.getText().trim();
        return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(unixTimestamp)));
    }
}
