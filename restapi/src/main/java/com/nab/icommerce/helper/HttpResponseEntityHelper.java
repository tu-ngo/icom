package com.nab.icommerce.helper;

import java.net.URI;

import org.apache.commons.lang3.Validate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Utils for manipulating with {@link ResponseEntity}
 */
public final class HttpResponseEntityHelper {

    private HttpResponseEntityHelper() {
        // nothing
    }

    /**
     * Creates new {@link ResponseEntity} instance without a body, with the Location header set to given <code>location</code>.
     * 
     * @param location link to some resource
     * @return new response entity with status set to 204 No Content and Location header set to the link param value
     * @throws IllegalArgumentException if <code>location</code> is empty
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ResponseEntity<Object> createNoContentHttpEntityWithLocation(final String location) {
        final HttpHeaders headers = createLocationHeader(location);
        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    /**
     * Creates new {@link ResponseEntity} instance with body set to the specified <code>value</code>,
     * Location header set to given <code>location</code> and given http status.
     * 
     * @param value as body of response
     * @param location link to some resource
     * @param status as http status for response
     * @return new response entity with status set to 204 No Content and Location header set to the link param value
     * @throws IllegalArgumentException if <code>location</code> is empty
     */
    public static <T> ResponseEntity<T> createHttpEntityWithLocation(T value, final String location, HttpStatus status) {
        final HttpHeaders headers = createLocationHeader(location);
        return new ResponseEntity<T>(value, headers, status);
    }

    /**
     * @param location link to some resource
     * @return new UriStructure instance wrapped in a HttpEntity wrapper. Both the UriStructure
     * link and the Location header are set to the location param value
     *
     * Moved from connectors' framework.
     */
    public static HttpEntity<UriStructure> createWrappedUriStructure(final String location) {
        return new HttpEntity<UriStructure>(new UriStructure(location), createLocationHeader(location));
    }


    /**
     * @param location link to some resource
     * @param status response status
     * @return new UriStructure instance wrapped in a HttpEntity wrapper. Both the UriStructure
     * link and the Location header are set to the location param value
     *
     * Moved from connectors' framework.
     */
    public static ResponseEntity<UriStructure> createWrappedUriStructure(final String location, final HttpStatus status) {
        return createHttpEntityWithLocation(new UriStructure(location), location, status);
    }


    /**
     * Wraps the given object in a HttpEntity instance and sets a http Location header to it.
     * @param <T> type of the object to be wrapped in a HttpEntity instance
     * @param object an object to be wrapped in a HttpEntity instance
     * @param location location header to be set to the created HttpEntity instance
     * @return the given object wrapped in a HttpEntity instance
     *
     * Moved from connectors' framework.
     */
    public static <T> HttpEntity<T> wrapAndAddLocationHeader(final T object, final String location) {
        return new HttpEntity<T>(object, createLocationHeader(location));
    }


    /*
     * Create new location header for given location.
     */
    static HttpHeaders createLocationHeader(String location) {
        Validate.notEmpty("location for location header can't be empty", location);

        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(location));

        return headers;
    }
}
