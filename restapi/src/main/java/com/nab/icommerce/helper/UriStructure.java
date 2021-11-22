package com.nab.icommerce.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;


/**
 * Simple bean holding a link to a newly POSTed resource.
 *
 * Moved from connectors' framework.
 */
@JsonSerialize(using=UriStructure.UriStructureSerializer.class)
public class UriStructure {
    private final String link;

    /**
     * @param link link to some newly POSTed resource
     */
    public UriStructure(final String link) {
        this.link = link;
    }


    public String getLink() {
        return link;
    }

    
    public static class UriStructureSerializer extends JsonSerializer<UriStructure> {

        @Override
        public void serialize(final UriStructure value, final JsonGenerator jgen, final SerializerProvider provider)
                throws IOException, JsonProcessingException {

            jgen.writeStartObject();
                jgen.writeStringField("uri", value.getLink());
            jgen.writeEndObject();
        }
    }
}
