package com.nab.icommerce.dto

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.joda.JodaModule
import spock.lang.Specification
import spock.lang.Unroll

import static com.nab.icommerce.dto.JsonFileHelper.getJsonFromFile
import static com.nab.icommerce.dto.TestUtils.normalizeJsonString

class DtoTest extends Specification {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
    static {
        OBJECT_MAPPER.registerModule(new JodaModule());
    }

    private static String getResourcePath(Class dtoClass) {
        return dtoClass.getSimpleName() + '.json'
    }

//    @Unroll
//    def "print" (){
//        given:
//        def dto = new Account("userName", true, "password", "customer", DateTime.now())
//        def json = OBJECT_MAPPER.writeValueAsString(dto)
//        System.out.println(json)
//
//        when:
//
//        then:
//
//        where:
//        testName                                | dtoClass
//        1 | 1
//    }

    @Unroll
    def "POSITIVE -- should serialize/deserialize success for DTO class #testName"() {
        given:
        def dtoJsonResourcePath = getResourcePath(dtoClass)
        def dtoJson = getJsonFromFile(dtoJsonResourcePath)

        when:
        def dto = OBJECT_MAPPER.readValue(dtoJson, dtoClass)
        def deserialized = OBJECT_MAPPER.writeValueAsString(dto)
        def toStringEx
        try {
            dto.toString()
        } catch (Exception ex) {
            toStringEx = ex
        }

        then:
        normalizeJsonString(dtoJson) == normalizeJsonString(deserialized)
        toStringEx == null

        where:
        testName                              | dtoClass
        Brand.class.getSimpleName()           | Brand.class
        Color.class.getSimpleName()           | Color.class
        Category.class.getSimpleName()        | Category.class
        Account.class.getSimpleName()         | Account.class
        Order.class.getSimpleName()           | Order.class
        OrderDetail.class.getSimpleName()     | OrderDetail.class
        Price.class.getSimpleName()           | Price.class
        Product.class.getSimpleName()         | Product.class
        ProductBrand.class.getSimpleName()    | ProductBrand.class
        ProductCategory.class.getSimpleName() | ProductCategory.class
        ProductColor.class.getSimpleName()    | ProductColor.class
    }


    @Unroll
    def "NEGATIVE -- should serialize/deserialize failed for DTO class #testName"() {
        given:

        when:
        def exceptionThrown
        try {
            def dtoJson = getJsonFromFile(dtoJsonResourcePath)
            OBJECT_MAPPER.readValue(dtoJson, dtoClass)
        } catch (Exception ex) {
            exceptionThrown = ex
        }

        then:
        exceptionThrown.cause in expectedException
        exceptionThrown.getMessage() =~ expectedMsgReg

        where:
        testName                            | dtoClass    | dtoJsonResourcePath                 | expectedException        | expectedMsgReg
        'Brand code is empty'               | Brand.class | 'Brand__code_empty.json'            | IllegalArgumentException | /.*code\scan\snot\sbe\sempty.*/
        'Brand name is empty'               | Brand.class | 'Brand__name_empty.json'            | NullPointerException     | /.*name\scan\snot\sbe\sempty.*/
        'Brand description is empty'        | Brand.class | 'Brand__description_empty.json'     | NullPointerException     | /.*description\scan\snot\sbe\snull.*/
        'Price__price_cannot_negative.json' | Price.class | 'Price__price_cannot_negative.json' | IllegalArgumentException | /.*price\scan\snot\sbe\sa\snegative\snumber.*/

        // TODO: Add nagetive case for other DTOs: check empty, null, negative,...
    }
}
