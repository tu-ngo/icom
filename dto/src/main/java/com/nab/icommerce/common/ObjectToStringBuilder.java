package com.nab.icommerce.common;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 * ObjectToStringBuilder enables to create string representation based on fields of an object and exclude specified fields.
 * links field is excluded by default.
 */
public class ObjectToStringBuilder extends ReflectionToStringBuilder {

    private static final String LINKS_FIELD_NAME = "links";

    private ObjectToStringBuilder(Object object) {
        super(object, SHORT_PREFIX_STYLE);
        setExcludeFieldNames(LINKS_FIELD_NAME);
    }

    /**
     * creates String representation of an object using reflection to get fields of an object.
     * links field of an object is ignored by default, allows to specify more fields to be excluded
     *
     * @param object to create String representation for
     * @param excludeFieldNames name of fields of an object to be excluded from String representation
     * @return String representation, which excludes links field by default
     */
    public static String defaultToString(Object object, String... excludeFieldNames) {
        return new ObjectToStringBuilder(object).setExcludeFieldNames(ArrayUtils.add(excludeFieldNames, LINKS_FIELD_NAME))
                                                  .toString();
    }
}
