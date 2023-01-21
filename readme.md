## What is the difference between JPA and Hibernate

JPA is an interface, and Hibernate is its default concrete implementation. Other implementations are Toplink and eclipselink

## Difference between SB and spring

SB is better version of spring framework

## Never use @Data when having mappings with other entities

Instead use @Getter and @Setter alone

## Practical Stuffs

### When calling getAllStores endpoint we don't get only stores data instead we get the products data also since it is part of the ManyToMany relationship.

Adding the below annotation would give me only the stores data.

```
@ManyToMany(mappedBy = "stores",fetch = FetchType.LAZY)
@JsonBackReference
private Set<Product> product = new LinkedHashSet<>();
```

### Caused by: org.hibernate.MappingException: Unable to find column with logical name: category_id in org.hibernate.mapping.Table(category) and its related supertables and secondary tables

at org.hibernate.cfg.Ejb3JoinColumn.checkReferencedColumnsType(Ejb3JoinColumn.java:839) ~[hibernate-core-5.6.11.Final.jar:5.6.11.Final]
Add the column name

### How to fix the error **Cannot construct instance of `com.teknos.awscommerce.dto.StoreDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)**

Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.teknos.awscommerce.dto.StoreDto]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.teknos.awscommerce.dto.StoreDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 2, column: 3]] with root cause

com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.teknos.awscommerce.dto.StoreDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 2, column: 3]

```
Added NoArgsConstructor and AllArgsConstructor
```
